package com.xiechao.swordToOffers.pattern.structure.adapter.objectAdapter;

import com.xiechao.swordToOffers.pattern.structure.adapter.Adaptee;
import com.xiechao.swordToOffers.pattern.structure.adapter.Target;

/**
 * @ClassName Client
 * @Author xiechao
 * @Date 2019/4/3
 * @Time 9:29
 * @Description TODO
 */
public class Client {
    public static void main(String[] args) {
        Target target = new Adapter(new Adaptee());
        target.sampleOperation2();
    }
}
