package com.xiechao.swordToOffers.book;

import org.junit.Test;

/**
 * @author: xiehcao
 * @Date : 2018/9/10
 * @Time : 15:49
 * @description :二进制中1的个数。
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class Problem {
    public int NumberOf1(int n) {
        int result = 0;
        while(n !=0){
            result ++;
            n = n & (n-1);  //n & (n-1) 可以把n的二进制表示中最右边的1置为0；
        }
        return result;
    }
    @Test
    public void test(){
        System.out.println(NumberOf1(-1));
    }
}
