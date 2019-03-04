package com.xiechao.swordToOffers.algorithms.linklist;

import com.xiechao.swordToOffers.algorithms.ListNode;

/**
 * @ClassName LeetCode83
 * @Author xiechao
 * @Date 2019/2/26
 * @Time 10:44
 * @Description TODO
 * LeetCode83 在排序链表中删除重复的节点
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 */
public class LeetCode83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode pre = head;
        ListNode cur = head.next;
        while(cur != null){
            if(pre.val == cur.val)
                cur = cur.next;
            else{
                pre.next = cur;
                pre = cur;
                cur = cur.next;
            }

        }
        pre.next = null;
        return head;
    }
}
