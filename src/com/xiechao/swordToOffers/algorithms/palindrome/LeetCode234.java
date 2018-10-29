package com.xiechao.swordToOffers.algorithms.palindrome;

import com.xiechao.swordToOffers.algorithms.ListNode;

/**
 * @ClassName LeetCode234
 * @Author xiechao
 * @Date 2018/10/26
 * @Time 10:06
 * @Description Palindrome Linked List
 *  判断一个链表是否满足回文
 *  */
public class LeetCode234 {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        //slow找到回文折叠的第一个节点
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast != null){
            slow = slow.next;
        }
        fast = head;
        slow = reverse(slow);
        while(slow != null){
            if(slow.val != fast.val) return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    private ListNode reverse(ListNode slow) {
        if(slow == null || slow.next == null) return slow;
        ListNode cur = slow;
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
