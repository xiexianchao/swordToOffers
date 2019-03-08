package com.xiechao.swordToOffers.algorithms.tree;

import com.xiechao.swordToOffers.algorithms.ListNode;
import com.xiechao.swordToOffers.algorithms.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName LeetCode669
 * @Author xiechao
 * @Date 2019/3/8
 * @Time 10:09
 * @Description LeetCode669. Trim a Binary Search Tree
 * 给定边界[L,R]，对给定的BST进行裁剪，构造成新的BST
 *
 *
 */
public class LeetCode669 {
    TreeNode fakeRoot = new TreeNode(-1);
    TreeNode parent = fakeRoot;
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root == null) return null;

        helper(root,L,R);
       return fakeRoot.right;

    }
    private void helper(TreeNode root,int L,int R){
        if(root == null) return;
        if(root.left != null)
            helper(root.left,L,R);
        TreeNode right = root.right;
        if(root.val >= L && root.val <= R){
            root.left = null;
            root.right = null;
            parent.right = root;
            parent = root;
        }
        if(right != null)
            helper(right,L,R);
    }

    //LeetCode大神
    public TreeNode trimBST2(TreeNode root, int L, int R) {
        if(root == null) return null;
        if(root.val > R)
            return trimBST2(root.left,L,R);
        if(root.val < L)
            return trimBST2(root.right,L,R);
        root.left = trimBST2(root.left,L,R);
        root.right = trimBST2(root.right,L,R);
        return root;
    }
    @Test
    public void test(){
        TreeNode list1 = new TreeNode(3);
        TreeNode list2 = new TreeNode(0);
        TreeNode list3 = new TreeNode(4);
        TreeNode list4 = new TreeNode(2);
        TreeNode list5 = new TreeNode(1);
        list1.left = list2;
        list1.right = list3;
        list2.right = list4;
        list4.left = list5;
        trimBST(list1,1,3);
    }

}
