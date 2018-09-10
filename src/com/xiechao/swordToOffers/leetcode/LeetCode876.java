package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;

/**
 * @author: xiehcao
 * @Date : 2018/9/6
 * @Time : 19:51
 * @description :
 */
public class LeetCode876 {
    private static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){this.val = val;}
    }
    public ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode node = head;
        while(node !=null){
            count ++;
            node = node.next;
        }
       /* if( (count & 0x1) ==0){
            count = (count>>>1) + 1;
        }else*/
            count = count >>>1;        //直接/2就行了
        node = head;
        while(count >0){
            node = node.next;
            count --;
        }
        return node;
    }

    @Test
    public void test(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        middleNode(node1);
    }
}
