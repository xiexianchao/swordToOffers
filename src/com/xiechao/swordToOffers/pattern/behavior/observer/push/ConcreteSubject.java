package com.xiechao.swordToOffers.pattern.behavior.observer.push;

/**
 * @ClassName ConcreteSubJect
 * @Author xiechao
 * @Date 2019/4/2
 * @Time 10:37
 * @Description TODO
 */
public class ConcreteSubject extends Subject{
    private String state;

    public String getState(){
        return state;
    }
    public void change(String newState){
        state = newState;
        System.out.println("主题状态为 ：" + state);
        this.notifyObservers(state);
    }
}
