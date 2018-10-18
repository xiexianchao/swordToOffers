package com.xiechao.swordToOffers.algorithms.bfs;

import com.xiechao.swordToOffers.algorithms.TreeNode;

/**
 * @author: xiechao
 * @Date : 2018/10/18
 * @Time : 17:51
 * @description :Path Sum III
 */
public class LeetCode437 {
    int result = 0;
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        helper(root,sum);
        pathSum(root.left,sum);
        pathSum(root.right,sum);
        return result;
    }

    private void helper(TreeNode root, int sum) {
        if(root == null)
            return;
        if(sum == root.val){
            result++;
        }


        helper(root.left,sum - root.val);

        helper(root.right,sum - root.val);
    }

}
