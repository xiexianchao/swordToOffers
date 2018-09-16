package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName Problem202
 * @Author xiechao
 * @Date 2018/9/14
 * @Time 17:38
 * @Description Happy Number
 */
public class LeetCode202 {
    public boolean isHappy(int n){
       // if(n == 1) return true;
        Set<Integer> set = new HashSet<>();
        while( n != 1) {
            if(set.contains(n))
                return false;
            else{
                set.add(n);
            }
            int num = 0;
            while (n != 0) {
                int temp = n % 10;
                num += temp * temp;
                n = n / 10;
            }
            n = num;
        }
        return true;
    }
    @Test
    public void test(){
       System.out.println(isHappy(2));
    }

}
