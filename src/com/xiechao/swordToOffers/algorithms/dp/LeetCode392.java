package com.xiechao.swordToOffers.algorithms.dp;

import org.junit.Test;

/**
 * @ClassName LeetCode392
 * @Author xiechao
 * @Date 2018/11/28
 * @Time 8:49
 * @Description Is Subsequence
 * 给出两个字符串s,t。求s是否是t的子序列（即，s的字符位置在t中都存在且相对位置不变）
 * dp[i]表示s[i]能在t中首次找到的位置，如果dp[i]=-1，表示t中不存在s[i]。结果就是dp[s.length-1]>=0?
 * dp[0] = t.indexOf(s[0]);
 * dp[i] = dp[i-1] == -1?-1:t.indexOf(s[i],dp[i-1]+1);
 *
 */
public class LeetCode392 {
    public boolean isSubsequence(String s, String t) {
        if(s == null || s.length() <= 0) return true;

        int[] dp = new int[s.length()];
        dp[0] = t.indexOf(s.charAt(0));
        if(dp[0] < 0) return false;
        for (int i = 1; i < dp.length ; i++) {
            if(dp[ i - 1] < 0 )
                dp[i] = -1;
            else{
                int temp = t.indexOf(s.charAt(i),dp[i-1] + 1);
                dp[i] = temp;
            }
        }
        return dp[s.length() - 1] >= 0;
    }
    @Test
    public void test(){
        System.out.println(isSubsequence("aec","abcde"));

    }
}
