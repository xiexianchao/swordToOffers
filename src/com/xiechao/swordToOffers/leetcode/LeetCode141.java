package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;

/**
 * @ClassName LeetCode141
 * @Author xiechao
 * @Date 2018/9/16
 * @Time 15:40
 * @Description Linked List Cycle
 */
public class LeetCode141 {
    private static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){ val = x;next = null;}
    }
    public boolean hasCycle(ListNode head) {
        if( null == head ) return false;
        ListNode slow = head;
        if(head.next == null) return false;
        ListNode fast = head.next.next;
        while( fast != null && fast != slow){
            slow = slow.next;
            fast = fast.next;
            if( fast != null)
                fast = fast.next;
        }
        return fast != null;
    }
    @Test
    public void test(){
        ListNode node = new ListNode(1);
        node.next = node;
        hasCycle(node);
    }
}
