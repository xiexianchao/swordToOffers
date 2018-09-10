package com.xiechao.swordToOffers.book.version2;

import org.junit.Test;

/**
 * @author: xiehcao
 * @Date : 2018/9/4
 * @Time : 11:31
 * @description :不修改数组找出数组中的重复数字
 * @Method: 利用二分查找，查找统计一定范围内数字出现的次数
 */
public class Problem3_1 {
    private int findDuplicateNumberWithOutModify(int[] nums){
        int result = -1;
        if( null != nums && nums.length >0){
            int start = 1;
            int end = nums.length-1;
            while(end >= start){
                int mid = (end + start)>>>1;
                int count = countRange(nums,start,mid);
                if(start == end){
                    if(count>1) {
                        result = start;
                    }
                     break;
                }
                if( count > (mid-start+1)){
                    end = mid;
                }else
                    start = mid + 1;
            }
        }
        return result;
    }
    private  int countRange(int[] nums,int start,int end){
        int count =0 ;
        for (int e:nums) {
            if(e <= end  && e >= start)
                count++;
        }
        return count;
    }


    @Test
    public void test(){
        System.out.println(findDuplicateNumberWithOutModify(new int[]{2,3,5,4,3,2,6,7}));
    }
}
