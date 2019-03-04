package com.xiechao.swordToOffers.algorithms.linklist;

import com.xiechao.swordToOffers.algorithms.ListNode;

/**
 * @ClassName LeetCode328
 * @Author xiechao
 * @Date 2019/2/27
 * @Time 9:49
 * @Description TODO
 * LeetCode328 Odd Even Linked List
 *
 * 将链表按照顺序拆分为奇偶链表，然后将偶链表拼接到奇链表末尾
 *
 */
public class LeetCode328 {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead= even;
        while(even != null && even.next != null){
            odd.next = even.next;
            even.next =even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
