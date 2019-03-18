package com.xiechao.swordToOffers.algorithms.tree;

import com.xiechao.swordToOffers.algorithms.TreeNode;
import org.junit.Test;

/**
 * @ClassName LeetCode572
 * @Author xiechao
 * @Date 2019/3/18
 * @Time 10:43
 * @Description 判断一棵树t是否是树s的子结构
 */
public class LeetCode572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        return helper(s,t) || isSubtree(s.left,t) || isSubtree(s.right,t);
    }
    private boolean helper(TreeNode s,TreeNode t){
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        if(s.val != t.val) return false;
        else
            return helper(s.left,t.left) && helper(s.right,t.right);
    }
    @Test
    public void test(){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;

        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(2);
        node4.left = node5;
        System.out.println(isSubtree(node1,node4));

    }


}
