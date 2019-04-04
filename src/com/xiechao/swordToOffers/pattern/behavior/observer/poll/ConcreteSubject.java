package com.xiechao.swordToOffers.pattern.behavior.observer.poll;

/**
 * @ClassName ConcreteSub
 * @Author xiechao
 * @Date 2019/4/2
 * @Time 10:56
 * @Description TODO
 */
public class ConcreteSubject extends Subject{
    private String state;

    public void setState(String state) {
        this.state = state;
        System.out.println("主题状态为 ：" + state);
        super.notifyObservers();
    }

    public String getState() {
        return state;
    }
}
