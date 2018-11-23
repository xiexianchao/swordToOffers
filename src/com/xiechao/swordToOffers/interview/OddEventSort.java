package com.xiechao.swordToOffers.interview;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName OddEventSort
 * @Author xiechao
 * @Date 2018/11/23
 * @Time 8:48
 * @Description 奇偶排序
 * 将奇数放在左边，偶数排到右边，相对位置不变
 * 第一直觉：冒泡可以做
 */
public class OddEventSort {
    // 冒泡排序  n*n时间复杂度
    public void reOrderArray(int [] array){
        if(array == null || array.length <= 0) return;
        for (int j = 0; j < array.length; j++) {   // 0 - n
            for (int i = 0; i < array.length-1-j; i++) {  // 0-n-1-i a[i]和a[i+1]比较，如果是1-n-i，则是a[i-1]和a[i]比较
                if(((array[i+1] & 1) != 0) && (array[i] & 1) == 0 ){
                    int temp =array[i+1];
                    array[i+1] = array[i];
                    array[i] = temp;
                }
            }
        }
    }
    //归并排序
    public void reOrderArray2(int [] array) {
        if(array == null || array.length <=1) return;
        reOrderArray2(array,0,array.length - 1);
        return;
    }
    private void reOrderArray2(int[] array,int start ,int end){
        if(start >= end) return;
        int mid = (start + end) / 2;
        int[] copy = Arrays.copyOf(array,array.length);
        reOrderArray2(copy,start,mid);
        reOrderArray2(copy,mid+1,end);
        merge(array,copy,start,mid,end);
    }

    //这里要从头开始合并，而不能从末尾开始合并
    private void merge(int[] array, int[] copy, int start,int mid ,int end) {
        if(start >= end) return;
        int p1 = start;
        int p2 = mid + 1;
        int p3 = start;
        while(p1 <= mid){
            if( (copy[p1] & 1) == 1){
                array[p3++] = copy[p1];
            }
            p1++;
        }
        while(p2 <= end){
            if((copy[p2] & 1) == 1){
                array[p3++] = copy[p2];
            }
            p2++;
        }
        p1 = start;
        p2 = mid + 1;
        while(p1 <= mid){
            if( (copy[p1] & 1) == 0){
                array[p3++] = copy[p1];
            }
            p1++;
        }
        while(p2 <= end){
            if((copy[p2] & 1) == 0){
                array[p3++] = copy[p2];
            }
            p2++;
        }
    }
    @Test
    public void test(){
        int[] array = new int[]{2,6,4,1,3,5};
        reOrderArray2(array);
        System.out.println(Arrays.toString(array));
    }
}
