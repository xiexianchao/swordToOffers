package com.xiechao.swordToOffers.book.version2;

import java.util.ArrayList;

/**
 * @ClassName Problem57_1
 * @Author xiechao
 * @Date 2018/11/2
 * @Time 11:15
 * @Description 递增数组中和为s的两个数字
 */
public class Problem57 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        if(array == null || array.length <= 0 )
            return result;
        int p1 = 0;
        int p2 = array.length - 1;
        while(p1 < p2){
            if(array[p1] + array[p2] > sum){
                p2 --;
            }else if (array[p1] + array[p2] < sum){
                p1++;
            }else{
                result.add(array[p1]);
                result.add(array[p2]);
                return result;
            }
        }
        return result;
    }
}
