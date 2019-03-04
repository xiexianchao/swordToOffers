package com.xiechao.swordToOffers.algorithms.linklist;

import com.xiechao.swordToOffers.algorithms.ListNode;
import org.junit.Test;

import java.awt.*;

/**
 * @ClassName LeetCode19
 * @Author xiechao
 * @Date 2019/2/28
 * @Time 11:32
 * @Description TODO
 *
 * LeetCode19 删除链表的倒数第N个节点
 */
public class LeetCode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode p1 = fakeHead;
        ListNode p2 = fakeHead;
        while(n > 0){
            p2 = p2.next;
            n--;
        }
        ListNode pre = null;
        while( p2 != null){
            pre = p1;
            p1 = p1.next;
            p2 = p2.next;
        }
        pre.next = p1.next;
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
       removeNthFromEnd(node1,2);
    }
}
