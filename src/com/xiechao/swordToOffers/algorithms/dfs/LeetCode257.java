package com.xiechao.swordToOffers.algorithms.dfs;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xiechao
 * @Date : 2018/10/18
 * @Time : 15:51
 * @description :Binary Tree Paths
 * 返回二叉树头结点到所有叶子结点的路径
 */
public class LeetCode257 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if(root == null) return result;
        helper(root,result,"");
        return result;
    }

    private void helper(TreeNode root, List<String> result, String path) {
        if(root.left == null && root.right == null){
            result.add(path+root.val);
        }
        path = path + root.val + "->";
        if(root.left != null)
        helper(root.left,result,path);
        if(root.right != null)
        helper(root.right,result,path);
    }
}
