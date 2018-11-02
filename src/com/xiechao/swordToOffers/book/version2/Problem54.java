package com.xiechao.swordToOffers.book.version2;

import com.sun.org.apache.regexp.internal.RE;
import com.xiechao.swordToOffers.algorithms.TreeNode;

import java.util.Stack;

/**
 * @ClassName Problem54
 * @Author xiechao
 * @Date 2018/11/2
 * @Time 8:47
 * @Description 求二叉搜索树的第k大节点
 */
public class Problem54 {
    //递归
    TreeNode KthNode(TreeNode pRoot, int k) {
        if(pRoot == null || k <= 0) return null;
        TreeNode node = null;
        if(pRoot.left != null)
        {
            node = KthNode(pRoot.left,k);
        }
        if(node != null)
            return node;
        k --;
        if( k == 0) return pRoot;
        if(pRoot.right != null) {
         node = KthNode(pRoot.right, k);
        }
        return node;
    }
    //循环
    TreeNode KthNode2(TreeNode pRoot, int k) {
        if(pRoot == null || k <= 0) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = pRoot;
        while(!stack.isEmpty() || node != null){
            while(node != null){
                stack.push(node);
                node = node.left;
            }
            if(!stack.isEmpty()){
                node = stack.pop();
                if( k == 1)
                    return node;
                else
                    k --;
                node = node.right;
            }
        }
        return null;
    }
}
