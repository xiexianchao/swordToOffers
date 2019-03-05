package com.xiechao.swordToOffers.concurrency.ProducerConsumer;

public interface Model {
    Runnable newRunnableConsumer();
    Runnable newRunnableProduer();
}
