package com.xiechao.swordToOffers.algorithms.linklist;

import com.xiechao.swordToOffers.algorithms.ListNode;

/**
 * @ClassName LeetCode876
 * @Author xiechao
 * @Date 2019/2/26
 * @Time 10:00
 * @Description
 * LeetCode876 Middle of the Linked List
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 *
 * If there are two middle nodes, return the second middle node.
 * 求链表的中间节点，使用快慢指针，编写简单易懂
 *
 */
public class LeetCode876 {
    public ListNode middleNode(ListNode head) {
        if(head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
       return slow;
    }
}
