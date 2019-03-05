package com.xiechao.swordToOffers.concurrency.ProducerConsumer;

/**
 * @ClassName AbstractConsumer
 * @Author xiechao
 * @Date 2019/3/4
 * @Time 15:08
 * @Description TODO
 */
public abstract class AbstractConsumer implements Consumer,Runnable {
    @Override
    public void run() {
       while(true){
           try{
               consume();
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
    }
}
