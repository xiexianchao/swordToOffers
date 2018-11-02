package com.xiechao.swordToOffers.book.version2;

/**
 * @ClassName LeetCode53
 * @Author xiechao
 * @Date 2018/11/1
 * @Time 11:35
 * @Description 在排序数组中查找数字
 * 统计一个数字在排序数组中出现的次数。
 * 遇到排序过的数组：首先必须想到二分法
 *
 */
public class Problem53 {
    public int GetNumberOfK(int [] array , int k) {
        if(array == null ||
                array.length <= 0 ||
                k < array[0] ||
                k > array[array.length - 1])
            return 0;
        int firstIndex  = getFirstIndex(array,k,0,array.length - 1);
        int lastIndex  = getLastIndex(array,k,0,array.length - 1);
        if(firstIndex == -1 || lastIndex == -1) return 0;
        return lastIndex - firstIndex + 1;
    }

    private int getFirstIndex(int[] array, int k, int start, int end) {
        if(start > end) return -1;
        while(start <= end){
            int mid = (end + start)/2;
            if(array[mid] > k){
                end = mid - 1;
            }else if(array[mid] < k){
                start = mid + 1;
            }else if(array[mid] == k){
                if(mid == start ||array[mid - 1] != k){
                    return mid;
                }else{
                    end = mid - 1;
                }
            }
        }
        return  -1;
    }
    private int getLastIndex(int[] array, int k, int start, int end) {
        if(start > end) return -1;
        while(start <= end){
            int mid = (end + start)/2;
            if(array[mid] > k){
                end =  mid - 1;
            }else if(array[mid] < k){
                start = mid + 1;
            }else if(array[mid] == k){
                if(mid == end ||array[mid + 1] != k){
                    return mid;
                }else{
                    start = mid + 1;
                }
            }
        }
        return  -1;
    }

}
