package com.xiechao.swordToOffers.algorithms.tree;

import com.sun.org.apache.regexp.internal.RE;
import com.xiechao.swordToOffers.algorithms.ListNode;
import com.xiechao.swordToOffers.algorithms.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName LeetCode107
 * @Author xiechao
 * @Date 2019/3/14
 * @Time 10:03
 * @Description LeetCode107. Binary Tree Level Order Traversal II
 * 从下到上层序遍历
 */
public class LeetCode107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        helper(result,root,0);
        return result;
    }

    private void helper(List<List<Integer>> result, TreeNode root, int level){
        if(root == null) return;
        if(level >= result.size()){
            result.add(0,new LinkedList<>());
        }
        List<Integer> list = result.get(result.size() - 1 - level);
        list.add(root.val);
        helper(result, root.left, level+1);
        helper(result, root.right, level + 1);
    }
}
