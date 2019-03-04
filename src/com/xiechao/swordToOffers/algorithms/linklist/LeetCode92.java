package com.xiechao.swordToOffers.algorithms.linklist;

import com.xiechao.swordToOffers.algorithms.ListNode;

import java.awt.*;

/**
 * @ClassName LeetCode92
 * @Author xiechao
 * @Date 2019/2/28
 * @Time 11:53
 * @Description
 * LeetCode92 反转链表中的第m到第n节点
 * 1->2->3->4->5 m=2,n=4
 * 1->4->3->2->5
 */
public class LeetCode92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) return null;
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode cur = fakeHead;
        ListNode preTail = null;
        int curIndex = 0;
        while(curIndex < m){
            preTail = cur;
            cur = cur.next;
            curIndex++;
        }
        ListNode tail = cur;
        ListNode pre = null;
        while(curIndex <= n){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            curIndex++;
        }
        assert preTail != null;
        preTail.next = pre;
        tail.next = cur;
        return fakeHead.next;
    }
}
