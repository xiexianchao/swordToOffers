package com.xiechao.swordToOffers.algorithms.tree;

import com.xiechao.swordToOffers.algorithms.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @ClassName LeetCode404
 * @Author xiechao
 * @Date 2019/3/12
 * @Time 9:56
 * @Description LeetCode404. Sum of Left Leaves
 * 求所有左叶子节点的和
 */
public class LeetCode404 {
    //利用中序遍历
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode pre = null;
        while(node != null || !stack.isEmpty()){
            while(node != null){
                stack.push(node);
                node = node.left;
            }
            if( !stack.isEmpty()){
                node = stack.pop();
                if(pre != null &&node.left == pre && pre.left == null && pre.right == null){
                    sum += pre.val;
                }
                pre = node;
                node = node.right;
            }
        }
        return sum;
    }

    //利用前序遍历
    public int sumOfLeftLeaves2(TreeNode root) {
        if(root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        TreeNode node = null;
        int sum = 0;
        stack.push(root);
        while(!stack.isEmpty()){
            pre = node;
            node = stack.pop();
            if(pre != null && pre.left == node && node.left == null && node.right == null)
                sum += node.val;
            if(node.right != null)
                stack.push(node.right);
            if(node.left != null)
                stack.push(node.left);
        }
        return sum;
    }

    //LeetCode大神
    public int sumOfLeftLeaves3(TreeNode root){
        if(root == null) return 0;
        int ans = 0;
        if(root.left != null){
            if(root.left.left == null && root.left.right == null)
                ans += root.left.val;
            else
                ans += sumOfLeftLeaves3(root.left);
        }
        ans += sumOfLeftLeaves3(root.right);
        return ans;
    }

    @Test
    public void test(){
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(13);
        node1.left = node2;
        node1.right = node3;
        System.out.println(sumOfLeftLeaves(node1));
    }


}
