package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;

/**
 * @author: xiehcao
 * @Date : 2018/10/10
 * @Time : 10:55
 * @description :
 */
public class LeetCode11 {

    //时间复杂度O(n*n)      271ms
    public int maxArea(int[] height) {
        if(height == null || height.length <=1) return 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            for (int j = i; j < height.length; j++) {
                max = Integer.max(max,(Integer.min(height[i],height[j]) * (j-i)));
            }
        }
        return max;
    }
    //LeetCode大神 O(n) 10ms
    public int maxArea2(int[] height){
        if(height == null || height.length <= 1) return 0;
        int p1 = 0 , p2 = height.length - 1,maxArea = Integer.MIN_VALUE;
        while(p2 > p1){
            maxArea = Integer.max(maxArea,Integer.min(height[p1],height[p2]) * (p2 - p1));
            if(height[p2] > height[p1])
                p1++;
            else
                p2--;
        }
        return maxArea;
    }

    @Test
    public void test(){
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
