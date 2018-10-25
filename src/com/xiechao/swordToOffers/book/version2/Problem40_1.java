package com.xiechao.swordToOffers.book.version2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName Problem41
 * @Author xiechao
 * @Date 2018/10/21
 * @Time 17:56
 * @Description 求输入数组的最小的k个数，不能修改输入数组
 */
public class Problem40_1 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();

        if(input == null || input.length <=0 || k <=0 || input.length <k) return result;
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 > o2)
                    return -1;
                else if(o1 < o2)
                    return 1;
                else
                    return 0;
            }
        });
        for (int i = 0; i < k; i++) {
            queue.add(input[i]);
        }
        for (int i = k; i < input.length; i++) {
            int max = queue.peek();
            if(input[i] < max){
                queue.poll();
                queue.add(input[i]);
            }
        }
        for (Integer e:queue) {
            result.add(e);
        }
        return result;
    }
     @Test
    public void test(){
        System.out.println(GetLeastNumbers_Solution(new int[]{4,5,1,6,2,7,3,8},0));
    }
}
