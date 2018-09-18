package com.xiechao.swordToOffers.book.version2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Problem32
 * @Author xiechao
 * @Date 2018/9/18
 * @Time 14:31
 * @Description TODO
 * 从上到下打印二叉树
 */
public class Problem32 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode remove = queue.remove();
            list.add(remove.val);
            if(remove.left != null) queue.add(remove.left);
            if(remove.right != null) queue.add(remove.right);
        }
        return list;
    }


}
