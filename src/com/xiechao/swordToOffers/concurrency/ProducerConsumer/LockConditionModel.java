package com.xiechao.swordToOffers.concurrency.ProducerConsumer;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName LockConditionModel
 * @Author xiechao
 * @Date 2019/3/4
 * @Time 16:10
 * @Description TODO
 */
public class LockConditionModel implements Model {
    private final ReentrantLock BUFFER_LOCK = new ReentrantLock();
    private final Condition NOT_EMPTY = BUFFER_LOCK.newCondition();
    private final Condition NOT_FULL = BUFFER_LOCK.newCondition();
    private final AtomicInteger taskInc = new AtomicInteger(0);
    private final int cap;
    private final Queue<Task> queue = new LinkedList<>();

    public LockConditionModel(int cap) {
        this.cap = cap;
    }


    @Override
    public Runnable newRunnableConsumer() {
        return new ProducerImpl();
    }

    @Override
    public Runnable newRunnableProduer() {
        return new ConsumerImpl();
    }

    private class ConsumerImpl extends AbstractConsumer{
        @Override
        public void consume() throws InterruptedException {
            BUFFER_LOCK.lock();
            try {
                while (queue.size() == 0)
                    NOT_EMPTY.await();
                Thread.sleep(500 + (long)(Math.random() * 500));
                Task task = queue.poll();
                System.out.println(Thread.currentThread().getName() + ", Consume: " + task.id + ", bufferSize: " + queue.size());
                NOT_FULL.signalAll();
            }catch (InterruptedException e) {
                e.printStackTrace();
                throw new InterruptedException(e.toString());
            }finally{
                BUFFER_LOCK.unlock();
            }
        }
    }
    private class ProducerImpl extends AbstractProduer{
        @Override
        public void produe() throws InterruptedException {
            BUFFER_LOCK.lock();
            try{
                while(cap == queue.size())
                    NOT_FULL.await();
                Thread.sleep(300 + (long)(Math.random() * 300));
                Task task = new Task(taskInc.getAndIncrement());
                queue.offer(task);
                System.out.println(Thread.currentThread().getName() +", Produe: " + task.id + ", bufferSize: " + queue.size());
                NOT_EMPTY.signalAll();
            }catch(InterruptedException e){
                e.printStackTrace();
                throw new InterruptedException(e.toString());
            }finally{
                BUFFER_LOCK.unlock();
            }
        }
    }
    public static void main(String...args){
        Model model = new LockConditionModel(4);
        for (int i = 0; i < 10; i++) {
            new Thread(model.newRunnableProduer()).start();
        }
        for (int i = 0; i < 5; i++) {
            new Thread(model.newRunnableConsumer()).start();
        }

    }

}
