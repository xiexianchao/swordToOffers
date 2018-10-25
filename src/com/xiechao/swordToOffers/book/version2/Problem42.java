package com.xiechao.swordToOffers.book.version2;

/**
 * @ClassName Problem42
 * @Author xiechao
 * @Date 2018/10/21
 * @Time 18:12
 * @Description 求连续子数组的最大和
 */
public class Problem42 {
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array == null || array.length <=0) return 0;
        int max = Integer.MIN_VALUE;
        int cur = 0;
        for (int i = 0; i < array.length; i++) {
            cur = (cur >0 ? cur:0) + array[i];
            max = Math.max(max,cur);
        }
        return max;
    }
}
