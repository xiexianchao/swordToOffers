package com.xiechao.swordToOffers.algorithms.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xiechao
 * @Date : 2018/10/23
 * @Time : 9:22
 * @description :Permutation Sequence
 * 求1...n全排列的，第k个最序列
 */
public class LeetCode60 {

        StringBuilder result = new StringBuilder();
        //使用全排列的方法会 time out
        public String getPermutation(int n, int k) {

            if(n <1 || k <0 ) return result.toString();
            int temp = 1;
            for (int i = 1 ; i <= n; i++) {
                temp *=i;
            }
            if( k > temp) return result.toString();
            helper(n,k,0,new int[]{0},new ArrayList<Integer>());
            return result.toString();
        }

        private boolean helper(int n, int k, int start, int[] count, List<Integer> tempList) {
            if(n == start){
                count[0]++;
                if(count[0] == k)
                {
                    for (Integer e:tempList) {
                        result.append(e);
                    }
                    return true;
                }
                return false;
            }
            for (int i = 1; i <= n ; i++) {
                if(tempList.contains(i)) continue;
                tempList.add(i);
                if(helper(n,k,start+1,count,tempList)){
                    return true;
                }
                tempList.remove(tempList.size()-1);
            }
            return false;
        }
        // 使用循环的方法
    public String getPermutation2(int n, int k) {
        StringBuilder sb = new StringBuilder();
        if(n < 1 || k < 1) return sb.toString();
        int[] nums = new int[n+1];
        nums[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            nums[i]=i*nums[i-1];
        }
        if(k > nums[n]) return sb.toString();
        k = k -1;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n ; i++) {
            list.add(i);
        }
        for (int i = 1; i <= n ; i++) {
            int index = k / nums[n-i];
            sb.append(list.get(index));
            list.remove(index);
            k = k % nums[n-i];
        }
        return sb.toString();


    }


    @Test
    public void test(){
        System.out.println(getPermutation2(8,8590));
    }
}
