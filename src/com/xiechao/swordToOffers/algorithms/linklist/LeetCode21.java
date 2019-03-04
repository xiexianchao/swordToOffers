package com.xiechao.swordToOffers.algorithms.linklist;

import com.xiechao.swordToOffers.algorithms.ListNode;

/**
 * @ClassName LeetCode21
 * @Author xiechao
 * @Date 2019/2/26
 * @Time 10:35
 * @Description
 * LeetCode21 Merge Two Sorted Lists
 * 合并两个排序后的链表
 * 分析：可以用递归；也可以按照合并两个排序数组的方法合并两个排序链表
 *
 */
public class LeetCode21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode fakeHead = new ListNode(0);
        ListNode cur = fakeHead;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        while(cur1 != null && cur2 != null){
            if(cur1.val <= cur2.val){
                cur.next = cur1;
                cur1 = cur1.next;
                cur = cur.next;
            }else{
                cur.next = cur2;
                cur2 = cur2.next;
                cur = cur.next;
            }
        }
        while(cur1 != null){
            cur.next = cur1;
            cur1 = cur1.next;
            cur = cur.next;
        }
        while(cur2 != null){
            cur.next = cur2;
            cur2 = cur2.next;
            cur = cur.next;
        }
        return fakeHead.next;
    }


}
