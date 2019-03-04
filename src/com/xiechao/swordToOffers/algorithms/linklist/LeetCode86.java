package com.xiechao.swordToOffers.algorithms.linklist;

import com.xiechao.swordToOffers.algorithms.ListNode;
import org.junit.Test;
import sun.rmi.log.LogInputStream;

import javax.swing.*;

/**
 * @ClassName LeetCode86
 * @Author xiechao
 * @Date 2019/2/28
 * @Time 10:32
 * @Description TODO
 */
public class LeetCode86 {
    //我的方法，双指针，调整链表，
    public ListNode partition(ListNode head, int x) {
        if(head == null) return null;
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode p1 = head,p2=head;
        ListNode p1Pre = null,p2Pre = fakeHead;
        while(p2 != null && p2.val < x){
            p2Pre = p2;
            p2= p2.next;
        }
        if(p2 == null) return fakeHead.next;
        p1 = p2.next;
        p1Pre = p2;
        while(p1 != null){
            while(p1 != null && p1.val >= x){
                p1Pre= p1;
                p1 = p1.next;
            }
            if(p1 == null) break;
            ListNode p1Next = p1.next;
            p1Pre.next = p1Next;
            p2Pre.next = p1;
            p1.next = p2;
            p2Pre = p1;
            p1 = p1Next;
        }
        return fakeHead.next;
    }
    //LeetCode大神  超级简单, 回头看我的方法真是无比复杂啊
    public ListNode partition2(ListNode head, int x) {
        if(head == null) return null;
        ListNode dummy1 = new ListNode(0),dummy2 = new ListNode(2);
        ListNode cur1 = dummy1, cur2 = dummy2;
        while(head != null){
            if(head.val < x){
                cur1.next = head;
                cur1 = cur1.next;
            }else{
                cur2.next = head;
                cur2 = cur2.next;
            }
            head = head.next;
        }
        cur2.next = null;   //防止成环
        cur1.next = dummy2.next;
        return dummy1.next;
    }


    @Test
    public void test(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
     //   partition(node1,3);

        ListNode node7 = new ListNode(2);
        ListNode node8 = new ListNode(1);
        node7.next = node8;
        partition(node7,2);

    }


}
