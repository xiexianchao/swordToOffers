package com.xiechao.swordToOffers.algorithms.linklist;

import com.xiechao.swordToOffers.algorithms.ListNode;

/**
 * @ClassName LeetCode142
 * @Author xiechao
 * @Date 2019/3/4
 * @Time 9:52
 * @Description LeetCode142  Linked List Cycle II
 * 返回链表的环的入口地址，如果没有则返回null
 *
 */
public class LeetCode142 {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
       do{
            slow = slow.next;
            fast = fast.next.next;
       } while(fast != null && fast.next != null && slow != fast);
       if(fast == null || fast.next == null) return null;
       slow = head;
       while(slow != fast){
           slow = slow.next;
           fast = fast.next;
       }
       return slow;
    }
}
