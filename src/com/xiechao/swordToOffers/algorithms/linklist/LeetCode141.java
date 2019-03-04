package com.xiechao.swordToOffers.algorithms.linklist;

import com.xiechao.swordToOffers.algorithms.ListNode;

/**
 * @ClassName LeetCode141
 * @Author xiechao
 * @Date 2019/2/26
 * @Time 10:58
 * @Description TODO
 * LeetCode141 Linked List Cycle
 */
public class LeetCode141 {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next.next;
        while( fast != null && fast != slow){
            slow = slow.next;
            fast = fast.next;
            if(fast != null)
                fast = fast.next;
        }
        return fast != null;
    }
}
