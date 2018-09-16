package com.xiechao.swordToOffers.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LeetCode
 * @Author xiechao
 * @Date 2018/9/15
 * @Time 11:25
 * @Description Two Sum
 */
public class LeetCode1 {
    public int[] twoSum(int[] nums, int target) {
        if( null == nums || nums.length <=0) return null;
        Map<Integer,Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target- nums[i])){            //必须检测再put入，例如{3，3}，6
                result[0] = i;
                result[1] = map.get(target - nums[i]);
                return result;
            }
            map.put(nums[i],i);
        }
        return result;
    }
}
