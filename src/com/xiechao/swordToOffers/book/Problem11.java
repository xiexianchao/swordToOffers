package com.xiechao.swordToOffers.book;

import org.junit.Test;

/**
 * @author: xiehcao
 * @Date : 2018/9/10
 * @Time : 15:56
 * @description :数值的整次方
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class Problem11 {
    public double Power(double base, int exponent) {
        if(exponent == 0){
            return 1;
        }
        if( exponent < 0){

            return 1 / powerUnsigned2(base,Math.abs(exponent));
        }
        return powerUnsigned2(base,exponent);
    }


    //可以继续优化
    public double powerUnsigned(double base,int exponent){
        double result = 1;
        for (int i = 0; i <exponent ; i++) {
            result = result * base;
        }
        return result;
    }
    //优化
    public double powerUnsigned2(double base,int exponent){
        double result = 1;
        if( exponent == 0) return 1;
        if( exponent == 1) return base;
        result = powerUnsigned2(base,exponent >>>1);
        result = result * result;
        if((exponent & 1) == 1)
            result = result * base;
        return  result;
    }

    @Test
    public void test(){
        System.out.println(Power(2,3));
    }

}
