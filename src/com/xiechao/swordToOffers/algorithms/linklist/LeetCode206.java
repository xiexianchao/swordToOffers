package com.xiechao.swordToOffers.algorithms.linklist;

import com.xiechao.swordToOffers.algorithms.ListNode;

/**
 * @ClassName LeetCode206
 * @Author xiechao
 * @Date 2019/2/26
 * @Time 10:11
 * @Description
 * LeetCode206 Reverse Linked List
 * 反转链表
 */
public class LeetCode206 {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode cur = head;
        ListNode pre = null;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
