package com.xiechao.swordToOffers.book.version2;


import com.xiechao.swordToOffers.commom.ListNode;

/**
 * 反转链表
 */
public class Problem24 {
    public ListNode ReverseList(ListNode head) {
        if(head == null) return null;
        ListNode reverseHead = null;
        ListNode pre = null;
        ListNode cur = head;

        while(cur != null){
           ListNode next = cur.next;
           if(next == null)
               reverseHead = cur;
           cur.next = pre;
           pre = cur;
           cur = next;
        }
        return reverseHead;

    }
}
