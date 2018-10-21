package com.xiechao.swordToOffers.algorithms.dfs;

import com.xiechao.swordToOffers.algorithms.TreeNode;

/**
 * @author: xiechao
 * @Date : 2018/10/18
 * @Time : 17:51
 * @description :Path Sum III
 * 返回二叉树所有和为target的路径，并不一定要从根节点开始，也并不一定要从叶子结点结束
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
