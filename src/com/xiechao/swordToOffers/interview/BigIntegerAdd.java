package com.xiechao.swordToOffers.interview;

import org.junit.Test;

/**
 * @ClassName BigIntegerAdd
 * @Author xiechao
 * @Date 2018/11/19
 * @Time 9:25
 * @Description 求两个大数相加
 *
 * 做法:将两个大数拆成数组，数组左对齐，每个元素保存某位上的值
 * 定义一个结果数据，其长度为上面两个数组的长度+1。
 * 按位进行加法运算，注意进位情况
 */
public class BigIntegerAdd {
    public String addTwoBigInteger(String numberA,String numberB){
        if(numberA == null || numberB == null ) return null;
        if(numberA.length() <=0 ) return numberB;
        if(numberB.length() <= 0) return numberA;
        int length = Math.max(numberA.length(),numberB.length());
        int[] arrayA = new int[length];
        int[] arrayB = new int[length];
        for (int i = length - numberA.length(),count = 0  ; i < length ; i++,count++) {
            arrayA[i] = numberA.charAt(count) - '0';
        }
        for (int i = length - numberB.length(),count = 0 ; i < length; i++,count++) {
            arrayB[i] = numberB.charAt(count) - '0';
        }
        int[] arrayResult = new int[length + 1];
        int temp = 0;
        for (int i = arrayResult.length-1; i >= 0 ; i--) {
            arrayResult[i] = (i >= 1 ? arrayA[i-1] + arrayB[i-1]:0 ) + temp;
            temp = arrayResult[i] / 10;
            arrayResult[i] %= 10;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1 ; i < arrayResult.length; i++) {
            sb.append(arrayResult[i]);
        }
        if(arrayResult[0] != 0)
            sb.insert(0,arrayResult[0]);
        return sb.toString();
    }

    @Test
    public void test(){
        System.out.println(addTwoBigInteger("11111110000000000002","10000000000000000004"));
    }


}
