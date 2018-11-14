package com.xiechao.swordToOffers.book.version2;

/**
 * @ClassName Problem65
 * @Author xiechao
 * @Date 2018/11/14
 * @Time 15:02
 * @Description 不用加减乘除做加法
 *
 * 扩展：不引入第三个变量交换两个变量的值
 * a，b
 *
 * a = a + b
 * b = a - b
 * a = a - b
 * 或者
 * a = a^b;
 * b = a^b;
 * a = a^b;
 */
public class Problem65 {
    public int Add(int num1,int num2) {
        while(num2 != 0){
            int sum = num1 ^ num2;
            int carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        }
        return num1;
    }

    //
}
