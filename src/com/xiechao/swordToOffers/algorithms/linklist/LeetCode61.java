package com.xiechao.swordToOffers.algorithms.linklist;

import com.xiechao.swordToOffers.algorithms.ListNode;

/**
 * @ClassName LeetCode61
 * @Author xiechao
 * @Date 2019/3/5
 * @Time 9:45
 * @Description LeetCode61 Rotate List
 *Given a linked list, rotate the list to the right by k places, where k is non-negative.
 *
 * Example 1:
 *
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 * Example 2:
 *
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
 *
 */
public class LeetCode61 {

    //先统计链表长度，题目的意思等价于将倒数第k%length位出的节点开始移到链表的前面
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;
        int count = 0;
        ListNode slow = head;
        while(slow != null){
            count++;
            slow = slow.next;
        }
        k %= count;
        if(k == 0) return head;
        ListNode fast = head;
        ListNode pre = null;
        slow = head;
        while( k > 0){
            fast = fast.next;
            k--;
        }
        while(fast != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next;
        }
        pre.next = null;
        ListNode newHead = slow;
        while(slow != null){
            pre = slow;
            slow = slow.next;
        }
        pre.next = head;
        return newHead;
    }
}
