package com.xiechao.swordToOffers.book.version2;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName Problem59_1
 * @Author xiechao
 * @Date 2018/11/10
 * @Time 19:13
 * @Description:最大值队列
 */
public class Problem59_1 {
    class MaxQueue{
        private Deque<Integer> data = new LinkedList<>();
        private Deque<Integer> maxQueue = new LinkedList<>();

        public void offer(int num){
            data.addLast(num);
            if( maxQueue.isEmpty() ||num > maxQueue.getFirst())
                maxQueue.add(num);
            else
                maxQueue.add(maxQueue.peekFirst());
        }
        public void poll(){
            if(data.isEmpty()) throw new RuntimeException("队列为空");
            data.removeFirst();
            maxQueue.removeLast();
        }
        public int max(){
            if(maxQueue.isEmpty()) throw new RuntimeException("队列为空");
            return maxQueue.getFirst();
        }
    }


}
