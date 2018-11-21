package com.xiechao.swordToOffers.algorithms.dp;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @ClassName LeetCode646
 * @Author xiechao
 * @Date 2018/11/21
 * @Time 9:10
 * @Description  Maximum Length of Pair Chain
 */
public class LeetCode646 {
    //排列  但会Time Limit Exceeded
    public int findLongestChain(int[][] pairs) {
        int[] maxLength = new int[1];
        helper(pairs,new LinkedList<int[]>(),0,maxLength);
        return maxLength[0];
    }
    private void helper(int[][] pairs, LinkedList<int[]> tempList, int start,int[] maxLength){
        maxLength[0] = Math.max(maxLength[0],tempList.size());

        for (int i = 0; i < pairs.length; i++) {
            int[] pre = tempList.size() >0 ?tempList.getLast():null;
            if(pre == null || pre[1] < pairs[i][0]){
                tempList.addLast(pairs[i]);
                helper(pairs,tempList,start+1,maxLength);
                tempList.removeLast();
            }else
                continue;
        }
    }

    //leetcode 大神
    public int findLongestChain2(int[][] pairs){
        Arrays.sort(pairs,(a,b)->a[0]- b[0]);
        int[] dp = new int[pairs.length];       //dp[i]表示以i结尾的最大长度
        Arrays.fill(dp,1);
        for (int i = 1; i < pairs.length; i++) {        //dp[0] = 1，所以从1开始
            for (int j = 0; j < i; j++) {           // j < i
                if(pairs[j][1] < pairs[i][0]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int max = 1;
        for (Integer e: dp) {
            max = Math.max(max,e);
        }
        return max;
    }

    

    @Test
    public void test(){
        int[][] pairs = new int[4][];
        pairs[0] = new int[]{1,4};
        pairs[1] = new int[]{4,8};
        pairs[2] = new int[]{1,3};
        pairs[3] = new int[]{5,6};
        System.out.println(findLongestChain2(pairs));

    }

}
