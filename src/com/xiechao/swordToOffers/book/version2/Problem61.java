package com.xiechao.swordToOffers.book.version2;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName Problem61
 * @Author xiechao
 * @Date 2018/11/12
 * @Time 11:04
 * @Description 判断扑克牌是否为顺子
 * 大小王可以表示任何数字，用0表示
 * J - 11 ,Q - 12 ,K - 13
 */
public class Problem61 {
    //统计0的个数，补差值
    public boolean isContinuous(int [] numbers) {
        if(numbers == null || numbers.length <= 0) return false;
        Arrays.sort(numbers);
        int zeroOfO = 0;
        for (int i = 0; i < numbers.length ; i++) {
            if(numbers[i] == 0) zeroOfO++;
        }
        for (int i = zeroOfO; i < numbers.length-1; i++) {
            if(numbers[i+1] == numbers[i])
                 return false;
            else if(numbers[i+1] - numbers[i] != 1){
                zeroOfO -= numbers[i+1] - numbers[i] - 1;
            }
        }
        return  zeroOfO >= 0;
    }
    @Test
    public void test(){
        System.out.println(isContinuous(new int[]{1,0,0,1,0}));
    }
}
