package com.xiechao.swordToOffers.algorithms.packageProblems.packageArr;

/**
 * @ClassName Solution3
 * @Author xiechao
 * @Date 2019/4/5
 * @Time 18:03
 * @Description
 * 题目描述
 * 小王参加的考试是几门科目的试卷放在一起考，一共给t分钟来做。他现在已经知道每门科目花的时间和得到的分数的关系，还有写名字要的时间（他写自己的名字很慢）请帮他算一下他最高能得几分。总分一定时，第一门科目成绩尽量高，第一门科目成绩也一样时，第二门科目成绩尽量高…………以次类推。如果放弃某一门的考试（花的时间为0），那么名字也就不用写了。
 *
 * 样例说明
 *
 * 第一门：0分钟；第二门：3分钟，写名字1分钟，做题目2分钟，得3分；第三门：2分钟，写名字1分钟，做题目1分钟，得3分。总共得6分。
 *
 * 数据范围
 *
 * 对于50 %的数据，n<=4，对于100 %的数据，n<=10，t<=100, 所有数据都在longint范围内。
 *
 * 输入格式
 * 第一行三个正整数t，n，name。 t是总时间，n表示考n个科目，name表示写名字要的时间（每一门科目写名字时间一样）。接下来 n行，每行t个正整数，第i个数表示时间为i时这门科目的分数（不一定递增）。时间为0时这门科目的分数为0，所以就不读入了。
 *
 * 输出格式
 * 一个数，即总分。
 *
 * Input:
 * 5 3 1
 * 1 2 3 4 5
 * 2 3 3 4 6
 * 3 3 3 2 5
 *
 * Output:
 * 6
 *
 */
public class Solution3 {
    public static int getMax(int t,int n, int name,int[][] scores ){
        int[][] dp = new int[n+1][t+1];
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= t ; j++) {
                for (int k = 0; k <= j ; k ++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j - k] + (k > name? scores[i-1][k-1]:0));
                }
            }
        }
        return dp[n][t];
    }

    public static void main(String[] args) {
        System.out.println(getMax(5,3,1,new int[][]{
                {1,2,3,4,5},
                {2,3,3,4,6},
                {3,3,3,2,5}
        }));
    }
}
