package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;

/**
 * @author: xiehcao
 * @Date : 2018/9/29
 * @Time : 16:06
 * @description :
 */
public class LeetCode75 {

    //计数排序，真尼玛还有这种方法 而且是 0ms。最大问题就是耦合性太强，代码写死了
    public void sortColors(int[] nums) {
        if(nums == null || nums.length <=0) return;
        int countOf0 = 0;
        int countOf1 = 0;
        int countOf2 = 0;
        for (int e:nums) {
            switch(e){
                case 0:countOf0++;break;
                case 1:countOf1++;break;
                case 2:countOf2++;break;
                default:break;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if( i < countOf0)
                nums[i] = 0;
            else if( i >= countOf0 && i <(countOf1 + countOf0))
                nums[i] = 1;
            else
                nums[i] = 2;
        }
    }
    //LeetCode大神  头尾指针
    public void sortColors2(int[] nums){
        if( nums == null || nums.length <=0) return;
        int p1 = 0,p2 = nums.length-1;
        while(p1 < p2){
            while(p1 < p2 && nums[p1] ==0) p1++;
            while(p1 < p2 && nums[p2] != 0) p2--;
            if(p1 < p2){
                nums[p2] = nums[p1];
                nums[p1] = 0;
            }
        }
        p2 = nums.length - 1;
        while(p1 < p2){
            while(p1< p2 && nums[p1] == 1) p1++;
            while(p1 < p2 && nums[p2] != 1) p2--;
            if(p1 < p2){
                nums[p2] = nums[p1];
                nums[p1] = 1;
            }
        }
    }





    @Test
    public void test(){
       sortColors2(new int[]{2,0,2,1,1,0});
    }
}
