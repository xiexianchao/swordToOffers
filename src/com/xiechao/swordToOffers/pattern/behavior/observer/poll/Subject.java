package com.xiechao.swordToOffers.pattern.behavior.observer.poll;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Subject
 * @Author xiechao
 * @Date 2019/4/2
 * @Time 10:52
 * @Description TODO
 */
public abstract class Subject {
    private List<Observer> list = new ArrayList<Observer>();

    /**
     * 注册观察者对象
     * @param observer
     */
    public void attach(Observer observer){
        list.add(observer);
        System.out.println("Attached a observer");
    }
    public void detach(Observer observer){
        list.remove(observer);
        System.out.println("删除一个观察者");
    }
    public void notifyObservers(){
        for(Observer observer : list ){
            observer.update(this);
        }
    }
    abstract void setState(String state);
    abstract String getState();
}
