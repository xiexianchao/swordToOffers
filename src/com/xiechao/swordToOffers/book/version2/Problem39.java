package com.xiechao.swordToOffers.book.version2;

import org.junit.Test;

/**
 * @ClassName Problem39
 * @Author xiechao
 * @Date 2018/10/21
 * @Time 17:01
 * @Description 找出数组中出现次数超过一半的元素
 * 要求时间复杂度：O(n)
 * 两种解法
 */
public class Problem39 {
    //可以修改输入数组解法
    public int moreThanHalfOfNum(int[] array){
        if(array == null || array.length <=0) return 0;
        if(array.length == 1) return array[0];
        int start = 0;
        int end = array.length - 1;
        int mid = (start + end)/2;
        int index = partition(array,start,end);
        while(index != mid){
            if(index > mid)
                end = index - 1;
            else if(index < mid)
                start = index + 1;
            index = partition(array,start,end);
        }
        int count = 0;
        for (int e:array) {
            if(e == array[index])
                count++;
        }
        if(count * 2 <= array.length)
            return 0;
        return array[index];
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

    //不可以修改输入数组
    public int moreThanHalfOfNum2(int[] array){
        if (array == null || array.length <=0) return 0;
        int candidate = array[0];
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if(candidate != array[i])
                count--;
            else
                count++;
            if(count == 0) {
                count = 1;
                candidate = array[i];
            }
        }
        count = 0;
        for (int e:array) {
            if(e == candidate)
                count++;
        }
        if(count *2 <= array.length)
            return 0;

        return candidate;
    }

    @Test
    public void test(){
        System.out.println(moreThanHalfOfNum2(new int[]{1,2,3,2,2,2,5,4,2}));
    }
}
