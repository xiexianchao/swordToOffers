package com.xiechao.swordToOffers.leetcode;

/**
 * @ClassName LeetCode21
 * @Author xiechao
 * @Date 2018/9/14
 * @Time 17:06
 * @Description  Merge Two Sorted Lists
 * 合并两个排序好的链表
 */
public class LeetCode21 {
    private static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
    //14ms 递归
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode minNode = l1.val >= l2.val?l2:l1;
        ListNode maxNode = l1.val >= l2.val?l1:l2;
        ListNode head = new ListNode(minNode.val);
        head.next = mergeTwoLists(minNode.next,maxNode);
        return head;
    }
    //LeetCode 循环 9ms
    public ListNode mergeTwoLists2(ListNode l1,ListNode l2){
        ListNode head = new ListNode(0);
        ListNode cur = head;

        while(l1 != null && l2 != null){
          if(l1.val <= l2.val){
              cur.next = l1;
              l1 = l1.next;
              cur = cur.next;
          }else {
              cur.next = l2;
              l2 = l2.next;
              cur = cur.next;
          }
        }
        while(l1 !=null){
            cur.next = l1;
            l1 = l1.next;
            cur = cur.next;
        }
        while(l2 != null){
            cur.next = l2;
            l2 = l2.next;
            cur = cur.next;
        }
        return head.next;
    }

}
