package com.xiechao.swordToOffers.test;

import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @ClassName Test3
 * @Author xiechao
 * @Date 2019/3/3
 * @Time 10:23
 * @Description TODO
 */
public class Test3 {
    @Test
    public void test(){
        String original = "aaa";
        String after = appendStr(original);
        System.out.println(original);  //"aaa
        System.out.println(after);    //aaannn

    }
    private String appendStr(String original){
        return original + "nnn";
    }
    @Test
    public void test2() throws NoSuchFieldException, IllegalAccessException {
        String str = "Hello World";
        System.out.println(str + "   :" + System.identityHashCode(str));


        Field valueField = String.class.getDeclaredField("value");
        valueField.setAccessible(true);

        char[] value = (char[]) valueField.get(str);
        value[3] = '?';
        System.out.println(str + "   :" + System.identityHashCode(str));
    }



}
