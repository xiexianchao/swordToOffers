package com.xiechao.swordToOffers.book.version2;

import org.junit.Test;

/**
 * @ClassName Problem54
 * @Author xiechao
 * @Date 2018/11/2
 * @Time 8:39
 * @Description 0-n-1中缺失的数字
 * 一个长度为n-1的递归排序数组中所有数字都是唯一的，并且每个数字都在范围0-n-1之内。
 * 方法：二分查找法
 *  if number[mid] != mid
 *      if mid == start || number[mid-1] == mid -1
 *          return mid;
 *      else
 *          end = mid - 1;
 *  else
 *      start = mid + 1;
 */
public class Problem53_1 {
    public int getMissingNumber(int[] numbers){
        if(numbers == null || numbers.length <=0 ) return -1;
        int start = 0;
        int end = numbers.length - 1;
        while(start <= end){
            int mid = (start + end) >>>1;
            if (numbers[mid] != mid){
                if( mid == start  ||numbers[mid - 1] == (mid - 1)){
                    return mid;
                }else{
                    end = mid - 1;
                }

            }else{
                start = mid + 1;
            }
        }
        return -1;
    }
    @Test
    public void test(){
        System.out.println(getMissingNumber(new int[]{0,2,3,4,5,6,7,8}));
    }
}
