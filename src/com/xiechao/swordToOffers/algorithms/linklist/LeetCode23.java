package com.xiechao.swordToOffers.algorithms.linklist;

import com.xiechao.swordToOffers.algorithms.ListNode;

/**
 * @ClassName LeetCode23
 * @Author xiechao
 * @Date 2019/3/6
 * @Time 9:56
 * @Description  LeetCode23 Merge k Sorted Lists
 * 给一个排序后的链表数组，要求合并成一个链表
 *
 */
public class LeetCode23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null) return null;
        return helper(lists,0,lists.length-1);


    }
    private ListNode helper(ListNode[] lists, int start,int end){
        if(start > end) return null;
        else if(start == end) return lists[start];
        else{
            int mid = (start + end)/2;
            ListNode l1 = helper(lists, start,mid);
            ListNode l2 = helper(lists,mid+1,end);
            return merge(l1,l2);
        }

    }

    private ListNode merge(ListNode list1, ListNode list2){
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        ListNode fakeHead = new ListNode(0);
        ListNode pre = fakeHead;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                pre.next = list1;
                list1 = list1.next;
            }else{
                pre.next = list2;
                list2 = list2.next;
            }
            pre = pre.next;
        }
        if(list1 != null) pre.next = list1;
        if(list2 != null) pre.next = list2;
        return fakeHead.next;
    }
}
