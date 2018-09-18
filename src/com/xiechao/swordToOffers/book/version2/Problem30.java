package com.xiechao.swordToOffers.book.version2;

import org.junit.Test;

import java.util.Stack;

/**
 * @ClassName Problem30
 * @Author xiechao
 * @Date 2018/9/18
 * @Time 11:42
 * @Description 最小栈
 */
public class Problem30 {
    class MinStack{
        private Stack<Integer> stack = null;
        private int min = Integer.MAX_VALUE;

        public MinStack() {
            this.stack = new Stack<>();
        }
        public void push(int x){
            if(min >= x){
                stack.push(min);
                min = x;
            }
            stack.push(x);
        }
        public void pop(){
            if(!stack.isEmpty()) {
                if (stack.pop() == min) {
                    min = stack.pop();
                }
            }

        }
        public int min(){
            return min;
        }
        //stack is empty ,return 0
        public int peak(){
            if(stack.isEmpty())
                return stack.peek();
            return 0;
        }



    }

}
