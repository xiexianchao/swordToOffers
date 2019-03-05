package com.xiechao.swordToOffers.concurrency.ProducerConsumer;

/**
 * @ClassName AbstractProduer
 * @Author xiechao
 * @Date 2019/3/4
 * @Time 15:09
 * @Description TODO
 */
public abstract class AbstractProduer implements Producer,Runnable {
    @Override
    public void run() {
        while(true){
            try {
                produe();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
