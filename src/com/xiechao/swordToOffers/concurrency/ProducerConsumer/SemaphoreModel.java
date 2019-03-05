package com.xiechao.swordToOffers.concurrency.ProducerConsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName SemaphoreModel
 * @Author xiechao
 * @Date 2019/3/4
 * @Time 16:33
 * @Description TODO
 */
public class SemaphoreModel implements Model {

    private final Semaphore NOT_FULL;
    private final Semaphore NOT_EMPTY = new Semaphore(0);
    private final Semaphore MUTEX = new Semaphore(1);
    //private final int cap;
    private final Queue<Task> queue = new LinkedList<>();
    private final AtomicInteger taskInc = new AtomicInteger(0);

    public SemaphoreModel(int cap) {
      //  this.cap = cap;
        NOT_FULL = new Semaphore(cap);
    }

    @Override
    public Runnable newRunnableConsumer() {
        return  new ConsumerImpl();
    }

    @Override
    public Runnable newRunnableProduer() {
        return new ProduerImpl();
    }
    private class ProduerImpl extends AbstractProduer{
        @Override
        public void produe() throws InterruptedException {
            try {
                NOT_FULL.acquire();
                MUTEX.acquire();  //颠倒顺序导致私锁
                Thread.sleep(300 + (long) (Math.random() * 300));
                Task task = new Task(taskInc.getAndIncrement());
                queue.offer(task);
                System.out.println(Thread.currentThread().getName() +", Produe: " + task.id + ", bufferSize: " + queue.size());
            }catch (InterruptedException e){
                e.printStackTrace();
                throw new InterruptedException(e.toString());
            }finally {
                MUTEX.release();
                NOT_EMPTY.release();
            }
        }
    }
    private class ConsumerImpl extends AbstractConsumer{
        @Override
        public void consume() throws InterruptedException {
            try{
                NOT_EMPTY.acquire();
                MUTEX.acquire();
                Task task = queue.poll();
                Thread.sleep(500 + (long) (Math.random() * 500));
                System.out.println(Thread.currentThread().getName() +", Consume: " + task.id + ", bufferSize: " + queue.size());
            }catch(InterruptedException e){
                e.printStackTrace();
                throw new InterruptedException(e.toString());
            }finally {
                MUTEX.release();
                NOT_FULL.release();
            }
        }
    }

    public static void main(String...args){
        Model model = new SemaphoreModel(4);
        for (int i = 0; i < 10 ; i++) {
            new Thread(model.newRunnableProduer()).start();
        }
        for (int i = 0; i < 4; i++) {
            new Thread(model.newRunnableConsumer()).start();
        }
    }



}
