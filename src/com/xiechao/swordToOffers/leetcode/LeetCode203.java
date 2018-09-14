package com.xiechao.swordToOffers.leetcode;

import com.xiechao.swordToOffers.commom.ListNode;
import org.junit.Test;

/**
 * @author: xiehcao
 * @Date : 2018/9/14
 * @Time : 11:03
 * @description :删除链表中所有有具有val的结点
 */
public class LeetCode203 {
    private static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

  //5ms
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        ListNode cur = head;
        ListNode pre = null;

        ListNode pHead = null;
        while( cur != null){
            if((pre == null) && cur.val == val){
                pre = null;
                cur = cur.next;
            }
            else if(cur.val == val)
            {
                 pre.next = cur.next;
                 cur = cur.next;
            }else{
                if(pre == null){
                    pHead = cur;
                }
                pre = cur;
                cur = cur.next;
            }
        }
        return pHead;
    }


    //4ms LeetCode 大神。给原来链表伪造一个头结点
    public  ListNode removeElements2(ListNode head,int val){
        if( head == null) return null;
        ListNode fakeHead = new ListNode(10);
        fakeHead.next = head;
        ListNode cur = head;
        ListNode pre = fakeHead;

        while(cur != null){
            if(cur.val == val){
                pre.next = cur.next;
            }else{
                pre = cur;
            }
            cur = cur.next;
        }
        return fakeHead.next;
    }
    @Test
    public void test(){
        ListNode root_1 = new ListNode(1);
        ListNode root_2 = new ListNode(2);
        ListNode root_3 = new ListNode(3);
        ListNode root_4 = new ListNode(4);
        ListNode root_5 = new ListNode(5);
        ListNode root_6_1 = new ListNode(6);
        ListNode root_6_2 = new ListNode(6);
        ListNode root_6_3 = new ListNode(6);
        root_1.next = root_2;
        root_2.next = root_6_1;
        root_6_1.next = root_3;
        root_3.next = root_4;
        root_4.next = root_5;
        root_5.next = root_6_3;
        removeElements2(root_1,1);
    }

}
