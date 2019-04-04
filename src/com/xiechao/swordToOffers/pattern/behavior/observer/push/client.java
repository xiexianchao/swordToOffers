package com.xiechao.swordToOffers.pattern.behavior.observer.push;

/**
 * @ClassName client
 * @Author xiechao
 * @Date 2019/4/2
 * @Time 10:40
 * @Description TODO
 */
public class client {
    public static void main(String[] args){
        ConcreteSubject subject = new ConcreteSubject();

        Observer observer = new ConcreteObserver();

        subject.attach(observer);  //注册观察者到某个主题上

        subject.change("new state"); //主题发生改变，观察者要做出相应的反映

    }
}
