package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;

/**
 * @author: xiehcao
 * @Date : 2018/10/16
 * @Time : 8:50
 * @description :删除链表倒数第n个结点
 * 剑指Offer原题
 */
public class LeetCode19 {
    private class ListNode{
        int val;
        ListNode next;
        ListNode(int x){ val = x;}
    }
    //先统计链表结点树，count-n   9ms
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n <=0 ) return head;
        int count = 0;
        ListNode node = head;
        while(node != null){
            count++;
            node = node.next;
        }
        if( n > count) return head;
        if( n == count ) return head.next;

        n = count - n;
        node = head;
        ListNode pre = null;
        while(n !=0 && node != null){
            n -- ;
            pre = node;
            node = node.next;
        }
        pre.next = node.next;
        return head;
    }
    //8ms 两个指针
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if(head == null || n <=0 ) return head;

        ListNode p1  = head;
        ListNode p2 = head;
        while(p2 != null && n !=0){
            p2 = p2.next;
            n--;
        }
        ListNode pre = null;
        if( n == 0 && p2 == null) return head.next; //删除头结点
        if(p2 == null) return head;  //如果n 大于链表长度
        //if(p2.next == null) return head.next; // 删除头结点

        while(p1 != null && p2 != null){
            pre = p1;
            p1 = p1.next;
            p2 = p2.next;
        }
        pre.next = p1.next;
        return head;
    }
    //屏蔽掉删除头结点的影响
    public ListNode removeNthFromEnd3(ListNode head, int n){
        if(head == null || n <=0 ) return head;
        ListNode pHead = new ListNode(1);   //添加一个伪头结点
        pHead.next = head;
        ListNode p1 = pHead;
        ListNode p2 = pHead;
        while(p2 != null && n != 0){
            p2 = p2.next;
            n--;
        }
        if(n >0 && p2 == null) return head;

        ListNode pre = null;
        while(p1 != null && p2 != null){
            pre = p1;
            p1 = p1.next;
            p2 = p2.next;
        }
        pre.next = p1.next;
        return pHead.next;
    }


    @Test
    public void test(){
        removeNthFromEnd2(new ListNode(1),1);
    }
}
