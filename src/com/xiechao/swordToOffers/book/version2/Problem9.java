package com.xiechao.swordToOffers.book.version2;

import java.util.Stack;

/**
 * @author: xiehcao
 * @Date : 2018/9/10
 * @Time : 14:52
 * @description :用两个栈实现队列
 */
public class Problem9 {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node){
        stack1.push(node);
    }
    int pop(){
        if(stack2.isEmpty()){
            while(! stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
