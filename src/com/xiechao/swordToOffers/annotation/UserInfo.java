package com.xiechao.swordToOffers.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @ClassName UserInfo
 * @Author xiechao
 * @Date 2019/4/16
 * @Time 11:20
 * @Description TODO
 */
@Target({ElementType.ANNOTATION_TYPE , ElementType.FIELD, ElementType.METHOD,ElementType.TYPE,ElementType.LOCAL_VARIABLE})
public @interface UserInfo {
    String username();
    String data() default "2019-4-16";
    int age();
    SexEum sex();
    public static enum SexEum{
        man, woman
    }
}
