package com.xiechao.swordToOffers.book;


import com.xiechao.swordToOffers.commom.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author: xiehcao
 * @Date : 2018/9/5
 * @Time : 15:28
 * @description :从尾到头打印链表
 * @Method : 逆序，第一反应，用栈来做。
 * 实际上，递归就是用栈来实现的，所以也可以用递归来做
 */
public class Problem6 {
    //借助栈来实现 牛客网测试 16ms
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if( listNode == null) return list;
        Stack<ListNode> stack = new Stack<>();
        ListNode currentNode = listNode;
        while( currentNode != null){
            stack.push(currentNode);
            currentNode = currentNode.next;
        }
        while( !stack.isEmpty()){
            list.add((Integer) stack.pop().value);
        }
        return list;
    }
    //递归
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode){
        ArrayList<Integer> list = new ArrayList<>();
        if(listNode == null)
            return list;


    }


    @Test
    public void test(){

    }


}
