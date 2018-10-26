package com.xiechao.swordToOffers.algorithms.dp;

/**
 * @ClassName LeetCode70
 * @Author xiechao
 * @Date 2018/10/25
 * @Time 16:56
 * @Description Climbing Stairs
 */
public class LeetCode70 {
    public int climbStairs(int n) {
        if(n <=0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        int pre = 1;
        int nextPre = 2;
        int cur = 0;
        for (int i = 3; i <= n ; i++) {
            cur = pre + nextPre;
            pre = nextPre;
            nextPre = cur;
        }
        return cur;
    }
    //LeetCode大神
    public int climbStairs2(int n) {
        int[] res = new int[n+1];
        res[0] = 1;
        res[1] = 1;
        for (int i = 2; i <= n ; i++) {
            res[i] = res[i-1] + res[i-2];
        }
        return res[n];
    }

}
