package com.xiechao.swordToOffers.algorithms.linklist;

import com.xiechao.swordToOffers.algorithms.ListNode;

/**
 * @ClassName LeetCode237
 * @Author xiechao
 * @Date 2019/2/26
 * @Time 10:17
 * @Description
 * LeetCode237
 * 删除链表中的一个节点
 */
public class LeetCode237 {
    public void deleteNode(ListNode node) {
        if(node == null ) return;
        ListNode next = node.next;
        node.val = next.val;
        node.next = node.next.next;
    }
}
