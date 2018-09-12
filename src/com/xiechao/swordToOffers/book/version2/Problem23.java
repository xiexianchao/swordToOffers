package com.xiechao.swordToOffers.book.version2;

import com.xiechao.swordToOffers.commom.ListNode;
import org.junit.Test;

/**
 * 环的入口
 */
public class Problem23 {
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead == null) return null;
        ListNode p1 = pHead;
        ListNode p2 = pHead;

        while( ((p1 == pHead) && (p2 == pHead))||(p1 != p2)){
            p1 = p1.next;
            if( p1 != null)
                p1 = p1.next;
            else
                return null;
            p2 = p2.next;
        }
        p2 = pHead;
        while(p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    @Test
    public void test()
    {
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
        node6.next = node3;
        EntryNodeOfLoop(node1);
    }

}
