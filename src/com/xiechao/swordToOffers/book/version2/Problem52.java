package com.xiechao.swordToOffers.book.version2;

import com.xiechao.swordToOffers.algorithms.ListNode;
import com.xiechao.swordToOffers.leetcode.LeetCode160;
import org.junit.Test;

/**
 * @ClassName Problem52
 * @Author xiechao
 * @Date 2018/11/1
 * @Time 11:05
 * @Description 两个链表的第一个公共节点
 */
public class Problem52 {
    //计算链表长度的解法
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null) return null;
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        int length1 = 0,length2 = 0;
        while(p1 != null) {
            length1++;
            p1 = p1.next;
        }
        while(p2 != null){
            length2++;
            p2 = p2.next;
        }
        p1 = pHead1;
        p2 = pHead2;
        int diff = length1 - length2;
        if(diff > 0){
            while(diff >0 ) {
                p1 = p1.next;
                diff -- ;
            }
        }else{
            while(diff < 0){
                p2 = p2.next;
                diff++;
            }
        }
        while(p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    //求环的起点的解法  会修改链表结构
    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2){
        if(pHead1 == null || pHead2 == null) return null;
        ListNode p1 = pHead1;
        ListNode pre = null;
        while(p1 != null){
            pre = p1;
            p1 = p1.next;
        }
        pre.next = pHead2;
        p1 = pHead1;   //fast
        pre = pHead1;   //slow
        do {
            if(p1 == null || p1.next == null)   //没有公共节点，形不成环
                return null;
            p1 = p1.next.next;  //2 step
            pre = pre.next;    // 1 step
        }while( p1 != pre );
        pre = pHead1; //slow to head

        while( p1 != pre){
            pre = pre.next;
            p1 = p1.next;
        }
        return p1;
    }

    //LeetCode大神  1ms解法   亮瞎眼
    public ListNode FindFirstCommonNode3(ListNode pHead1, ListNode pHead2){
        if(pHead1 == null || pHead2 == null) return null;
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while(p1 != p2){
            p1 = p1 == null ? pHead2:p1.next;
            p2 = p2 == null ? pHead1:p2.next;
        }
        return p1;
    }

    @Test
    public void test(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node3.next = node4;
        node4.next = node5;
        System.out.println(FindFirstCommonNode3(node1,node3));
    }
}
