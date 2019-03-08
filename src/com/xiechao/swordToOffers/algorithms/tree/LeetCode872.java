package com.xiechao.swordToOffers.algorithms.tree;

import com.xiechao.swordToOffers.algorithms.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName LeetCode872
 * @Author xiechao
 * @Date 2019/3/8
 * @Time 9:53
 * @Description LeetCode872 Leaf-Similar Trees
 *
 * 定义一棵二叉树从左到右的叶子节点的值为叶子值序列，
 * 如果两棵二叉树的叶子值序列相等，则两棵二叉树相似，判断两棵二叉树是相似
 */
public class LeetCode872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return true;
        if(root1 == null) return false;
        if(root2 == null) return false;
        List<Integer> list1 = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();
        helper(root1,list1);
        helper(root2,list2);
        if(list1.size() != list2.size())
            return false;
        for (int i = 0; i < list1.size(); i++) {
            if(list1.get(i) != list2.get(i))
                return false;
        }
        return true;

    }
    private void helper(TreeNode root,List<Integer> list){
        if(root == null) return;
        if(root.left == null && root.right == null)
            list.add(root.val);
        if(root.left != null)
            helper(root.left, list);
        if(root.right != null)
            helper(root.right, list);
    }


}
