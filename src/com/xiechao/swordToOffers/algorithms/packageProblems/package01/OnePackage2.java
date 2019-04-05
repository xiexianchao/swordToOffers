package com.xiechao.swordToOffers.algorithms.packageProblems.package01;

import java.util.Scanner;

/**
 * @ClassName OnePackage2
 * @Author xiechao
 * @Date 2019/4/5
 * @Time 10:44
 * @Description 辰辰是个天资聪颖的孩子，他的梦想是成为世界上最伟大的医师。为此，他想拜附近最有威望的医师为师。医师为了判断他的资质，
 * 给他出了一个难题。医师把他带到一个到处都是草药的山洞里对他说：
 * “孩子，这个山洞里有一些不同的草药，采每一株都需要一些时间，
 * 每一株也有它自身的价值。我会给你一段时间，在这段时间里，你可以采到一些草药。如果你是一个聪明的孩子，你应该可以让采到的草药的总价值最大。”
 * 如果你是辰辰，你能完成这个任务吗？
 * Input
 * 输入的第一行有两个整数T（1 <= T <= 1000）和M（1 <= M <= 100），用一个空格隔开，
 * T代表总共能够用来采药的时间，M代表山洞里的草药的数目。
 * 接下来的M行每行包括两个在1到100之间（包括1和100）的整数，
 * 分别表示采摘某株草药的时间和这株草药的价值。
 * Output
 * 输出包括一行，这一行只包含一个整数，表示在规定的时间内，可以采到的草药的最大总价值。
 * Sample Input
 * 70 3
 * 71 100
 * 69 1
 * 1 2
 * Sample Output
 * 3
 */
public class OnePackage2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();  //允许的总时间
        int M = scanner.nextInt(); //草药的总数量
        int[] weight = new int[M];
        int[] values = new int[M];
        /*scanner.nextLine();
        for (int i = 0; i < M; i++) {

            String line = scanner.nextLine();
            String[] split = line.split(" ");
            weight[i] = Integer.parseInt(split[0]);
            values[i] = Integer.parseInt(split[1]);
        }*/
        for (int i = 0; i < M; i++) {
             weight[i] = scanner.nextInt();
             values[i] = scanner.nextInt();
        }


        System.out.println(getMaxValues(weight, values,T));

    }
    private static int getMaxValues(int[] weight, int[] values, int T){
        int[][] dp = new int[weight.length][T+1];
        for (int i = 1; i <= T ; i++) {
            if(weight[0] > i){
                dp[0][i] = 0;
            }else{
                dp[0][i] = values[i];
            }
        }
        for (int i = 1; i < weight.length; i++) {
            for (int j = 1; j <= T; j++) {
                if(weight[i] > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]] + values[i]);
                }
            }
        }
        return dp[weight.length-1][T];

    }



}
