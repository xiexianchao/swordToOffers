package com.xiechao.swordToOffers.algorithms.greedy;

import org.junit.Test;

/**
 * @ClassName LeetCode402
 * @Author xiechao
 * @Date 2018/11/26
 * @Time 8:47
 * @Description N位数删除k个数字，使得剩下的数字最小
 * 思想和LeetCode31大致相同
 * 贪心：
 */
public class LeetCode402 {
    //程序员小灰
    public String removeKdigits(String num, int k) {
        if(num == null || num.length() <=0 ) return num;
        if(num.length() <= k) return "0";
        int newLength = num.length() - k;
        char[] stack = new char[num.length()];
        int top = 0;
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while(top > 0 && stack[top-1] > c && k > 0){  //删除左边大于右边的数
                top -= 1;
                k --;
            }
            stack[top++] = c;
        }
        int offset = 0;
        while(offset < newLength && stack[offset] == '0'){
            offset++;
        }
        //为什么可以直接去除后面几位？因为后面的数肯定要比前面的数大，即从左到右是个单调不减的序列
        return offset == newLength ?"0":new String(stack,offset,newLength-offset);
    }
    @Test
    public void test(){
        System.out.println(removeKdigits("5337",2));
    }
}
