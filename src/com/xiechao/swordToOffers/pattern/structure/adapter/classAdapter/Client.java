package com.xiechao.swordToOffers.pattern.structure.adapter.classAdapter;

import com.xiechao.swordToOffers.pattern.structure.adapter.Target;

/**
 * @ClassName Client
 * @Author xiechao
 * @Date 2019/4/3
 * @Time 9:21
 * @Description TODO
 */
public class Client {
    public static void main(String[] args) {
        Target target  = new Adapter();
        target.sampleOperation2();
    }
}
