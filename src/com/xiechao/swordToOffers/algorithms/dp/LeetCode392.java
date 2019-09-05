package com.xiechao.swordToOffers.algorithms.dp;

import org.junit.Test;

import java.util.concurrent.ForkJoinPool;

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
    //2ms
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
    //二维dp 262ms
    public boolean isSubsequence2(String s, String t) {
        if(s == null || s.length() <= 0) return true;
        if(t == null || s.length() > t.length()) return false;
        boolean[][] dp = new boolean[s.length()][t.length()];
        dp[0][0] = s.charAt(0) == t.charAt(0);
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = dp[0][i-1] || s.charAt(0) == t.charAt(i);
        }
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = false;
        }
        for (int i = 1; i < s.length(); i++) {
            for (int j = 1; j < t.length(); j++) {

                dp[i][j] = ( dp[i-1][j-1] && s.charAt(i) == t.charAt(j)) || dp[i][j-1];
                System.out.println("dp[ " + i +"][ " + j + "] =" + dp[i][j]);
            }
        }
        return dp[s.length()-1][t.length()-1];
    }


    @Test
    public void test(){
        System.out.println(isSubsequence2("aec","abcde"));
        System.out.println(isSubsequence2("twn",
                "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxtxxxxxxxxxxxxxxxxxxxxwxxxxxxxxxxxxxxxxxxxxxxxxxn"));

    }
}
