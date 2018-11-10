package com.xiechao.swordToOffers.book.version2;

import org.junit.Test;


import java.util.*;

/**
 * @ClassName Problem59
 * @Author xiechao
 * @Date 2018/11/10
 * @Time 18:28
 * @Description 滑动窗口的最大值
 */
public class Problem59 {
    //github 使用优先队列，最大堆
    public ArrayList<Integer> maxInWindows2(int [] num, int size){
        ArrayList<Integer> list = new ArrayList<>();
        if( num == null || size <=0 || num.length < size)
            return list;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        int j = 0;
        for (int i = 0; i < num.length; i++) {
            queue.offer(num[i]);
            if(queue.size() >= size){
                list.add(queue.peek());
                queue.remove(num[j++]);//remove会移除第一个元素
            }
        }
        return list;
     }



    //剑指offer解法
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> list = new ArrayList<>();
        if(num == null || num.length < size || size <=0 )
            return list;
        Deque<Integer> queue = new LinkedList<>();
        queue.add(0);
        for (int i = 1; i < size-1; i++) {
            while( (!queue.isEmpty()) && num[i] >= num[queue.getLast()]){
                queue.removeLast();
            }
            queue.addLast(i);
        }
        for (int i = size-1; i < num.length; i++) {
            while( (!queue.isEmpty()) && (i - size) >= queue.getFirst()){
                queue.removeFirst();
            }
            while( (! queue.isEmpty()) && num[i] >= num[queue.getLast()]){
                queue.removeLast();
            }
            queue.addLast(i);
            list.add(num[queue.getFirst()]);
        }
        return list;
    }
    @Test
    public void test(){
        System.out.println(maxInWindows2(new int[]{2,3,4,2,6,6,5,1},3));
    }
}
