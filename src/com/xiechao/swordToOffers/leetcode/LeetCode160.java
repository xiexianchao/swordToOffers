package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;

/**
 * @ClassName LeetCode160
 * @Author xiechao
 * @Date 2018/9/17
 * @Time 12:04
 * @Description 160. Intersection of Two Linked Lists
 * 找出两个链表的公共第一个节点
 */
public class LeetCode160 {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next = null;
        }
    }
    //2ms
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        int nA = 0;
        int nB = 0;
        ListNode curA = headA;
        ListNode curB = headB;
        while( curA != null){
            nA++;
            curA = curA.next;
        }
        while( curB != null){
            nB++;
            curB = curB.next;
        }
        int temp = Math.abs(nA - nB);
        curA = headA;
        curB = headB;
        while( temp > 0){
            if(nA > nB){
                curA = curA.next;
            }else{
                curB = curB.next;
            }
            temp--;
        }
        while( curA != null && curB !=null && curA != curB){
            curA = curA.next;
            curB = curB.next;
        }
        return (curA == null || curB ==null )? null:curA;
    }

    //LeetCode大神 lms 即简洁又美观
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB){
        if(headA == null || headB == null) return null;
        ListNode curA = headA;
        ListNode curB = headB;
        while( curA != curB){
            curA = curA == null?headB:curA.next;
            curB = curB == null?headA:curB.next;
        }
        return curA;
    }
    @Test
    public void test(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node3.next = node4;
        node4.next = node5;
        getIntersectionNode2(node1,node3);
    }
}
