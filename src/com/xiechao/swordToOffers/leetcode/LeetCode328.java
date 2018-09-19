package com.xiechao.swordToOffers.leetcode;


import org.junit.Test;

/**
 * @author: xiehcao
 * @Date : 2018/9/19
 * @Time : 20:59
 * @description :
 */
public class LeetCode328 {
    class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    //6ms
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode oddHead = head;
        ListNode evenHead = head.next;

        ListNode[] nodeArray = new ListNode[2];
        nodeArray[0] = oddHead;
        nodeArray[1] = evenHead;
        int count = 0;
        ListNode cur = head.next.next;
        while( cur != null){
          ListNode next = cur.next;
          nodeArray[count].next = cur;
          nodeArray[count] = nodeArray[count].next;
          cur = next;
          count = 1 - count;
        }
        nodeArray[1].next = null;
        nodeArray[0].next = evenHead;
        return head;
    }
    //LeetCode大神 3ms
    public ListNode oddEvenList2(ListNode head) {
        if(head != null) {
            ListNode odd = head,even=head.next,evenHead = even;
            while( even != null && even.next != null) {
                odd.next = odd.next.next;
                even.next = even.next.next;
                odd = odd.next;
                even = even.next;
            }
            odd.next = evenHead;
        }
        return head;
    }

    @Test
    public void test()
    {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
       // ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        //node5.next = node6;
        oddEvenList2(node1);

    }

}
