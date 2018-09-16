package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * @ClassName LeetCode350
 * @Author xiechao
 * @Date 2018/9/14
 * @Time 16:15
 * @Description Intersection of Two Arrays II
 * 求两个数组的交集
 */
public class LeetCode350 {
    //47 ms
    public int[] intersect(int[] nums1, int[] nums2) {
        if( nums1 == null || nums2 == null) return null;
        Map<Integer,Integer> map = new HashMap<>();
        for (Integer e:nums1) {
            map.merge(e,1,Integer::sum);
        }
        List<Integer>  list = new ArrayList<>();
        for (int e:nums2) {
            if(map.containsKey(e))
            {
                list.add(e);
                map.merge(e,-1,Integer::sum);
                if(map.get(e) == 0)
                    map.remove(e);
            }
        }
        int[] result = new int[list.size()];
        int index = 0;
        for (Integer e :list) {
            result[index++] = e;
        }
        return result;
    }
    //LeetCode大神
    public int[] intersect2(int[] nums1, int[] nums2){
        if( nums1 == null || nums2 == null) return null;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] result = new int[Math.max(nums1.length,nums2.length)];
        int idx = 0;
        int idx1 = 0;
        int idx2 = 0;
        while((idx1 < nums1.length) && (idx2 < nums2.length)){
            if(nums1[idx1] == nums2[idx2])
            {
                result[idx++] = nums1[idx1];
                idx1++;
                idx2++;
            }else if(nums1[idx1] < nums2[idx2])
                idx1++;
            else
                idx2++;
        }
        return Arrays.copyOfRange(result,0,idx);
    }

    @Test
    public void test(){
        System.out.println(intersect2(new int[]{4,9,5},new int[]{9,4,9,8,4}));
    }
    

}
