package com.xiechao.swordToOffers.pattern.structure.decorator;

/**
 * @ClassName ConcreteDecorator
 * @Author xiechao
 * @Date 2019/4/2
 * @Time 16:20
 * @Description TODO
 */
public class ConcreteDecorator extends Decorator {

    public ConcreteDecorator(Component component) {
        super(component);
    }

    @Override
    public void sampleOperation() {
        System.out.println("增强1");
        super.sampleOperation();
        System.out.println("增强2");
    }
}
