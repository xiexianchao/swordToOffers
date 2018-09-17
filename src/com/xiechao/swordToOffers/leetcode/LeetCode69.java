package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;

/**
 * @ClassName LeetCode69
 * @Author xiechao
 * @Date 2018/9/17
 * @Time 15:13
 * @Description Sqrt(x)
 */
public class LeetCode69 {
    //191ms,我成功在花费时间最多上击败了所有用户
    public int mySqrt(int x) {
        if( x == 0) return 0;
        if(x <4 && x>0) return 1;
        int pre = 0;
        for (int i = 2; i <= x/2 ; i++) {
            if( i <= x/i)
                pre= i;
            else
                break;
          //  System.out.println(i+": "+i*i);
        }
        return pre;
    }

    //LeetCode大神 二分查找 22ms
    public int mySqrt2(int x){
        if( x == 0) return 0;
        int start  = 0;
        int end = Integer.MAX_VALUE;
        while(true){
         int mid = start + (end - start)/2;
         if( mid > x /mid){
             end = mid - 1;
         }else{
             if((mid + 1) > x/(mid + 1))
                 return mid;
             start = mid + 1;
         }
        }
    }




    @Test
    public void test(){
        System.out.println(mySqrt2(2147395600));
    }
}
