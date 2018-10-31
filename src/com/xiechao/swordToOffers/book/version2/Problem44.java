package com.xiechao.swordToOffers.book.version2;

import org.junit.Test;

/**
 * @ClassName Problem44
 * @Author xiechao
 * @Date 2018/10/31
 * @Time 10:11
 * @Description 数字序列中的某一位数
 */
public class Problem44 {
    public int digitAtIndex(int index){
        if(index < 0)
            return -1;
        int digits = 1;
        while(true){
            int numbers = countOfInteger(digits);
            if(index < numbers * digits)
                return digitAtIndex(index,digits);
            index -= numbers * digits;
            digits++;
        }
    }
    private int digitAtIndex(int index,int digits){
        int temp = beginNumberOf(digits) + index /digits;
        int indexFromRight = digits - index % digits;
        for (int i = 1; i < indexFromRight; i++) {
            temp /= 10;
        }
        return temp % 10;
    }

    private int beginNumberOf(int digits) {
        if(digits == 1) return 0;
        else
            return (int)Math.pow(10,(digits-1));
    }

    /**
     *
     * @param digits 代表几位数
     * @return 返回digits位数的个数。
     * 比如1位数有[0，9] 10个
     * 2位数有[10,99] 90个
     * 3位数有[100,999] 900个
     */
    private int countOfInteger(int digits) {
        if(digits == 1)
            return 10;
        int count =(int) Math.pow(10,digits-1);
        return 9 * count;
    }
    @Test
    public void test(){
        System.out.println(digitAtIndex(1001));
    }
}
