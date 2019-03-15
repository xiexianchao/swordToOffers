package com.xiechao.swordToOffers.algorithms.tree;

import com.xiechao.swordToOffers.algorithms.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName LeetCode257
 * @Author xiechao
 * @Date 2019/3/15
 * @Time 8:52
 * @Description LeetCode257. Binary Tree Paths
 */
public class LeetCode257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new LinkedList<>();
        helper(root, result, "");
        return result;
    }
    private void helper(TreeNode root,List<String> result,String path){
        if(root == null) return;
        if(root.left == null && root.right == null){
            //stringBuilder.append(root.val);   //想一想为什么不能用stringBuilder
            result.add(path + root.val);
        }
       // stringBuilder.append(root.val).append("->");
        helper(root.left, result,path + root.val + "->");
        helper(root.right,result,path + root.val + "->");
    }

}
