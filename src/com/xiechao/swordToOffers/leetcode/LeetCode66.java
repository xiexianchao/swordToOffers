package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName LeetCode66
 * @Author xiechao
 * @Date 2018/9/15
 * @Time 11:04
 * @Description Plus One
 */
public class LeetCode66 {
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length <=0 )return null;
        //List<Integer> list = new ArrayList<>();
        int[] result = new int[digits.length+1];


        digits[digits.length-1]++;
        for (int i = 0; i < digits.length; i++) {
            result[i+1] = digits[i];
        }
        for (int i = digits.length; i >=1 ; i--) {
            if(result[i] > 9){
                result[i] = result[i] %10;
                result[i-1] += 1;
            }
        }
        return result[0] == 0?Arrays.copyOfRange(result,1,result.length):result;
    }
    @Test
    public void test(){
        plusOne(new int[]{9,9});
    }
}
