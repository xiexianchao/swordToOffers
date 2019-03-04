package com.xiechao.swordToOffers.concurrency.ABC;

/**
 * @ClassName Job3
 * @Author xiechao
 * @Date 2019/2/28
 * @Time 20:31
 * @Description TODO
 */
public class Job3 {
    static boolean isThreadA = true;
    static boolean isThreadB = false;
    static boolean isThreadC = false;

    public static void main(String...agrs){
        Object lock = new Object();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    for (int i = 0; i < 10; i++) {
                        while(!isThreadA){
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println("A");
                        isThreadA = false;
                        isThreadB = true;
                        isThreadC = false;
                        lock.notifyAll();
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    for (int i = 0; i < 10; i++)
                    {
                        while (!isThreadB) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    System.out.println("B");
                    isThreadA = false;
                    isThreadB = false;
                    isThreadC = true;
                    lock.notifyAll();
                }
            }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    for (int i = 0; i < 10; i++) {
                        while (!isThreadC) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println("C");
                        isThreadA = true;
                        isThreadB = false;
                        isThreadC = false;
                        lock.notifyAll();
                    }
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();


    }




}
