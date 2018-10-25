package com.xiechao.swordToOffers.book.version2;

/**
 * @ClassName Problem38_3
 * @Author xiechao
 * @Date 2018/10/21
 * @Time 16:37
 * @Description 输入一个含8个数字的数组，判断有没有可能把这8个数字分别放正方体8个顶点上，是的正方体三组相对的面上
 * 4个顶点的和相等
 */
public class Problem38_3 {
    public boolean isThreeEquals(int[] nums){
        if(nums == null || nums.length != 8) return false;
        boolean[] result = new boolean[0];
        helper(result,nums,0);
        return result[0];
    }

    private void helper(boolean[] result, int[] nums, int start) {
        if(start == result.length){
            if(checkPossible(nums)){
                result[0] = true;
            }
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums,start,i);
            helper(result,nums,start+1);
            swap(nums,start,i);
        }
    }

    private boolean checkPossible(int[] nums) {
        if( nums[0] + nums[1] + nums[2] + nums[3] == nums[4] + nums[5] + nums[6] + nums[7] &&
                nums[0] + nums[2] + nums[4] + nums[6] == nums[1] + nums[3] + nums[5] + nums[7] &&
                nums[0] + nums[1] + nums[4] + nums[5] == nums[2] + nums[3] + nums[6] + nums[7]){
            return true;
        }
        return false;
    }

    private void swap(int[] nums, int start, int i) {
        int temp = nums[start];
        nums[start] = nums[i];
        nums[i] = temp;
    }


}
