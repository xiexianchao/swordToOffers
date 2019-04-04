package com.xiechao.swordToOffers.pattern.structure.decorator;

/**
 * @ClassName ConcreteComponent
 * @Author xiechao
 * @Date 2019/4/2
 * @Time 16:19
 * @Description TODO
 */
public class ConcreteComponent implements Component {
    @Override
    public void sampleOperation() {
        System.out.println("基础功能");
    }
}
