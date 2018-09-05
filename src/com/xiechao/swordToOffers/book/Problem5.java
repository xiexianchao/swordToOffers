package com.xiechao.swordToOffers.book;

/**
 * @author: xiehcao
 * @Date : 2018/9/5
 * @Time : 15:19
 * @description :替换空格
 */
public class Problem5 {
    //牛客网测试 23ms
    public String replcaeSquare(StringBuffer str){
        if(null == str)
            return null;
      return str.toString().replace(" ","%20");
    }
}
