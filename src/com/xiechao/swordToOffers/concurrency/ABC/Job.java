package com.xiechao.swordToOffers.concurrency.ABC;

/**
 * @ClassName ABCThread
 * @Author xiechao
 * @Date 2019/2/28
 * @Time 20:00
 * @Description:有三个线程分别打印A,B,C，写一个程序打印ABCABCABC...
 *
 */
public class Job{
    int count = 0;
    public static void main(String[] args){
        new Job().start();
    }
    public void start(){
        new JobThread("A",0).start();
        new JobThread("B",1).start();
        new JobThread("C",2).start();
        
    }
     void doJob(int id){
        if(count % 3 == id){
            System.out.println(Thread.currentThread().getName());
            count++;
            notifyAll();
        }else{
         try{
             wait();
         }catch (Throwable e){
             e.printStackTrace();
         }
        }
    }
    
    private class JobThread extends Thread{
        int id ;
        public JobThread(String name,int id){
            super(name);
            this.id = id;
        }
        public void run(){
            while(Job.this.count < 30){
                Job.this.doJob(id);
               // yield();
            }
        }
    }
}
