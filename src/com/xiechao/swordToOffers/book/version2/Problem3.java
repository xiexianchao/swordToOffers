package com.xiechao.swordToOffers.book.version2;

import com.sun.org.apache.regexp.internal.RESyntaxException;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: xiehcao
 * @Date : 2018/9/4
 * @Time : 11:13
 * @description :找出数组中的任一重复数字
 */
public class Problem3 {


    //map
    public int findDuplicateNumber1(int[] nums){
        int result = -1;
        if(nums != null && nums.length >0){
            Map<Integer,Integer> map = new HashMap<>();
            for (Integer e : nums) {
                map.merge(e,1,Integer::sum);
            }
            for(Map.Entry<Integer,Integer> entry:map.entrySet())
            {
                if(entry.getValue() > 1)
                {
                    result = entry.getKey();
                }
            }

        }
        return result;
    }


    //利用数组元素都在0-n-1的范围内这个特征
    public int findDuplicateNumber2(int[] nums){
        int result = -1;
        if( null != nums && nums.length >0 ){
            for (int i = 0; i < nums.length;) {
                int value = nums[i];

                if(value == i){
                    i++;
                }
                else if(nums[value] == value){
                    result = value;
                    break;
                }else{
                    int temp = nums[value];
                    nums[value] = value;
                    nums[i] = temp;
                }
              //  System.out.println(Arrays.toString(nums));
            }
        }
        return result;
    }


    @Test
    public void test(){
        int[] nums = new int[]{2,3,1,0,2,5,3};
        System.out.println(findDuplicateNumber2(nums));
    }

}
