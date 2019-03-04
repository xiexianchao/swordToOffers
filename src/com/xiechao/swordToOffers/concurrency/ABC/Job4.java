package com.xiechao.swordToOffers.concurrency.ABC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName Job4
 * @Author xiechao
 * @Date 2019/2/28
 * @Time 20:40
 * @Description TODO
 */
public class Job4 {
    //我写的，烂的要死
    public static void main(String...agrs) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Condition A = lock.newCondition();
        Condition B = lock.newCondition();
        Condition C = lock.newCondition();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int count = 0;
                while(count < 10) {
                    lock.lock();
                    try {
                        C.await();
                        System.out.println("A");
                        A.signalAll();
                        count++;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        lock.unlock();
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int count = 0;
                while(count < 10) {
                    lock.lock();
                    try {
                        A.await();
                        System.out.println("B");
                        B.signalAll();
                        count++;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        lock.unlock();
                    }
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                int count = 0;
                while(count < 10) {
                    lock.lock();
                    try {
                        B.await();
                        System.out.println("C");
                        C.signalAll();
                        count++;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        lock.unlock();
                    }
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();

        Thread.sleep(100);
        lock.lock();
        C.signalAll();
        lock.unlock();
    }



}
