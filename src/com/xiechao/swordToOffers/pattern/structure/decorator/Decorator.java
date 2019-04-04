package com.xiechao.swordToOffers.pattern.structure.decorator;

/**
 * @ClassName Decorator
 * @Author xiechao
 * @Date 2019/4/2
 * @Time 16:19
 * @Description TODO
 */
public class Decorator implements Component {
    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void sampleOperation() {
        component.sampleOperation();
    }
}
