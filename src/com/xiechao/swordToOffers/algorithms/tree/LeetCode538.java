package com.xiechao.swordToOffers.algorithms.tree;

import com.xiechao.swordToOffers.algorithms.TreeNode;
import org.junit.Test;

/**
 * @ClassName LeetCode538
 * @Author xiechao
 * @Date 2019/3/12
 * @Time 9:17
 * @Description LeetCode538  Convert BST to Greater Tree
 * 将BST中每个节点的值都加上树中所有大于此节点值的总和
 * Example:
 *
 * Input: The root of a Binary Search Tree like this:
 *               5
 *             /   \
 *            2     13
 *
 * Output: The root of a Greater Tree like this:
 *              18
 *             /   \
 *           20     13
 */
public class LeetCode538 {
    //即自己定义一种遍历方法，先右子树，父节点，最后左子树，每次把大于当前节点的值向前传递。
    public TreeNode convertBST(TreeNode root) {
        if(root == null) return null;
        helper(root,new int[]{0});
        return root;
    }
    private void helper(TreeNode root, int[] curSum){
        if(root == null) return;
        helper(root.right,curSum);
        int temp = root.val;
        root.val += curSum[0];
        curSum[0] += temp;
        helper(root.left,curSum);
    }
    @Test
    public void test(){
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(13);
        node1.left = node2;
        node1.right = node3;
        convertBST(node1);
    }


}
