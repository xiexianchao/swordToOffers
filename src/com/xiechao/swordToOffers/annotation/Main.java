package com.xiechao.swordToOffers.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @ClassName Main
 * @Author xiechao
 * @Date 2019/4/16
 * @Time 11:30
 * @Description TODO
 */
public class Main {
    public static void main(String[] args) throws NoSuchMethodException {
       // @UserInfo(username="test",data="aa-bbcc",age=14, sex=UserInfo.SexEum.man)
       UserInfo annotation = (UserInfo)Test.class.getAnnotation(UserInfo.class);
        Method helper = Test.class.getMethod("helper");
        Annotation[] annotations = helper.getAnnotations();
        System.out.println(Arrays.toString(annotations));
        //System.out.println(annotation.age() == 2);
    }
}
