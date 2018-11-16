package com.xiechao.swordToOffers.book.version2;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName Problem66
 * @Author xiechao
 * @Date 2018/11/15
 * @Time 9:47
 * @Description 构建乘积数组，不适用除法
 */
public class Problem66 {
    //暴力法 O(n*n)
    public int[] multiply(int[] A) {
        if(A == null) return null;

        int[] B = new int[A.length];
        for (int i = 0; i < B.length; i++) {
            int cur = 1;
            for (int j = 0; j < A.length; j++) {
                if(i == j) continue;
                cur *= A[j];
            }
            B[i] = cur;
        }
        return B;
    }

    //剑指 offer神一样的方法 O(n)
    public int[] multiply2(int[] A){
        if(A == null ) return null;
        int[] C = new int[A.length];
        int[] D = new int[A.length];
        C[0] = 1;
        D[D.length - 1] = 1;
        for (int i = 1; i < A.length; i++) {
            C[i] = C[i - 1] * A[i-1];
        }
        for (int i = D.length - 2; i >= 0; i--) {
            D[i] = D[i+1] * A[i+1];
        }
        for (int i = 0; i < A.length; i++) {
            C[i] = C[i] * D[i];
        }
        return C;
    }
}
