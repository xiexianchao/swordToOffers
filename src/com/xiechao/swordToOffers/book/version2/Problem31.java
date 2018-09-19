package com.xiechao.swordToOffers.book.version2;

import java.util.Stack;

/**
 * @ClassName Problem31
 * @Author xiechao
 * @Date 2018/9/18
 * @Time 11:54
 * @Description
 * 输入两个整数序列，第一个序列表示栈的压入顺序，
 * 请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */
public class Problem31 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA == null && popA == null) return true;
        if(pushA == null || popA == null) return false;
        if(pushA.length == 0 && popA.length == 0 )return true;

        Stack<Integer> stack = new Stack<>();
        int count = 0;
        int index = 0;
         while(count < popA.length) {
             while (stack.isEmpty() || stack.peek() != popA[count]) {
                 if (index == pushA.length)
                     break;
                 stack.push(pushA[index++]);
             }
             if(stack.peek() != popA[count])
                 break;
             stack.pop();
             count++;
         }
        if( count == popA.length && index == pushA.length)
            return true;
         return false;

    }
}
