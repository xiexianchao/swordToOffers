package com.xiechao.swordToOffers.leetcode;


import org.junit.Test;

import java.util.Stack;

/**
 * @ClassName LeetCode234
 * @Author xiechao
 * @Date 2018/9/16
 * @Time 17:39
 * @Description 234. Palindrome Linked List
 * 求一个链表是否是回文
 */
public class LeetCode234 {
    private static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }
    // O(n) O(n)
    public boolean isPalindrome(ListNode head) {
      if( head == null) return true;
      ListNode cur = head;
      Stack<ListNode> stack = new Stack<>();
      while(cur != null){
          stack.push(cur);
          cur = cur.next;
      }
      cur = head;
      while( cur != null){
          if(cur.val != stack.pop().val) return false;
          cur = cur.next;
      }
      return true;
    }

    //LeetCode大神 O(n) O(1)
    public boolean isPalindrome2(ListNode head) {
        if(head == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if( fast != null){
            slow = slow.next;
        }
        fast = head;
        slow = reverseRight(slow);
        while(slow != null){
            if(slow.val != fast.val) return false;
            slow = slow.next;
            fast = fast.next;
        }

        return true;
    }

    private ListNode reverseRight(ListNode slow) {
        if( slow == null) return null;
        ListNode cur = slow;
        ListNode pre = null;
        while( cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    private boolean isPalindromeCore(ListNode head1,ListNode head2){
        ListNode node1 = head1;
        ListNode node2 = head2;
        while( node1 != null && node2 != null){
            if( node1.val != node2.val ) return false;
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1 == null && node2 == null;
    }

    @Test
    public void test(){
        ListNode node_1 = new ListNode(1);
        ListNode node_2 = new ListNode(4);
        ListNode node_3 = new ListNode(-1);
        ListNode node_1_r = new ListNode(-1);
        ListNode node_2_r = new ListNode(4);
        ListNode node_3_r = new ListNode(1);
        node_1.next = node_2;
        node_2 .next = node_3;
        node_3.next = node_1_r;
        node_1_r.next = node_2_r;
        node_2_r.next = node_3_r;

        System.out.println(isPalindrome2(node_1));
    }
}
