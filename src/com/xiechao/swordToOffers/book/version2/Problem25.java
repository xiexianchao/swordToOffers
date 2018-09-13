package com.xiechao.swordToOffers.book.version2;



import org.junit.Test;

/**
 * 合并两个排序的链表
 */
public class Problem25 {
    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    //菜超的方法
    public ListNode Merge(ListNode list1,ListNode list2) {
        if( list1 == null) return list2;
        if( list2 == null) return list1;

        ListNode minNode  = list1.val >= list2.val? list2:list1;
        ListNode maxNode = list1.val >= list2.val?list1:list2;

        minNode.next = Merge(minNode.next,maxNode);

        return minNode;
    }
    //萧神的方法
    public ListNode Merge2(ListNode list1,ListNode list2) {
        if( list1 == null) return list2;
        if( list2 == null) return list1;

        ListNode root  = list1.val >= list2.val? list2:list1;
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode pre = root;
        while( (p1 != null) && (p2 != null)){
            ListNode node  = p1.val >= p2.val? p2:p1;
            if(node == p1)
                p1 = p1.next;
            else
                p2 = p2.next;
            pre.next  = node;
            pre = node;
        }
        if(p1 == null)
            pre.next = p2;
        else
            pre.next = p1;


        return root;
    }

    @Test
    public void test(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node3;
        node2.next = node4;
        node3.next = node5;
        node4.next = node6;
       Merge2(node1,node2);
        
        
    }

}
