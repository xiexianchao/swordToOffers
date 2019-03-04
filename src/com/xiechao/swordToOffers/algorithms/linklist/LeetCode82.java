package com.xiechao.swordToOffers.algorithms.linklist;

import com.xiechao.swordToOffers.algorithms.ListNode;

/**
 * @ClassName LeetCode82
 * @Author xiechao
 * @Date 2019/3/4
 * @Time 9:24
 * @Description
 * LeetCode82. Remove Duplicates from Sorted List II
 */
public class LeetCode82 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode prePre = fakeHead;
        ListNode pre = head;
        ListNode cur = head.next;
        while(cur != null){
           if(pre.val == cur.val){
               while(cur != null && cur.val == pre.val){
                   cur = cur.next;
               }
               prePre.next = cur;
               pre = cur;
               if(cur == null) break;
               cur = cur.next;
           }else{
               prePre = pre;
               pre.next = cur;
               pre = cur;
               cur = cur.next;
           }
        }
        return fakeHead.next;
    }
}
