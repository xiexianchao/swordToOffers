package com.xiechao.swordToOffers.pattern.structure.decorator;

/**
 * @ClassName Cleint
 * @Author xiechao
 * @Date 2019/4/2
 * @Time 16:22
 * @Description TODO
 */
public class Client {
    public static void main(String...args){
        Component component = new ConcreteComponent();
        Component enahce  = new ConcreteDecorator(component);
        enahce.sampleOperation();
    }
}
