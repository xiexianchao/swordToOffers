package com.xiechao.swordToOffers.algorithms.tree;

import com.xiechao.swordToOffers.algorithms.TreeNode;
import org.junit.Test;

/**
 * @ClassName LeetCode687
 * @Author xiechao
 * @Date 2019/3/19
 * @Time 10:31
 * @Description LeetCode 687. Longest Univalue Path
 *
 * 求树中值相同的相邻节点间的边数
 *
 */
public class LeetCode687 {
    //LeetCode大神,正确解法
    public int longestUnivaluePath1(TreeNode root) {
        int[] res = new int[]{0};
        dfs(root,res);
        return res[0];
    }
    private int dfs(TreeNode root,int[] res){
        if(root == null) return 0;
        int left = root.left == null ? 0 : dfs(root.left,res);
        int right = root.right == null ? 0 : dfs(root.right,res);
        int resl = root.left != null && root.left.val == root.val ? left + 1 : 0;
        int resr = root.right != null && root.right.val == root.val ? right + 1 : 0;
        res[0] = Math.max(res[0],resl  + resr);   //计算当前节点被包含在内的最大值
        return Math.max(resl, resr);
    }
    //仿造
    public int longestUnivaluePath2(TreeNode root){
        if(root == null || (root.left == null && root.right == null)) return 0;
        int[] max = new int[]{0};
        helper(root, max);
        return max[0];
    }
    private int helper(TreeNode root, int[] max){
        if(root == null || (root.left == null && root.right == null)) return  0;
        int left = helper(root.left, max);
        int right = helper(root.right, max);
        int lleft = root.left != null && root.val == root.left.val? left + 1 : 0;
        int rright = root.right != null && root.val == root.right.val ? right + 1 : 0;
        max[0] = Math.max(max[0], lleft + rright);
        return Math.max(lleft, rright);
    }




}
