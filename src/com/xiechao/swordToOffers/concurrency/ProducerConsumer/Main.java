package com.xiechao.swordToOffers.concurrency.ProducerConsumer;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ClassName Main
 * @Author xiechao
 * @Date 2019/3/4
 * @Time 15:19
 * @Description TODO
 */
public class Main {
    public static void main(String...args){
        Model model = new WaitNotifyModel(5);
        for (int i = 0; i < 8 ; i++) {
            new Thread(model.newRunnableProduer()).start();
        }
        for (int i = 0; i < 4 ; i++) {
            new Thread(model.newRunnableConsumer()).start();
        }
    }
}
