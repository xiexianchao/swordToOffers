package com.xiechao.swordToOffers.annotation;

/**
 * @ClassName City
 * @Author xiechao
 * @Date 2019/4/16
 * @Time 11:22
 * @Description TODO
 */
public @interface City {
    String username() default "xxx";
    String[] value() ;

}
