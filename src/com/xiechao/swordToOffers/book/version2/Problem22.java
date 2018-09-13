package com.xiechao.swordToOffers.book.version2;

import com.xiechao.swordToOffers.commom.ListNode;

/**
 * 链表中倒数第k个节点
 * 要求:只对链表遍历一次
 * 注意：三种情况
 * 1. k大于链表长度
 * 2. k<=0
 * 3. 1< k <= n
 */
public class Problem22 {
    ListNode findKthToTail(ListNode head,int k){
        if( null == head || k <=0 )
            return null;
        ListNode node = null;
        ListNode p1 = head;
        ListNode p2 = head;
        while(k > 1 && p1 != null){
            p1 = p1.next;
            k--;
        }
        if( p1== null )
            return null;
        while(p1.next!=null){
            p2 = p2.next;
            p1 = p1.next;
        }
        return p2;
    }


}
