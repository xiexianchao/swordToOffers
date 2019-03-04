package com.xiechao.swordToOffers.algorithms.linklist;

import com.xiechao.swordToOffers.algorithms.ListNode;
import com.xiechao.swordToOffers.algorithms.TreeNode;

/**
 * @ClassName LeetCode109
 * @Author xiechao
 * @Date 2019/2/27
 * @Time 11:43
 * @Description
 * LeetCode109 Convert Sorted List to Binary Search Tree
 * 把有序链表转换成BST
 */
public class LeetCode109 {

    //我的方法，投机取巧，把链表转换成BST 变成数组转换成BST
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);
        ListNode cur = head;
        int length = 0;
        while(cur != null){
            length ++ ;
            cur = cur.next;
        }

        int[] nums = new int[length];
        cur = head;
        length = 0;
        while (cur != null){
            nums[length] = cur.val;
            cur = cur.next;
            length++;
        }
        return helper(nums,0,nums.length - 1);

    }
    private TreeNode helper(int[] nums, int start, int end) {
        if(start > end) return null;
        int mid = (end + start + 1) >>> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums,start,mid-1);
        root.right = helper(nums, mid+1,end);
        return root;
    }

    //LeetCode大神
    public TreeNode sortedListToBST2(ListNode head){
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);
        return helper2(head,null);
    }

    private TreeNode helper2(ListNode head, ListNode tail) {
        if(head == tail) return null;
        if(head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != tail && fast.next != tail){
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = helper2(head,slow);
        root.right = helper2(slow.next,tail);
        return root;
    }

}
