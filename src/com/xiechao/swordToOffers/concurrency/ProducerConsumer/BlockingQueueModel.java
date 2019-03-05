package com.xiechao.swordToOffers.concurrency.ProducerConsumer;

import org.junit.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName BlockingQueueModel
 * @Author xiechao
 * @Date 2019/3/4
 * @Time 15:41
 * @Description TODO
 */
public class BlockingQueueModel implements Model {
    private final BlockingQueue<Task> queue;
    private final AtomicInteger taskInc = new AtomicInteger(0);

    public BlockingQueueModel(int cap) {
        this.queue = new LinkedBlockingQueue<>(cap);
    }

    @Override
    public Runnable newRunnableConsumer() {
        return new ConsumerImpl();
    }

    @Override
    public Runnable newRunnableProduer() {
        return new ProducerImpl();
    }

    private class ProducerImpl extends AbstractProduer{
        @Override
        public void produe() throws InterruptedException {
            Thread.sleep(300);
            Task task = new Task(taskInc.getAndIncrement());
            queue.put(task);
            System.out.println(Thread.currentThread().getName() +", Produe: " + task.id + ", bufferSize: " + queue.size());
        }
    }

    private class ConsumerImpl extends AbstractConsumer{
        @Override
        public void consume() throws InterruptedException {
            Task task = queue.take();
            Thread.sleep(500);
            System.out.println(Thread.currentThread().getName() +", Consume: " + task.id + ", bufferSize: " + queue.size());
        }
    }


    public static void  main(String...args){
        Model model = new BlockingQueueModel(4);
        for (int i = 0; i < 4 ; i++) {
            new Thread(model.newRunnableConsumer()).start();
        }
        for (int i = 0; i < 2 ; i++) {
            new Thread(model.newRunnableProduer()).start();
        }

    }
}
