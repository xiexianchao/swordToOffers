package com.xiechao.swordToOffers.algorithms.packageProblems.package01;

/**
 * @ClassName OnePackage3
 * @Author xiechao
 * @Date 2019/4/5
 * @Time 11:22
 * @Description
 * 孩子，这个山洞里有一些不同的草药，采每一株都需要一些时间，
 * 每一株也有它自身的价值。求在给定价值下最少的花费时间
 *
 * 求总价值确定的最小花费时间
 *
 * dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-v[i]] + w[i])
 */
public class OnePackage3 {
}
