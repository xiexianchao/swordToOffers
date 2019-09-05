package com.xiechao.swordToOffers.book.version2;

import org.junit.Test;

/**
 * @ClassName Problem38_4
 * @Author xiechao
 * @Date 2018/10/21
 * @Time 16:49
 * @Description 八皇后问题
 */
public class Problem38_4 {
    public int totalNQueens(int N){
        if(N <=0) return 0;
        int[] columnIndex = new int[N];
        for (int i = 0; i < columnIndex.length ; i++) {
            columnIndex[i] = i;
        }
        int[] result = new int[]{0};
        helper(result,columnIndex,0);
        return result[0];
    }

    private void helper(int[] result, int[] columnIndex, int start) {
        if(start == columnIndex.length){
            if(check(columnIndex)){
                result[0]++;
            }
            return;
        }
        for (int i = start; i < columnIndex.length ; i++) {
            swap(columnIndex,start,i);
            helper(result,columnIndex,start+1);
            swap(columnIndex,start,i);
        }

    }

    private boolean check(int[] columnIndex) {
        for (int i = 0; i < columnIndex.length; i++) {
            for (int j = i+1; j < columnIndex.length; j++) {
                if((i-j == columnIndex[i] -columnIndex[j]) || ((j-i == columnIndex[i] - columnIndex[j])))
                    return false;
            }
        }
        return true;
    }

    private void swap(int[] nums, int start, int i) {
        int temp = nums[start];
        nums[start] = nums[i];
        nums[i] = temp;
    }

    @Test
    public void test(){
        System.out.println(totalNQueens(9));
    }
}
