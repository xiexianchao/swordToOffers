package com.xiechao.swordToOffers.algorithms.dp;

/**
 * @ClassName LeetCode413
 * @Author xiechao
 * @Date 2018/10/30
 * @Time 15:16
 * @Description Arithmetic Slices
 * 显而易见：连续的等差数列有n个元素的时候，则会有(1+2+...+n-2)个等差子数列。
 *
 * {1,2,3} -> {1,2,3} ->1
 *
 * {1,2,3,4} -> {1,2,3,4} + {1,2,3} + {2,3,4} -> 1+2 ->3
 *
 * {1,2,3,4,5} -> {1,2,3,4,5} + {1,2,3,4} + {2,3,4,5} + {1,2,3} + {2,3,4} + {3,4,5} -> 1+2+3 ->6
 *
 * {1,2,....,n} -> ...... -> 1+2+...+n-2
 */
public class LeetCode413 {
    public int numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length <= 2) return 0;
         int count = 1;
         int sum = 0;
        for (int i = 1; i < A.length-1; i++) {
            if(A[i+1] - A[i] ==  A[i] - A[i-1]){
                sum += count;
                count++;
            }else{
                count = 1;
            }
        }
        return sum;
    }
}
