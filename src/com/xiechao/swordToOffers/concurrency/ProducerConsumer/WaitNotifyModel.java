package com.xiechao.swordToOffers.concurrency.ProducerConsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName WaitNotifyModel
 * @Author xiechao
 * @Date 2019/3/4
 * @Time 15:12
 * @Description TODO
 */
public class WaitNotifyModel implements Model {
    private static final Object BUFFER_LOCK = new Object();
    private Queue<Task> buffer = new LinkedList<>();
    private int cap = 0;
    private AtomicInteger taskInc = new AtomicInteger(0);

    public WaitNotifyModel(int cap) {
        this.cap = cap;
    }

    @Override
    public Runnable newRunnableConsumer() {
        return new ProduerImpl();
    }

    @Override
    public Runnable newRunnableProduer() {
        return new ConsumerImpl();
    }

    private class ProduerImpl extends AbstractProduer{
        @Override
        public void produe() throws InterruptedException {
            synchronized(BUFFER_LOCK){
                while(buffer.size() == cap){
                    BUFFER_LOCK.wait();
                }
                Thread.sleep(300);
                Task task = new Task(taskInc.getAndIncrement());
                buffer.offer(task);
                System.out.println(Thread.currentThread().getName() +", Produe: " + task.id + ", bufferSize: " + buffer.size());
                BUFFER_LOCK.notifyAll();
            }
        }
    }
    private class ConsumerImpl extends AbstractConsumer{
        @Override
        public void consume() throws InterruptedException {
            synchronized(BUFFER_LOCK){
                while(buffer.size() == 0){
                    BUFFER_LOCK.wait();
                }
                Task task = buffer.poll();
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName() +", Consume: " + task.id + ", bufferSize: " + buffer.size());
                BUFFER_LOCK.notifyAll();
            }
        }
    }
}
