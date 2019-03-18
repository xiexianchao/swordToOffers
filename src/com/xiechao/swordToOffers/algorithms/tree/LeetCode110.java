package com.xiechao.swordToOffers.algorithms.tree;

import com.xiechao.swordToOffers.algorithms.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LeetCode110
 * @Author xiechao
 * @Date 2019/3/18
 * @Time 11:01
 * @Description LeetCode110 判断树是否平衡
 */
public class LeetCode110 {
    //我的方法1
    public boolean isBalanced1(TreeNode root) {
        if(root == null) return true;
        return  isBalanced1(root.left) &&
                isBalanced1(root.right) &&
                Math.abs(getDepth(root.left) - getDepth(root.right)) <= 1;
    }
    private int getDepth(TreeNode root){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        return 1 + Math.max(getDepth(root.left),getDepth(root.right));
    }







    //我的方法2
    public boolean isBalanced2(TreeNode root) {
         return helper(root,new HashMap<>());
    }
    private boolean helper(TreeNode root, Map<TreeNode,Integer> map){
        if(root == null || (root.left == null && root.right == null))
            return true;
        int left = getDepth(root.left,map);
        int right = getDepth(root.right,map);
        if(Math.abs(left - right) > 1) return false;
        return helper(root.left,map) && helper(root.right,map);
    }
    private int getDepth(TreeNode root,Map<TreeNode,Integer> map){
        if(map.containsKey(root)) return map.get(root);
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        int depth = 1 + Math.max(getDepth(root.left,map),getDepth(root.right,map));
        map.put(root,depth);
        return depth;
    }

    //LeetCode大神 dfs，从下到上，没有重复计算
    public boolean isBalanced3(TreeNode root){
        return dfsHeight(root) != -1;
    }
    private int dfsHeight(TreeNode root){
        if(root == null) return 0;
        int left = dfsHeight(root.left);
        if(left == -1) return -1;
        int right = dfsHeight(root.right);
        if(right == -1)
            return  -1;
        if(Math.abs(left - right) > 1) return -1;
        return Math.max(left,right) + 1;
    }
    //模仿
    public boolean isBalanced4(TreeNode root){
       return dfs(root) != -1;
    }
    //既要传height，也要传子树是否平衡
    private int dfs(TreeNode root){
        if(root == null) return 0;
        int left = dfs(root.left);
        if(left == -1)   //左子树不平衡，
            return -1;
        int right = dfs(root.right);
        if(right == -1) //右子树不平衡
            return -1;
        if(Math.abs(left - right) > 1)
            return -1;
        else
            return Math.max(dfs(root.left),dfs(root.right)) + 1;
    }


}
