package com.xiechao.swordToOffers.leetcode;

import java.util.*;

/**
 * @ClassName LeetCode599
 * @Author xiechao
 * @Date 2018/11/15
 * @Time 9:18
 * @Description Minimum Index Sum of Two Lists
 * 求两个数组，元素相等的索引和最小值
 *
 */
public class LeetCode599 {
    //暴力法 104ms
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> list = new ArrayList<>();
        int minIndex = Integer.MAX_VALUE;
        String result = "";
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if(list1[i].equals(list2[j])){
                    if(i+j <= minIndex){
                        result = list1[i];
                        list.add(result);
                        minIndex = i + j;
                    }
                }
            }
        }
        String[] res = new String[list.size()];
        for (int i = 0; i < list.size() ; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    //使用map，19ms
    public String[] findRestaurant2(String[] list1, String[] list2){
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < list2.length; i++) {
            map.put(list2[i],i);
        }
        int minIndex = Integer.MAX_VALUE;
        List<String> list = new LinkedList<>();
        for (int i = 0; i < list1.length; i++) {
            if(map.containsKey(list1[i])){
                if(i + map.get(list1[i]) <= minIndex){
                    list.add(list1[i]);
                    minIndex = i + map.get(list1[i]);
                }
            }
        }
        String[] res = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public String[] findRestaurant3(String[] list1, String[] list2){
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < list2.length; i++) {
            map.put(list2[i],i);
        }
        int minIndex = Integer.MAX_VALUE;
        List<String> list = new LinkedList<>();
        for (int i = 0; i < list1.length; i++) {
            if(map.containsKey(list1[i])){
                int curIndex = i + map.get(list1[i]);
                if( curIndex <= minIndex){
                    list.add(list1[i]);
                    minIndex = curIndex;
                }
            }
        }
        String[] res = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

}
