package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * @author: xiehcao
 * @Date : 2018/9/4
 * @Time : 16:21
 * @description :
 */
public class LeetCode884 {
    public String[] uncommonFromSentences(String A,String B){
        List<String> list = new ArrayList<>();
        String[] strA = A.split(" ");
        String[] strB = B.split(" ");
        Map<String,Boolean> map = new HashMap<>();
        for (String str: strA){
            if(!map.containsKey(str))
            {
                map.put(str,Boolean.FALSE);
                list.add(str);
            }
        }
        for (String str:strB) {
            if(!map.containsKey(str)){
                    list.add(str);
            }else{
                list.remove(str);
            }
        }
        String[] strings = new String[list.size()];
        list.toArray(strings);
        return strings;
    }
    @Test
    public void test(){
        System.out.println(Arrays.toString(uncommonFromSentences("apple apple","banana")));
    }
}
