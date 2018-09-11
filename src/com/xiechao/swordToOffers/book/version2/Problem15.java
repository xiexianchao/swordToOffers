package com.xiechao.swordToOffers.book.version2;


import org.junit.Test;

/**
 * 二进制中1的个数
 */
public class Problem15 {
    int NumberOf1(int num){
        int count = 0;
        while(num != 0){
            count ++;
            num = num & (num-1);
        }
        return count;
    }
    @Test
    public void test(){

        System.out.println(NumberOf1(9));

    }

}
