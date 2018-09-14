package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xiehcao
 * @Date : 2018/9/13
 * @Time : 15:58
 * @description :Fizz Buzz
 */
public class LeetCode412 {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        if(n <= 0 )
            return list;
        for (int i = 1; i <= n; i++) {
            if( ((i % 3) == 0) && ((i % 5) == 0))
                list.add("FizzBuzz");
            else if( (i % 3) ==0)
                list.add("Fizz");
            else if((i % 5) == 0)
                list.add("Buzz");
            else
            list.add(i+"");
        }
        return list;
    }
    @Test
    public void test(){
        System.out.println(fizzBuzz(15));
    }

}
