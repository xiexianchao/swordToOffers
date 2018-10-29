package com.xiechao.swordToOffers.algorithms.palindrome;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName LeetCode132
 * @Author xiechao
 * @Date 2018/10/29
 * @Time 11:00
 * @Description Palindrome Partitioning II
 * 给你一个字符串s，返回最少的分割次数使得分割后的字串都为回文。
 */
public class LeetCode132 {
    //回溯，timeout
    public int minCut(String s) {
        if(s == null || s.length() <= 1) return 0;
        int[] result = new int[]{Integer.MAX_VALUE};
        helper(result,new ArrayList<String>(),s,0);
        return result[0];
    }

    private void helper(int[] result, ArrayList<String> tempList, String s, int start) {
        if(start == s.length()){
        //    result[0] = Math.min(tempList.size()-1,result[0]);
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if(isPalindrome(s,start,i+1)){
                String sub = s.substring(start,i+1);
                tempList.add(sub);
                helper(result,tempList,s,i+1);
                tempList.remove(tempList.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        end -=1;
        while(start < end){
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }

    //LeetCode大神 dp
    // 参考链接：https://blog.csdn.net/notHeadache/article/details/52401231
    public int minCut2(String s){
        if(s == null || s.length() <= 0) return 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n]; //dp[i][j] 表示s[i...j]是否是回文
        int[] res = new int[n];             // res[i]表示s[i...n-1]最少的分割次数
/*
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new boolean[n];
        }
*/
        for (int i = n-1; i >=0 ; i--) {        //注意需要倒叙遍历
            res[i] = n - 1 - i;             //res[i] 最大分割次数n-1-i
            for (int j = i; j < n ; j++) {
                if(s.charAt(i) == s.charAt(j) && ((j - i < 2 )|| dp[i+1][j-1])){
                    dp[i][j] = true;
                    if(j == n-1){       //j = n-1 s[i..j]不需要分割
                        res[i] = 0;
                    }else{
                        res[i] = Math.min(res[i],res[j+1]+1); //i...n-1，i...j+j...1-n-1
                        // 因为res[i]是倒叙算的，所以res[j+1]已经再res[i]之前计算过了
                    }
                }
            }
        }
        return res[0];
    }

    @Test
    public void test(){
        System.out.println(minCut2("ababababababababababababcbabababababababababababa"));
    }
}
