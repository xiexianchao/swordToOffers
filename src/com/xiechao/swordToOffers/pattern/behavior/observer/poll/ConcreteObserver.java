package com.xiechao.swordToOffers.pattern.behavior.observer.poll;



/**
 * @ClassName ConcreteObserver
 * @Author xiechao
 * @Date 2019/4/2
 * @Time 10:50
 * @Description TODO
 */
public class ConcreteObserver implements Observer {
    private String observerState;


    @Override
    public void update(Subject subject) {
        observerState = subject.getState();
        System.out.println("观察者状态为 ： " + observerState);
    }
}
