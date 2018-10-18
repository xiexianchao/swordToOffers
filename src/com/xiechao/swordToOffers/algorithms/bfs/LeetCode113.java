package com.xiechao.swordToOffers.algorithms.bfs;

import com.xiechao.swordToOffers.algorithms.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xiechao
 * @Date : 2018/10/18
 * @Time : 17:21
 * @description :Path Sum II
 * 求根节点到叶子结点，和为sum的所有路径
 */
public class LeetCode113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return  result;
        helper(result,root,sum,new ArrayList<Integer>());
        return result;
    }

    private void helper(List<List<Integer>> result, TreeNode root, int sum, ArrayList<Integer> tempList) {
        if(root.left == null && root.right == null){
            if(sum == root.val){
                tempList.add(root.val);
                result.add(new ArrayList<>(tempList));
                tempList.remove(tempList.size()-1);
            }
            return;
        }
        tempList.add(root.val);
        if(root.left != null)
        helper(result,root.left,sum - root.val,tempList);
        if(root.right != null)
        helper(result,root.right,sum - root.val,tempList);
        tempList.remove(tempList.size()-1);
    }




}
