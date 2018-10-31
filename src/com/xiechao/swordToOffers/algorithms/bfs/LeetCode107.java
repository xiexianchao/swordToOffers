package com.xiechao.swordToOffers.algorithms.bfs;

import com.xiechao.swordToOffers.algorithms.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xiechao
 * @Date : 2018/10/18
 * @Time : 22:05
 * @description :反向保存二叉树层序遍历结果
 *
 */
public class LeetCode107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        List<Integer> list = new ArrayList<>();
        result.add(list);
        helper(root,result,0);
        return result;
    }
    private void helper(TreeNode root, List<List<Integer>> result, int level) {
        List<Integer> tempList = null;
        if(level >= result.size()) {
            tempList = new ArrayList<>();
            result.add(0,tempList);
        }else{
            tempList = result.get(result.size() -1 - level);
        }
        tempList.add(root.val);
        if(root != null && root.left != null)
            helper(root.left,result,level+1);
        if(root != null && root.right != null)
            helper(root.right,result,level+1);
    }

}
