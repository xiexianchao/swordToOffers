package com.xiechao.swordToOffers.leetcode;

import com.sun.org.apache.regexp.internal.RE;

public class LeetCode825 {

    //查分 3ms
    public int peakIndexInMountainArray1(int[] A) {
        if( null == A || A.length <= 0 )
            return -1;
        //int[] B = new int[A.length];
        //B[0] = 0;
        int pre = 0;
        int current = 0;
        for (int i = 1; i < A.length; i++) {
            pre = current;
            current = A[i] - A[i-1];
            if(pre > 0 && current <0){
                return i-1;
            }
        }
        return -1;
    }


    /*
     *
     *  二分法查找 2ms
     */
    public int peakIndexInMountainArray2(int[] A){
        if( null == A || A.length <=0 )
            return -1;
        int start = 0;
        int end = A.length -1;
        while(end > start){
            int mid = ( end + start)/2;
            if( A[mid] < A[mid+1])
                start = mid + 1;
            else
                end = mid;
        }
        return start;
    }

}
