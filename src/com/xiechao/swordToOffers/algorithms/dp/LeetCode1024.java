package com.xiechao.swordToOffers.algorithms.dp;

import java.util.Arrays;

/**
 * @ClassName LeetCode1024
 * @Author xiechao
 * @Date 2019/4/16
 * @Time 8:58
 * @Description
 * Input: clips = [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]], T = 10
 * Output: 3
 * Explanation:
 * We take the clips [0,2], [8,10], [1,9]; a total of 3 clips.
 * Then, we can reconstruct the sporting event as follows:
 * We cut [1,9] into segments [1,2] + [2,8] + [8,9].
 * Now we have segments [0,2] + [2,8] + [8,10] which cover the sporting event [0, 10].
 *
 * 给出一个n*2的二维数组，每一行表示一个clip, 给出一个T，问最少使用多少个clip可以拼接成[0,T]这个区间，如果不能返回-1，cpli可以剪切
 */
public class LeetCode1024 {
    //LeetCode 大神
    public int videoStitching(int[][] clips, int T) {
        if(clips == null || clips.length <= 0 || T <= 0) return 0;
        int[] dp = new int[T+1];
        Arrays.fill(dp,T+1);
        dp[0] = 0;
        for (int i = 1; i < dp.length ; i++) {
            for (int[] clip : clips) {
                if( i >= clip[0] && i <= clip[1]){
                    dp[i] = Math.min(dp[i], dp[clip[0]]+1);
                }
            }
            if(dp[i] > T) return -1;
        }
        return dp[T];
    }
}
