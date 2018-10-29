package com.xiechao.swordToOffers.algorithms.palindrome;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName LeetCode9
 * @Author xiechao
 * @Date 2018/10/26
 * @Time 10:26
 * @Description  Palindrome Number
 * 判断一个数字是否是回文。不能将其转成字符串
 *  一开始想法是：将数字反转重新构建成一个数，但发现会造成溢出,
 *  又发现如果是回文的话，不会溢出
 *  如果是不是回文的话，移除会变成负数，也不会造成误判
 */
public class LeetCode9 {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        if(x == 0) return true;
        int temp = x;
        List<Integer> list = new ArrayList<>();
        while(temp != 0){
            list.add(temp % 10);
            temp /= 10;
        }
        int i = 0;
        int j = list.size() - 1;
        while(i < j){
            if(!list.get(i).equals(list.get(j))) return false;
            i++;
            j--;
        }
        return  true;
    }

    //LeetCode大神
    public boolean isPalindrome2(int x){
        if(x < 0) return false;
        int y = x;
        int res = 0;
        while(x != 0){
            res = res * 10 + x % 10;
            x /= 10;
        }
        return y == res;
    }

    @Test
    public void test(){
        System.out.println(isPalindrome2(2147483647));
    }
}
