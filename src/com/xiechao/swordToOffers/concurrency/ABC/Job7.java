package com.xiechao.swordToOffers.concurrency.ABC;

/**
 * @ClassName Job7
 * @Author xiechao
 * @Date 2019/2/28
 * @Time 22:25
 * @Description TODO
 */
public class Job7 implements Runnable{
    public static void main(String...args){
        Thread t1= new Thread(new Job7(0,"A"));
        Thread t2 = new Thread(new Job7(1,"B"));
        Thread t3 = new Thread(new Job7(2,"C"));
        t1.start();
        t2.start();
        t3.start();
    }

    private int id;
    private String name;

    public Job7(int id, String name) {
        this.id = id;
        this.name = name;
    }
    private static Object o = new Object();
    private int num = 0;
    private static int count = 0;
    @Override
    public void run() {
        synchronized(o){
            while(num < 10){
                if(count % 3 == id){
                    count++;
                    num++;
                    System.out.println(name);
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
}
