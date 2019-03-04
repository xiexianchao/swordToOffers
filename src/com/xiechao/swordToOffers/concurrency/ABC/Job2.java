package com.xiechao.swordToOffers.concurrency.ABC;

import java.io.ObjectOutputStream;

/**
 * @ClassName Job2
 * @Author xiechao
 * @Date 2019/2/28
 * @Time 20:18
 * @Description TODO
 */

//线程A要在C完成后唤醒，A完成后唤醒B线程，B线程完成后唤醒C线程，C完成后唤醒A线程
public class Job2 implements Runnable{
    private String name;
    private final Object prev;
    private final Object self;

    public Job2(String name,Object prev,Object self){
        this.name = name;
        this.prev = prev;
        this.self = self;
    }

    @Override
    public void run() {
        int count = 10;
        while(count > 0){
            synchronized(prev) {
                synchronized (self) {
                    System.out.println(name);
                    count--;
                    self.notify();
                }
                try {
                    prev.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        new Thread(new Job2("A",c,a)).start();
        Thread.sleep(100);
        new Thread(new Job2("B",a,b)).start();
        Thread.sleep(100);
        new Thread(new Job2("C",b,c)).start();
        Thread.sleep(100);


    }


}
