package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;

/**
 * @author: xiehcao
 * @Date : 2018/9/3
 * @Time : 20:01
 * @description :求一个正整数的补码
 * @Method: 对输入的num与num二进制位数的最大值做异或运算能够得到补码
 *
 *   5 ^ 7 =2 ;
 *   5 - 101
 *   7 - 111
 *   2 - 010
 *
 *   1 ^ 0 = 0;
 *   1 - 1
 *   0 - 0
 *   0 - 0
 *
 */
public class LeetCode476 {


    public int findComplement1(int num){
        int result = -1;
        int origin = num;
        if(num >0){
            int count = 0;
            while(num !=0){
                count++;
                num = num>>1;
            }
            int temp = 1;
            while(count!=0){
                temp = temp*2;
                count = count -1;
            }
            temp = temp-1;
            result = origin ^ temp;
        }
        return result;
    }
    //直接api
    public int findComplement2(int num){
        int count = Integer.highestOneBit(num);  //highestOneBit 得到num最左边的1，后面全置为0
        //System.out.println(count);
        int temp = count*2 -1;
        int result = -1;
        if(num > 0){
            result = num ^ temp;
        }
        return result;
    }



    @Test
    public void test(){
        System.out.println(findComplement2(5));
        System.out.println(findComplement2(1));
        //System.out.println(5^7);
    }
}
