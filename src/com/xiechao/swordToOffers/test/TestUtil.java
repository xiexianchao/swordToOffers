package com.xiechao.swordToOffers.test;

import org.junit.Test;

import java.util.HashMap;
import java.util.Stack;

/**
 * @ClassName TestUtil
 * @Author xiechao
 * @Date 2018/9/17
 * @Time 15:56
 * @Description TODO
 */
public class TestUtil {
    @Test
    public void test(){
        /*System.out.println("00000010100101000001111010011100".length());
        HashMap<String,Integer> map = new HashMap<>();*/
        /* Integer num1 = 100;
         Integer num2 = 200;
         Long num3 = 300L;
         System.out.println(num3 == (num1 + num2)); //true*/
        Integer num1 = 100;
        Integer num2 = 200;
        Long num3 = 300l;
        System.out.println(num3 == (num1 + num2));

    }
}
interface hh{
    void print();

}
abstract class User{
    private String name;

    public User(String name) {
        this.name = name;
    }

    abstract void print(String password);
}
