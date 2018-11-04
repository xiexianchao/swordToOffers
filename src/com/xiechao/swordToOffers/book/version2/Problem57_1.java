package com.xiechao.swordToOffers.book.version2;

import java.util.ArrayList;

/**
 * @ClassName Problem57_1
 * @Author xiechao
 * @Date 2018/11/4
 * @Time 10:19
 * @Description 和位s的连续正数序列
 * 至少包含两个元素
 *
 * 举个例子假设s等于9。
 * 对初始序列求和得到3，如果小于9，说明需要扩大序列使它包含更多数字，那就增加一个数字，
 * 现在序列变成{1,2, 3}，对序列求和继续和9比较，还小了，
 * 那就再增加一个数字序列变成{1, 2, 3 ,4}，这次序列和比9大了，
 * 丢弃序列中的最小值，现在序列变成{2, 3, 4}，序列求和刚好等于9！
 * 因此{2, 3, 4}是一个满足条件的序列，继续找。
 * 满足条件的其他序列肯定在后面，所以此时需要扩大序列，
 * 因此增加一个数字序列变成{2,3,4,5}, 序列和比9大，
 * 不断丢弃最小值直到序列和小于等于9，
 * 因此丢弃2、丢弃3，现在剩下{4, 5}，序列和和9相等，又找到一个！
 * 后面还有没有满足条件的序列呢？
 * **注意到序列是递增的，而且满足条件的序列至少有两个数。
 * **那么满足条件的序列中最大的数不会⌈s / 2⌉了，
 * 因为5之后是6，加起来超过9了，所以从5开始其后的序列都不可能满足条件。
 */
public class Problem57_1 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(sum <= 0) return result;
        int small = 1;
        int big = 2;
        int curSum = small + big;
        while(small < ((sum + 1) >>>1) ){
            while(curSum > sum && small < ((sum+1)>>>1)) {
                curSum -= small;
                small++;
            }
            if(curSum == sum) {
                ArrayList<Integer> tempList = new ArrayList<>();
                for (int i = small; i <= big; i++) {
                    tempList.add(i);
                }
                result.add(tempList);
            }
                big++;
                curSum += big;
        }
        return result;
    }
}
