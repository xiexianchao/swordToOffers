package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;

/**
 * @author: xiehcao
 * @Date : 2018/9/14
 * @Time : 10:32
 * @description :翻转链表
 */
public class LeetCode206 {

    private  static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode cur = head;
        ListNode pre = null;
        ListNode reverseRoot = null;
        while(cur != null){
            ListNode next = cur.next;
            if(next == null)
                reverseRoot = cur;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return reverseRoot;
    }
    @Test
    public void test(){
        ListNode root_1 = new ListNode(1);
        ListNode root_2 = new ListNode(2);
        ListNode root_3 = new ListNode(3);
        ListNode root_4 = new ListNode(4);
        ListNode root_5 = new ListNode(5);
    //    ListNode root_6 = new ListNode(6);
        root_1.next = root_2;
        root_2.next = root_3;
        root_3.next = root_4;
        root_4.next = root_5;
        reverseList(root_1);
    }
}
