package com.xiechao.swordToOffers.algorithms.linklist;

import com.xiechao.swordToOffers.algorithms.ListNode;

/**
 * @ClassName LeetCode234
 * @Author xiechao
 * @Date 2019/2/26
 * @Time 11:03
 * @Description TODO
 * LeetCode234. Palindrome Linked List
 * 判断一个链表是否是对称链表
 */
public class LeetCode234 {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast != null)
            slow = slow.next;
        ListNode tail = reverse(slow);
        fast = head;
        while(tail != null){
            if(tail.val != fast.val) return false;
            tail = tail.next;
            fast = fast.next;
        }
        return true;
    }

    private ListNode reverse(ListNode slow) {
        if(slow == null) return null;
        ListNode pre = null;
        ListNode cur = slow;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}
