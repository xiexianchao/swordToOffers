package com.xiechao.swordToOffers.algorithms.linklist;

import com.xiechao.swordToOffers.algorithms.ListNode;
import org.junit.Test;

/**
 * @ClassName LeetCode24
 * @Author xiechao
 * @Date 2019/2/27
 * @Time 10:05
 * @Description
 * LeetCode24. Swap Nodes in Pairs
 * 给出一个链表，交换两个相邻的节点
 * Input:1 -> 2 -> 3 -> 4
 * Output:2 ->1 -> 4 -> 3
 */
public class LeetCode24 {
    //先拆成奇偶链表，再交叉拼接
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while(even != null && even.next != null){
            odd.next = even.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = null;
        ListNode curEven = evenHead;
        odd = head;
        while(curEven != null){
            ListNode nextEven = curEven.next;
            ListNode nextOdd = odd.next;
            curEven.next = odd;
            odd.next = nextEven == null ? nextOdd:nextEven;
            odd = nextOdd;
            curEven = nextEven;
        }
        return evenHead;
    }
    //LeetCode大神,递归
    public ListNode swapPairs2(ListNode head) {
        if((head == null) || (head.next == null))
            return head;
        ListNode n = head.next;
        head.next = swapPairs2(head.next.next);
        n.next = head;
        return n;
    }
    //LeetCode大神，循环
    public ListNode swapPairs3(ListNode head){
        if((head == null) || (head.next == null)) return head;
        ListNode fakeHead = new ListNode(0);
        ListNode pre = fakeHead;
        while(head != null && head.next != null){
            ListNode nextHead = head.next.next;
            ListNode next = head.next;
            next.next = head;
            pre.next = next;
            pre = head;
            head = nextHead;
        }
        pre.next = head;
        return fakeHead.next;
    }




    @Test
    public void test(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        swapPairs3(node1);
    }
}
