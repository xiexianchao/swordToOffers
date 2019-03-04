package com.xiechao.swordToOffers.concurrency.ABC;

import java.util.concurrent.Semaphore;

/**
 * @ClassName Job6
 * @Author xiechao
 * @Date 2019/2/28
 * @Time 21:22
 * @Description TODO
 */

//使用信号量来完成，代码简洁
public class Job6 implements Runnable{
    private Semaphore preCond;
    private Semaphore postCond;
    private String name;
    public Job6(Semaphore preCond, Semaphore postCond,String name){
        this.postCond = postCond;
        this.preCond = preCond;
        this.name = name;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                preCond.acquire();
                System.out.println(this.name);
                postCond.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String...args){
        Semaphore semaphoreA = new Semaphore(0);
        Semaphore semaphoreB = new Semaphore(0); //即初始使许可为0，release之后也会+1
        Semaphore semaphoreC = new Semaphore(1);

        Thread t1 = new Thread(new Job6(semaphoreC,semaphoreA,"A"));
        Thread t2 = new Thread(new Job6(semaphoreA,semaphoreB, "B"));
        Thread t3 = new Thread(new Job6(semaphoreB,semaphoreC,"C"));

        t1.start();
        t2.start();
        t3.start();

    }


}
