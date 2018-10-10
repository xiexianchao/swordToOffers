package com.xiechao.swordToOffers.leetcode;

import java.util.Arrays;
import java.util.Random;

/**
 * @author: xiehcao
 * @Date : 2018/9/27
 * @Time : 10:03
 * @description :384. Shuffle an Array
 */
public class LeetCode384 {
  //LeetCode大神
    class Solution{
        private int[] orig = null;
        private Random random = new Random();
        public Solution(int[] nums) {
            orig = nums;
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return orig;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            int[] tmp = orig.clone();
            for (int i = orig.length-1,j=0; i >= 0 ; i--) {
                j = random(0,i);
                swap(tmp,i,j);
            }
            return tmp;

        }

      private void swap(int[] nums, int i, int j) {
          int temp = nums[i];
          nums[i] = nums[j];
          nums[j] = temp;
      }

      private int random(int min, int max) {
            return min + random.nextInt(max - min +1);
      }
  }
}
