package com.xiechao.swordToOffers.test;

import org.junit.Test;

/**
 * @ClassName Test6
 * @Author xiechao
 * @Date 2019/4/12
 * @Time 9:47
 * @Description TODO
 */
public class Test6 {
    public int minimumDeleteSum(String s1, String s2) {
        if(s1 == null && s2 == null)  return 0;
        int result = 0;
        if( s1 == null){
            for(int i = 0; i<= s2.length();i++)
                result += s2.charAt(i) - '0';
            return result;
        }
        if(s2 == null){
            for(int i = 0; i<= s1.length();i++)
                result += s1.charAt(i) - '0';
            return result;
        }
        int[][] dp = new int[1 + s1.length()][1 + s2.length()];
        dp[0][0] = 0;
        for(int i =1; i <= s1.length();i++){
            dp[i][0] = dp[i-1][0] + s1.charAt(i-1);
        }
        for(int i =1; i <= s2.length();i++){
            dp[0][i] = dp[0][i-1] + s2.charAt(i-1) ;
        }

        for(int i =1; i <= s1.length();i++)
            for(int j = 1; j <= s2.length(); j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j] + s1.charAt(i-1), dp[i][j-1] + s2.charAt(j-1) );
                }

            }
        return dp[s1.length()][s2.length()];
    }
    @Test
    public void test(){
        System.out.println(minimumDeleteSum("delete","leet"));
    }

}
