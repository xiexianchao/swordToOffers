package com.xiechao.swordToOffers.book.version2;

import org.junit.Test;

/**
 * @ClassName Problem51
 * @Author xiechao
 * @Date 2018/11/1
 * @Time 10:33
 * @Description 数组中的逆序对数
 * 使用归并排序的方法
 */
public class Problem51 {
    //剑指offer上改编，逻辑有点乱
    public int InversePairs(int [] array) {
        if(array == null || array.length <= 1) return 0;
        int[] copy = new int[array.length];
        for (int i = 0; i < copy.length; i++) {
            copy[i] = array[i];
        }
       int count =  helper(array,copy,0,array.length-1);
        return count;
    }

    private int helper(int[] array, int[] copy, int start, int end) {
        if( start == end){
            copy[start] = array[start];
            return 0;
        }
        int length = (end - start) >>> 1;
        int left = helper(copy,array,start,start + length);
        int right = helper(copy,array,start + length + 1,end);
        int p1 = start + length;
        int p2 = end;
        int p3 = end;
        int count = 0;
        while( p1 >= start && p2 >= (start+length+1)){
            if(array[p1] > array[p2]){
                copy[p3 --] = array[p1 --];
                count += p2 - (start + length);
            }else{
                copy[p3 --] = array[p2 --];
            }
        }
        for (; p1 >= start ; p1--) {
            copy[p3--] = array[p1];
        }
        for (; p2 >= start + length + 1 ; p2--) {
            copy[p3--] = array[p2];
        }
        return left + right + count;
    }

    //github大神  思路清晰
    public int InversePairs2(int [] array){
        if(array == null || array.length <= 0) return 0;
        int[] copy = new int[array.length];
        return sort(array,copy,0,array.length - 1);
    }
    private int sort(int[] array,int[] copy,int low,int high){
        if(low >= high) return 0;
        int mid = (low + high) / 2;
        int left = sort(array,copy,low, mid);     //递归拆分子数组
        int right = sort(array,copy, mid + 1,high);
        int merged = merge(array,copy,low,mid,high);  //将array[low,mid],array[mid+1,high]两个子数组合并
        return left + right + merged;
    }

    private int merge(int[] array, int[] copy, int low, int mid, int high) {
        int count = 0;
        int p1 = mid;  // low - mid
        int p2 = high; // mid + 1 -low
        int p3 = high;

        for (int i = low; i <= high; i++) {
            copy[i] = array[i];
        }
        while(p1 >= low && p2 >= mid +1){
            if(copy[p1] > copy[p2]){
                array[p3--] = copy[p1--];
                count += p2 - mid;
            }else{
                array[p3--] = copy[p2--];
            }
        }
        while(p1 >= low)
            array[p3--] = copy[p1--];
        while(p2 >= mid + 1)
            array[p3--] = copy[p2--];
        return count;

    }

    @Test
    public void test(){
        System.out.println(InversePairs(new int[]{7,5,6,4}));
        System.out.println(InversePairs2(new int[]{7,5,6,4}));
    }
}
