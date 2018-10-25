package com.xiechao.swordToOffers.book.version2;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @ClassName Problem40
 * @Author xiechao
 * @Date 2018/10/21
 * @Time 17:34
 * @Description 求输入数组中最小的k个数，对于数据量小的输入,并可以修改输入数组，不需要额外的空间
 * 如果数据量很大，请看Problem41，不能修改数组
 */
public class Problem40 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if(input == null || input.length <=0) return result;
        if(input.length <= k){
            for (Integer e:input) {
                result.add(e);
            }
            return result;
        }
        int start = 0;
        int end = input.length - 1;
        int index = partition(input,start,end);
        while(index != k -1 ){
            if(index > k - 1){
                end = index - 1;
            }else{
                start = index + 1;
            }
            index = partition(input,start,end);
        }
        for (int i = 0; i < k ; i++) {
            result.add(input[i]);
        }
        return result;
    }
    private int partition(int[] array,int low,int high){
        int temp = array[low];
        while(low < high){
         while(low < high && array[high] > temp)
             high--;
         swap(array,low,high);
         while(low < high && array[low] <= temp)
            low++;
         swap(array,low,high);
        }
        array[low] = temp;
        return low;
    }
    private void swap(int[] nums, int start, int i) {
        int temp = nums[start];
        nums[start] = nums[i];
        nums[i] = temp;
    }

    @Test
    public void test(){
        System.out.println(GetLeastNumbers_Solution(new int[]{4,5,1,6,2,7,3,8},3));
    }
}
