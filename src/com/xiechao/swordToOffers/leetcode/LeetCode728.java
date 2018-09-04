package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LeetCode728 {
    public List<Integer> selfDividingNumbers(int left, int right){
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right ; i++) {
            if(isSelfDividingNumber(i))
                list.add(i);
        }
        return list;
    }
    private boolean isSelfDividingNumber(int number){
        if(number <= 9 && number >=1){
            return true;
        }
        int original = number;
        while(number>0){
            int divide = number % 10;
            if((divide ==0)||(original % divide) !=0){
                return false;
            }
            number = number /10;
        }
        return true;
    }

    @Test
    public void test(){
        System.out.println(selfDividingNumbers(1,22));
    }

}
