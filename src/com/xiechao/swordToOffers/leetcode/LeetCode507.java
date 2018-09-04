package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;

public class LeetCode507 {

    //Time Limit Exceeded
    public boolean checkPerfectNumber1(int num) {
        boolean result = false;
        if(num > 0){
         int sum = 0;
         for (int i = 1; i <= num/2; i++) {
             if((num % i) ==0){
               sum +=i;
             }
         }
         if(sum == num)
            result = true;
        }
        return result;
    }
    @Test
    public void test(){
        System.out.println(checkPerfectNumber1(99999998));
    }



}
