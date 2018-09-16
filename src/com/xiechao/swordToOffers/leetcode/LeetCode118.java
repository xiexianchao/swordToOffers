package com.xiechao.swordToOffers.leetcode;

import com.xiechao.swordToOffers.commom.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName LeetCode118
 * @Author xiechao
 * @Date 2018/9/14
 * @Time 18:31
 * @Description Pascal's Triangle
 */
public class LeetCode118 {
    public List<List<Integer>> generate(int numRows) {
       List<List<Integer>> list = new ArrayList<>();
       if(numRows >= 1) {
           List<Integer> list1 = new ArrayList<>();
           list1.add(1);
           list.add(list1);
       }
       if(numRows >= 2){
           List<Integer> list2 = new ArrayList<>();
           list2.add(1);
           list2.add(1);
           list.add(list2);
       }
        for (int i = 3; i <= numRows ; i++) {
            List<Integer> listn = new ArrayList<>();
            listn.add(1);
            for (int j = 2; j < i ; j++) {
                int temp =list.get(i-2).get(j-2) + list.get(i-2).get(j-1);
                listn.add(temp);
            }


            listn.add(1);
            list.add(listn);

        }
        return list;
    }
    @Test
    public void test(){
        System.out.println(generate(5));
    }
}
