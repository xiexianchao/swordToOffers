package com.xiechao.swordToOffers.algorithms.tree;

import com.xiechao.swordToOffers.algorithms.TreeNode;
import com.xiechao.swordToOffers.leetcode.Leetcode897;
import org.junit.Test;

import java.time.chrono.HijrahEra;

/**
 * @ClassName LeetCode437
 * @Author xiechao
 * @Date 2019/3/18
 * @Time 10:09
 * @Description 从一棵树总找到和为sum的路径，不要求起始为root，截至为叶子节点
 *
 *
 */
public class LeetCode437 {
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        int[] result = new int[]{0};
        helper(root,sum,result);
        int left = pathSum(root.left,sum);
        int right = pathSum(root.right,sum);
        return result[0]+left+right;
    }
    private void helper(TreeNode root,int sum, int[] result) {
        if(root == null) return;
        if(root.val == sum)
            result[0]++;
        if(root.left != null)
            helper(root.left,sum - root.val,result);
        if(root.right != null)
            helper(root.right,sum - root.val,result);
    }
    @Test
    public void test(){
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(-3);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(11);
        TreeNode node7 = new TreeNode(3);
        TreeNode node8 = new TreeNode(-2);
        TreeNode node9 = new TreeNode(1);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right= node5;
        node3.right = node6;
        node4.left = node7;
        node4.right = node8;
        node5.right = node9;
        System.out.println(pathSum(node1,8));

    }
    
}
