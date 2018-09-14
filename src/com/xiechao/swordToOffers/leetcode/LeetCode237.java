package com.xiechao.swordToOffers.leetcode;

import com.xiechao.swordToOffers.commom.ListNode;

/**
 * @author: xiehcao
 * @Date : 2018/9/14
 * @Time : 10:49
 * @description :
 */
public class LeetCode237 {
    private static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){ val = x;}
    }

    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        node.val = next.val;
        node.next = node.next.next;
    }
}
