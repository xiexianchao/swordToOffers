package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * @ClassName LeetCode347
 * @Author xiechao
 * @Date 2018/9/17
 * @Time 20:40
 * @Description Top K Frequent Elements
 */
public class LeetCode347 {
    //114ms
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        if( nums == null || nums.length <=0) return list;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.merge(nums[i],1,Integer::sum);
        }
        while( k >0){
            int maxV = Integer.MIN_VALUE;
            int maxK = Integer.MIN_VALUE;
            for (Map.Entry<Integer,Integer> entry:map.entrySet()) {
                if( entry.getValue() > maxV){
                    maxV = entry.getValue();
                    maxK = entry.getKey();
                }
            }
            map.put(maxK,0);
            list.add(maxK);
            k--;
        }
        return list;
    }
    //LeetCode大神 4ms
    public List<Integer> topKFrequent2(int[] nums, int k){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int e:nums) {
            if(e > max)
                max = e;
            if(e < min)
                min = e;
        }
        int[] freq = new int[ max - min +1];
        int maxFreq = 0;
        for (int e : nums) {
            freq[e-min]++;
            if(freq[e - min] > maxFreq)
                maxFreq = freq[e - min];
        }
        List<Integer>[] map = new List[maxFreq+1];
        for (int i = 0; i < freq.length ; i++) {
            if( freq[i] == 0) continue;
            if( map[freq[i]] == null) map[freq[i]] = new LinkedList<>();
            map[freq[i]].add(i + min);
        }
        List<Integer> result = new LinkedList<>();
        for (int i = map.length-1; i >= 0 && k >0; i--) {
            if(map[i] == null) continue;
            result.addAll(map[i]);
            k -= map[i].size();
        }
        return result;
    }


    @Test
    public void test(){
        System.out.println(topKFrequent2(new int[]{1,1,1,2,2,3},2));
    }
}
