package com.xiechao.swordToOffers.oom;

import java.util.Map;
import java.util.Random;

/**
 * @ClassName GClimitExceeded
 * @Author xiechao
 * @Date 2019/4/26
 * @Time 15:25
 * @Description TODO
 */
public class GClimitExceeded {
    public static void main(String[] args) {
        Map map = System.getProperties();
        Random r = new Random();
        while(true){
            map.put(r.nextInt(), "value");
        }
    }
}
