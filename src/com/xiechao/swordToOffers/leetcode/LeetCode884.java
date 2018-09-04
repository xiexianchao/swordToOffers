package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * @author: xiehcao
 * @Date : 2018/9/4
 * @Time : 16:21
 * @description :求只在一个字符串数组力出现一次的单词
 * 还是借助map是来实现
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
            }else{
                map.put(str,Boolean.TRUE);
            }
        }
        for (String str:strB) {
            if(!map.containsKey(str)){
                map.put(str,Boolean.FALSE);
            }else{
                map.put(str,Boolean.TRUE);
            }
        }
        for (Map.Entry<String,Boolean> entry:map.entrySet()) {
            if(!entry.getValue()){
                list.add(entry.getKey());
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
