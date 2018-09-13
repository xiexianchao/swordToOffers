package com.xiechao.swordToOffers.book.version2;

/**
 * 数值的整数次方
 */
public class Problem16 {
    double power(double base,int exponent){
        if(exponent == 0)
            return 1;
        double result = unsignedPower(base,Math.abs(exponent));
        if(exponent < 0){
            result = 1 / result;
        }return result;
    }

    double unsignedPower(double base,int exponent){
        if(exponent == 0)
            return 1;
        if(exponent == 1)
            return base;
        double result = 1.0;
        result = unsignedPower(base,exponent/2);
        result = result * result;
        if((exponent & 1) == 1)
            result = result * base;
        return result;

    }




}
