package com.xiechao.swordToOffers.pattern.behavior.observer.push;

/**
 * @ClassName ConcreteObserver
 * @Author xiechao
 * @Date 2019/4/2
 * @Time 10:39
 * @Description TODO
 */
public class ConcreteObserver  implements Observer{
    private String observerState;

    @Override
    public void update(String state) {
        observerState = state;
        System.out.println("状态为：" + observerState);
    }
}
