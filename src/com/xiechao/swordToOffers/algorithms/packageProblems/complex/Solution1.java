package com.xiechao.swordToOffers.algorithms.packageProblems.complex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName Solution1
 * @Author xiechao
 * @Date 2019/4/5
 * @Time 17:19
 * @Description
 *
 * 题目描述
 * 【问题描述】
 *
 * 在《Harry Potter and the Chamber of Secrets》中，Ron的魔杖因为坐他老爸的Flying Car撞到了打人柳，不幸被打断了，从此之后，他的魔杖的魔力就大大减少，甚至没办法执行他施的魔咒，这为Ron带来了不少的烦恼。这天上魔药课，Snape要他们每人配置一种魔药（不一定是一样的），Ron因为魔杖的问题，不能完成这个任务，他请Harry在魔药课上(自然是躲过了Snape的检查)帮他配置。现在Harry面前有两个坩埚，有许多种药材要放进坩埚里，但坩埚的能力有限，无法同时配置所有的药材。一个坩埚相同时间内只能加工一种药材，但是不一定每一种药材都要加进坩埚里。加工每种药材都有必须在一个起始时间和结束时间内完成（起始时间所在的那一刻和结束时间所在的那一刻也算在完成时间内），每种药材都有一个加工后的药效。现在要求的就是Harry可以得到最大的药效。
 *
 * 出自:宜昌一中
 *
 * 输入格式
 * 【输入】
 *
 * 输入文件的第一行有2个整数，一节魔药课的t（1≤t<≤500）和药材数n（1≤n≤100）。
 *
 * 输入文件第2行到n+1行中每行有3个数字，分别为加工第i种药材的起始时间t1、结束时间t2、（1≤t1≤t2≤t）和药效w（1≤w≤100）。
 *
 * 输出格式
 * 【输出】
 *
 * 输出文件medic.out只有一行，只输出一个正整数，即为最大药效。
 *
 * input:
 * 7 4
 * 1 2 10
 * 4 7 20
 * 1 3 2
 * 3 7 3
 *
 * output:
 * 35
 * 解法如： https://blog.csdn.net/rising_shit/article/details/77751941
 * 我没看懂
 */
public class Solution1 {
    static class Plis implements  Comparable<Plis>{
        int val;
        int left;
        int right;

        public Plis( int left, int right,int val) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Plis o) {
            if(this.left > o.left) return 1;
            else if(this.left < o.left) return -1;
            else{
                if(this.right > o.left) return 1;
                else return -1;
            }
        }
    }

    public static int solution(int T, int n, List<Plis> list){
        Collections.sort(list);
        int[][] dp = new int[T+1][T+1];
        for (int i = 1; i <= n ; i++) {
            for (int j = T; j >= 0 ; j--) {
                for (int k = T; k >= 0 ; k--) {
                    if(j >= list.get(i-1).right){
                        dp[j][k] = Math.max(dp[j][k], dp[list.get(i-1).left - 1][k] + list.get(i-1).val);
                    }
                    if(k >= list.get(i-1).right){
                        dp[j][k] = Math.max(dp[j][k], dp[j][list.get(i-1).left - 1] + list.get(i-1).val);
                    }
                }
            }
        }


        return dp[T][T];
    }

    public static void main(String[] args) {
        int t = 7;
        int n = 4;
        List<Plis> arr = new ArrayList<>(4);
        arr.add(new Plis(1,1,10));
        arr.add(new Plis(4,7,20));
        arr.add(new Plis(1,3,2));
        arr.add(new Plis(3,7,3));
        System.out.println(solution(t,n,arr));
    }
}
