package com.xiechao.swordToOffers.algorithms.linklist;

import com.xiechao.swordToOffers.algorithms.ListNode;

import java.util.List;

/**
 * @ClassName LeetCode2
 * @Author xiechao
 * @Date 2019/3/4
 * @Time 10:06
 * @Description LeetCode2 Add Two Numbers
 * 两个链表相加
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class LeetCode2 {
    //递归 20ms
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        int pre = 0;
        ListNode head = helper(l1,l2,0);
        if(head == null)
            return new ListNode(0);
        return head;
    }
    private ListNode helper(ListNode l1, ListNode l2,int pre){
       int value = (l1 == null ? 0 : l1.val) + (l2 == null ? 0: l2.val) + pre;
       if(value == 0 && l1 == null && l2 == null)
           return null;
       else{
           ListNode node = new ListNode(value % 10);
           node.next = helper(l1 == null ? null: l1.next, l2 == null ? null : l2.next,value / 10);
           return node;
       }
    }
}
