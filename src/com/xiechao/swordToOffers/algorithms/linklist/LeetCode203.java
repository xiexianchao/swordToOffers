package com.xiechao.swordToOffers.algorithms.linklist;

import com.xiechao.swordToOffers.algorithms.ListNode;

/**
 * @ClassName LeetCode203
 * @Author xiechao
 * @Date 2019/2/26
 * @Time 11:19
 * @Description TODO
 *
 * LeetCode203 Remove Linked List Elements
 * Remove all elements from a linked list of integers that have value val.
 *
 *
 */
public class LeetCode203 {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;

        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode cur = head;
        ListNode pre = fakeHead;
        while(cur.next != null){
            if(cur.val == val){
                cur = cur.next;
            }else{
                pre.next = cur;
                pre = cur;
                cur = cur.next;
            }
        }
        if(cur.val == val)
            pre.next = null;
        else
            pre.next = cur;
        return fakeHead.next;
    }
}
