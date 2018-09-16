package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;

/**
 * @ClassName LeetCode88
 * @Author xiechao
 * @Date 2018/9/16
 * @Time 15:57
 * @Description T88. Merge Sorted Array
 * 合并排序后的数组，剑指Offer原题
 */
public class LeetCode88 {
    //5ms
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums1 == null || nums2 == null || n <=0) return;
        int p1 = m - 1;
        int p2 = nums1.length - 1;
        int p3 = n - 1;
        while(p3 >=0){
            if( p1 <0 || nums2[p3] >= nums1[p1]){
                nums1[p2] = nums2 [p3];
                p2--;
                p3--;
            }else{
              nums1[p2] = nums1[p1];
              p2--;
              p1--;
            }
        }
    }

    //LeetCode大神 2.5ms
    public void merge2(int[] nums1, int m, int[] nums2, int n){
        if(nums1 == null || nums2 == null || n <=0) return;
        int p1 = m - 1;
        int p2 = nums1.length - 1;
        int p3 = n - 1;
        while(p1 >=0 && p3 >=0){
            if( p1 <0 || nums2[p3] >= nums1[p1]){
                nums1[p2] = nums2 [p3];
                p2--;
                p3--;
            }else {
                nums1[p2] = nums1[p1];
                p2--;
                p1--;
            }
        }
        while( p3 >=0){
            nums1[p2 --] = nums2[p3--];
        }

    }

    @Test
    public void test(){
        int[] nums1 = new int[]{1,2,3,0,0,0,0};
        int[] nums2 = new int[]{0,2,5,6};
        merge2(nums1,3,nums2,4);

    }

}
