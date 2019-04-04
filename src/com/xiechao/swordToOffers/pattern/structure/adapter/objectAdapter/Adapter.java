package com.xiechao.swordToOffers.pattern.structure.adapter.objectAdapter;

import com.xiechao.swordToOffers.pattern.structure.adapter.Adaptee;
import com.xiechao.swordToOffers.pattern.structure.adapter.Target;

/**
 * @ClassName Adapter
 * @Author xiechao
 * @Date 2019/4/3
 * @Time 9:28
 * @Description TODO
 */
public class Adapter implements Target {
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void sampleOperation1() {
        adaptee.sampleOperation1();
    }

    @Override
    public void sampleOperation2() {
        //todo
    }
}
