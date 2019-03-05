package com.xiechao.swordToOffers.algorithms.linklist;

import com.xiechao.swordToOffers.algorithms.ListNode;

import java.util.Stack;

/**
 * @ClassName LeetCode143
 * @Author xiechao
 * @Date 2019/3/4
 * @Time 10:28
 * @Description LeetCode143. Reorder List
 *
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Example 1:
 *
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * Example 2:
 *
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 *
 *
 */
public class LeetCode143 {

    //递归，710ms
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        helper(head);
    }
    public void helper(ListNode head){
        if(head == null || head.next == null) return;
        ListNode cur = head;
        ListNode pre = null;
        while(cur.next != null){
            pre = cur;
            cur = cur.next;
        }
        pre.next = null;
        ListNode next = head.next;
        head.next = cur;
        cur.next = next;
        helper(next);
    }


    //反转后半部分链表，然后插入之前的链表中
    public void reorderList2(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode slow  = head;
        ListNode fast = head;
        ListNode pre = null;
        while(fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast != null) {
            pre = slow;
            slow = slow.next;
        }
        pre.next = null;
        ListNode tail = reveretLink(slow);
        slow = head;
        while(tail != null){
            ListNode tailNext = tail.next;
            ListNode slowNext = slow.next;
            slow.next = tail;
            tail.next = slowNext;
            slow = slowNext;
            tail = tailNext;
        }
    }
    private ListNode reveretLink(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }



}
