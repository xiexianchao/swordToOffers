package com.xiechao.swordToOffers.annotation;

/**
 * @ClassName Test
 * @Author xiechao
 * @Date 2019/4/16
 * @Time 11:23
 * @Description TODO
 */
@UserInfo(age=28,sex=UserInfo.SexEum.man,username="xxx")
public class Test {
    @City({"x1","x2","x3","x4"})
    @UserInfo(age=28, data = "55454564",sex=UserInfo.SexEum.man,username = "12sda")
    public  void helper(){
        @City(value="s1",username="aaa")
        String string = "";
    }

}
