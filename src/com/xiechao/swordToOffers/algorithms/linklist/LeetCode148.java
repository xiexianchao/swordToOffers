package com.xiechao.swordToOffers.algorithms.linklist;

import com.xiechao.swordToOffers.algorithms.ListNode;
import org.junit.Test;
import sun.rmi.log.LogInputStream;

import javax.management.ListenerNotFoundException;
import javax.swing.text.StyledEditorKit;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName LeetCode148
 * @Author xiechao
 * @Date 2019/3/3
 * @Time 11:39
 * @Description LeetCode148 Sort List
 * 对链表进行排序，将一个无序的输入链表排序成有序的链表,要求时间复杂度O(nlogn),空间复杂度O(1)
 */
public class LeetCode148 {
    //额外空间，借助数组排序，再合并成链表,O(n*logn),O(n)
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode cur = head;
        int count = 0;
        while(cur != null){
            cur = cur.next;
            count++;
        }
        int[] arr = new int[count];
        cur = head;
        count = 0;
        while(cur != null){
            arr[count] = cur.val;
            count++;
            cur = cur.next;
        }
        Arrays.sort(arr);
        ListNode fakeHead = new ListNode(0);
        ListNode pre = fakeHead;
        for (int i = 0; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i]);
            pre.next = node;
            pre = node;
        }
        return fakeHead.next;
    }
    //插入排序 Time Limit Exceeded,O(n^2)
    public ListNode sortList2(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode fakeHead = new ListNode(Integer.MIN_VALUE);
        ListNode pre = fakeHead;
        fakeHead.next = head;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;

            pre = fakeHead;
            ListNode temp = fakeHead.next;
            while(temp != null && temp.val <= cur.val){
                pre = temp;
                temp = temp.next;
            }
            if(temp == cur) {
                cur.next = null;
                pre.next = cur;
            }
            else{
                cur.next = null;
                pre.next = cur;
                cur.next = temp;
            }
            cur = next;
        }
        return fakeHead.next;
    }
    //LeetCode大神，归并排序，但是递归本身就是堆栈，需要消耗O(log n)的栈空间
    public ListNode sortList3(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode slow = head, fast = head;
        ListNode pre = null;
        while(fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;

        ListNode l1 = sortList3(head);
        ListNode l2 = sortList3(slow);
        return merge(l1,l2);

    }
    private ListNode merge(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode fakeHead = new ListNode(0);
        ListNode pre = fakeHead;
        while(l1 != null && l2 != null){
            if(l1.val >= l2.val){
                pre.next = l2;
                pre = pre.next;
                l2 = l2.next;
            }else{
                pre.next = l1;
                pre = pre.next;
                l1 = l1.next;
            }
        }
        while(l1 != null){
            pre.next = l1;
            pre = pre.next;
            l1 = l1.next;
        }
        while(l2 != null){
            pre.next = l2;
            pre = pre.next;
            l2 = l2.next;
        }
        return fakeHead.next;
    }

    //LeetCode大神，循环，
    public ListNode sortList4(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int n = 0;
        while(head != null){
            head = head.next;
            n++;
        }
        for (int step = 1; step < n; step <<= 1) {
            ListNode prev = dummy;
            ListNode cur = dummy.next;
            while(cur != null){
                ListNode left = cur;
                ListNode right = split(left , step);
                cur = split(right, step);
                prev = merge(left,right,prev);
            }

        }
        return dummy.next;
    }
    private ListNode split(ListNode head, int step){
        if(head == null) return null;
        for (int i = 1; head.next != null && i < step; i++) {
            head = head.next;
        }
        ListNode right = head.next;
        head.next = null;
        return right;
    }
    private ListNode merge(ListNode left, ListNode right, ListNode prev){
        ListNode cur = prev;
        while(left != null && right != null){
            if(left.val < right.val){
                cur.next = left;
                left = left.next;
            }else{
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        if(left != null) cur.next = left;
        else if(right != null) cur.next = right;
        while (cur.next != null) cur = cur.next;
        return cur;
    }




    @Test
    public void test(){
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        sortList4(node1);
    }

}
