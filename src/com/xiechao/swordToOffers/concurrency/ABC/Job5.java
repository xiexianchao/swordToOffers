package com.xiechao.swordToOffers.concurrency.ABC;

/**
 * @ClassName Job5
 * @Author xiechao
 * @Date 2019/2/28
 * @Time 21:09
 * @Description TODO
 */
public class Job5 implements Runnable{
    private static Object o = new Object();
    private static int count = 0;
    private char ID;
    private int id;
    private int num = 0;

    public Job5(int id,char ID){
        this.ID = ID;
        this.id = id;
    }
    @Override
    public void run() {
        synchronized(o){
            while(num < 10){
                if(count % 3 == id){
                    System.out.println(ID);
                    count++;
                    num++;
                    o.notifyAll();
                }else{
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String...args){
        Thread t1 = new Thread(new Job5(0, 'A'));
        Thread t2 = new Thread(new Job5(1,'B'));
        Thread t3 = new Thread(new Job5(2,'C'));
        t1.start();
        t2.start();
        t3.start();
    }
}
