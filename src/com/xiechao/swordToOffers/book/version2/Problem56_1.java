package com.xiechao.swordToOffers.book.version2;

import org.junit.Test;

/**
 * @ClassName Problem56_1
 * @Author xiechao
 * @Date 2018/11/2
 * @Time 10:57
 * @Description 数组中唯一出现一次的数字。
 * 在一个数组中除了一个数字只出现一次之外，其他数字都出现了三次，请找出那个只出现一次的数字.
 * 时间复杂度为n，空间复杂度度为1
 * 可以扩展到求一个数组中其它元素都出现n次，有一个元素出现了1次，求这个元素。
 * */
public class Problem56_1 {
    public int findNumberAppearOnlyOnce(int[] numbers) {
        if(numbers == null || numbers.length <= 0) return -1;  //IllInputException
        int[] bitSum = new int[32];   //int 有32位
        int count = 0;
        for (Integer e : numbers) {
            count = 31;
            while( e != 0){
                bitSum[count] += e & 1;
                count --;
                e >>>=1;
            }
        }
        int result = 0;
        for (int i = 0; i <= 31; i ++) {
            result <<= 1;
            result += bitSum[i] % 3;
        }
        return result;
    }
    @Test
    public void test(){
        System.out.println(findNumberAppearOnlyOnce(new int[]{2,2,3,4,5,3,4,4,3,2}));
    }
}
