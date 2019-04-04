package com.xiechao.swordToOffers.pattern.behavior.observer.poll;

/**
 * @ClassName Client
 * @Author xiechao
 * @Date 2019/4/2
 * @Time 10:58
 * @Description TODO
 */
public class Client {
    public static void main(String...args){
        Subject subject = new ConcreteSubject();
        Observer observer = new ConcreteObserver();
        subject.attach(observer);
        subject.setState("hhhhh");
    }
}
