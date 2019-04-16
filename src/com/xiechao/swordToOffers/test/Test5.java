package com.xiechao.swordToOffers.test;

/**
 * @ClassName Test5
 * @Author xiechao
 * @Date 2019/4/11
 * @Time 15:02
 * @Description TODO
 */
public class Test5 {
    public static void main(String[] args) {
        Integer t1 = 3;
        change(t1);
        System.out.println(t1);
    }
    private static void change(Integer t){
       // t= new Integer(1);
       t = 2;
        System.out.println(t.hashCode());
    }
}
