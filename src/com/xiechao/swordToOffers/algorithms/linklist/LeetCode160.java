package com.xiechao.swordToOffers.algorithms.linklist;

import com.xiechao.swordToOffers.algorithms.ListNode;

/**
 * @ClassName LeetCode160
 * @Author xiechao
 * @Date 2019/2/26
 * @Time 11:44
 * @Description TODO
 *
 * LeetCode160  Intersection of Two Linked Lists
 * 求两个链表的第一个公关节点
 *
 */
public class LeetCode160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode p1 = headA;
        ListNode p2 = headB;
        while(p1 != p2){
            p1 = p1 == null ? headB:p1.next;
            p2 = p2 == null ? headA:p2.next;
        }
        return p1;
    }
}
