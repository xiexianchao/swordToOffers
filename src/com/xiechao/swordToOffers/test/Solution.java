package com.xiechao.swordToOffers.test;
import org.junit.Test;

import java.util.PriorityQueue;
import java.util.Comparator;


//最大堆与最小堆的问题，Java中PriorityQueue就是对应的最小堆

public class Solution {

    //生成最大堆
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(11,new maxHeapComparator());
    //生成最小堆
    private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(11,new minHeapComparator());

    public void reshapeHeapSize(){
        if(this.maxHeap.size() == this.minHeap.size() + 2){
            this.minHeap.add(this.maxHeap.poll());
        }
        if(this.minHeap.size() == this.maxHeap.size() + 2){
            this.maxHeap.add(this.minHeap.poll());
        }
    }

    public void Insert(Integer num) {
        if(this.maxHeap.isEmpty()){
            this.maxHeap.add(num);
        }else{
            if(this.maxHeap.peek() > num){
                this.maxHeap.add(num);
            }else{
                if(this.minHeap.isEmpty()){
                    this.minHeap.add(num);
                }else{
                    if(this.minHeap.peek() <= num){
                        this.minHeap.add(num);
                    }else{
                        this.maxHeap.add(num);
                    }
                }
            }
        }
        reshapeHeapSize();
    }

    public Double GetMedian() {
        Integer maxSize = this.maxHeap.size();
        Integer minSize = this.maxHeap.size();
        if(maxSize+minSize == 0){
            throw new RuntimeException();
        }
        Integer maxHeapNum = this.maxHeap.peek();
        Integer minHeapNum = this.minHeap.peek();
        if(maxHeapNum == null) maxHeapNum = 0;
        if(minHeapNum == null) minHeapNum = 0;
        if(((maxSize + minSize) & 1) == 0){
            return (double)((maxHeapNum+minHeapNum)/2);
        }else{
            return (double)(maxSize > minSize ? maxHeapNum : minHeapNum);
        }
    }

    class minHeapComparator implements Comparator<Integer>{
        public int compare(Integer o1,Integer o2){
            return o1-o2;
        }
    }
    class maxHeapComparator implements Comparator<Integer>{
        public int compare(Integer o1,Integer o2){
            return o2-o1;
        }
    }

    @Test
    public void test(){
        Solution solution = new Solution();
        solution.Insert(5);
        System.out.println(solution.GetMedian());
    }
}