package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;

import java.util.Stack;

/**
 * @ClassName LeetCode155
 * @Author xiechao
 * @Date 2018/9/16
 * @Time 16:36
 * @Description 最小栈
 * 剑指Offer原题
 */
public class LeetCode155 {
    //127ms 用了两个栈来实现
    class MinStack{
        private Stack<Integer> stack1;
        private Stack<Integer> stack2;
        public MinStack() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void push(int x) {
            stack1.push(x);
            if( stack2.isEmpty() ||x <= stack2.peek())
                stack2.push(x);
        }

        public void pop() {
            if( !stack1.isEmpty()) {
                int x = stack1.pop();
                if(x == stack2.peek())
                    stack2.pop();
            }
        }

        public int top()  {
            if( ! stack1.isEmpty())
                return stack1.peek();
            else
                return 0;
        }

        public int getMin() {
            return stack2.peek();
        }
    }

    //LeetCode 62ms 大神，即节约了空间又节省了时间
    class MinStack2{
        private int min = Integer.MAX_VALUE;
        private Stack<Integer> stack = null;
        public MinStack2() {
            stack = new Stack<>();
        }

        public void push(int x) {
            if(x <= min){
                stack.push(min);
                min = x;
            }
            stack.push(x);
        }

        public void pop() {
            if(!stack.isEmpty()){
                if(stack.pop() == min) min = stack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min;
        }

    }

    @Test
    public void test(){
        MinStack2 minStack = new MinStack2();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
       System.out.println( minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }


}
