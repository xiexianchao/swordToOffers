package com.xiechao.swordToOffers.book.version2;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author: xiehcao
 * @Date : 2018/9/19
 * @Time : 16:49
 * @description :二叉树中和为某一值的路径
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class Problem34 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        int currentSum = 0;
        LinkedList<Integer> path = new LinkedList<>();
        addPath(root,target,currentSum,result,path);

        return result;
    }
    private void addPath(TreeNode root,int target,int current,ArrayList<ArrayList<Integer>> result,LinkedList<Integer> path){
        current += root.val;
        path.add(root.val);

        if(root.left == null && root.right == null && current == target) {
            ArrayList<Integer> list = new ArrayList<>(path);
            result.add(list);
        }
        if( root.left != null)
            addPath(root.left,target,current,result,path);
        if( root.right != null)
            addPath(root.right,target,current,result,path);

        path.removeLast();
    }

}
