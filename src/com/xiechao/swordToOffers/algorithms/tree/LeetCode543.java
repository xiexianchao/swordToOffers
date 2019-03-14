package com.xiechao.swordToOffers.algorithms.tree;

import com.xiechao.swordToOffers.algorithms.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LeetCode543
 * @Author xiechao
 * @Date 2019/3/14
 * @Time 9:03
 * @Description LeetCode543 Diameter of Binary Tree
 *
 * 求树中两个字节间的边数的最大值
 */
public class LeetCode543 {
    //存在冗余计算,7ms
    Map<TreeNode,Integer> map = new HashMap<>();
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        return Math.max(left + right,Math.max(diameterOfBinaryTree(root.right),diameterOfBinaryTree(root.left)));
    }
    private int depth(TreeNode root){
        if(map.containsKey(root))
            return map.get(root);
        int ans = 0;
        if(root == null)
            ans = 0;
        else if(root.left == null && root.right == null)
            ans = 1;
        else
            ans = 1 + Math.max(depth(root.left), depth(root.right));
        map.put(root,ans);
        return ans;
    }

    //LeetCode大神，太特么牛批了
    int max = 0;
    public int diameterOfBinaryTree2(TreeNode root){
        if(root == null) return 0;
        if(root.left == null && root.right == null)
            return 0;
        findMaxDepth(root);
        return max;
    }

    private int findMaxDepth(TreeNode root) {
        if(root == null)
            return 0;
        int left = findMaxDepth(root.left);
        int right = findMaxDepth(root.right);
        max = Math.max(max,left + right);
        return 1 + Math.max(left,right);
    }
}
