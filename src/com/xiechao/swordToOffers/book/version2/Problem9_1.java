package com.xiechao.swordToOffers.book.version2;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: xiehcao
 * @Date : 2018/9/10
 * @Time : 14:53
 * @description :用两个队列实现栈
 */
public class Problem9_1 {
    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    void push(int node){
        if(queue1.isEmpty()){
            queue2.add(node);
        }else
            queue1.add(node);
    }
    int pop(){
        Queue<Integer> queue = queue1.isEmpty()? queue2:queue1;
        Queue<Integer> queueOther = queue1.isEmpty()?queue1:queue2;
        while(queue.size() > 1){
            queueOther.add(queue.remove());
        }
        return queue.remove();
    }

    @Test
    public void test(){
        Problem9_1 stack = new Problem9_1();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(5);
        stack.push(6);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

}
