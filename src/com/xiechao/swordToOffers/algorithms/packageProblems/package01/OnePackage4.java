package com.xiechao.swordToOffers.algorithms.packageProblems.package01;

import java.util.Arrays;

/**
 * @ClassName OnePackage4
 * @Author xiechao
 * @Date 2019/4/5
 * @Time 11:28
 * @Description
 * 题目描述
 *
 * 假设某条街上每一公里就有一个公共汽车站，并且乘车费用如下表：
 *
 * 公里数 1 2 3 4 5 6 7 8 9 10
 *
 * 费用 12 21 31 40 49 58 69 79 90 101
 *
 * 而任意一辆汽车从不行驶超过10公里。某人想行驶n公里，假设他可以任意次换车，请你帮他找到一种乘车方案，使得总费用最小
 *
 * 注意：10公里的费用比1公里小的情况是允许的。
 * ---------------------
 * 可以把公里数看成values[],把费用看成weight[]
 * dp[i]表示行驶i花费的最小费用
 * i > 10 dp[i] = Math.min(dp[i-j]+prices[j], 1 =< j <= 10)
 * j < 10 只要算j之前的i就行了
 * 所有
 * for (int j = 1; j <=M; j++) {
 *    dp[i] = Math.min(dp[i],(i >j ?dp[i-j] : 0) + prices[j-1]);
 * }
 *
 */
public class OnePackage4 {
    public static int solution(int M ,int[] prices,int n){
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = prices[0];
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <=M; j++) {
                dp[i] = Math.min(dp[i],(i >j ?dp[i-j] : 0) + prices[j-1]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(solution(10,new int[]{12,21,31,40,49,58,69,79,90,101},15));
    }

}
