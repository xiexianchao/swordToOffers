package com.xiechao.swordToOffers.book.version2;

import com.xiechao.swordToOffers.leetcode.Leetcode897;
import org.junit.Test;

import java.util.LinkedList;

/**
 * @ClassName Problem68
 * @Author xiechao
 * @Date 2018/11/15
 * @Time 10:31
 * @Description 数中两个节点的最低公共祖先
 * 很好的一道题
 *  LeetCode236
 */
public class Problem68 {
    private class TreeNode {
        private TreeNode left, right;
        private int val;

        public TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "TreeNode{ val=" + val +
                    '}';
        }
    }
    //LeetCode大神 7ms解决
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return null;
        if(root == p || root == q) return root;     //p,q中某一个节点是另一个节点的父节点
        TreeNode left = lowestCommonAncestor2(root.left,p,q);
        TreeNode right = lowestCommonAncestor2(root.right,p,q);
        if(left != null && right != null) return root;  //如果左子树中能找到p,q中的一个节点，而右子树中能找到另一个，则root为答案
       // if(left == null && right == null) return null;
        return left != null? left:right;    //否则，返回能找到的那个子树
    }


    //按照剑指offer上的思路，保存根节点到两个目标节点的路径，然后求两条路径上最后一个相等的节点
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q == null ) return null;
        LinkedList<TreeNode> pPath = new LinkedList<>();
        LinkedList<TreeNode> qPath = new LinkedList<>();
        getPath(root,p,pPath);
        getPath(root,q,qPath);
        TreeNode cur = null;
        //TreeNode pre = null;
        for (int i = 0; i < Math.min(pPath.size(),qPath.size()); i++) {
            if(pPath.get(i) != qPath.get(i)) break;
            else cur = pPath.get(i);
        }
        return cur;
    }
    private boolean getPath(TreeNode root,TreeNode p,LinkedList<TreeNode> path){
        //LinkedList<TreeNode> path = new LinkedList<>();
        if(root == null || p == null) return false;
        if(root == p){
            path.add(p);
            return true;
        }else{
            path.add(root);

            if(getPath(root.left,p,path))
                return true;
            else if(getPath(root.right,p,path))
                return true;
            else
                path.removeLast();
        }
        return false;
    }
    @Test
    public void test(){
       TreeNode root = new TreeNode(5);
       TreeNode node_3 = new TreeNode(3);
       TreeNode node_6 = new TreeNode(6);
       TreeNode node_2 = new TreeNode(2);
       TreeNode node_4 = new TreeNode(4);
       TreeNode node_1 = new TreeNode(1);
       TreeNode node_8 = new TreeNode(8);
       TreeNode node_7 = new TreeNode(7);
       TreeNode node_9 = new TreeNode(9);

        root.left = node_3;
        root.right = node_6;
        node_3.left = node_2;
        node_3.right = node_4;
        node_2.left = node_1;
        node_6.right = node_8;
        node_8.left = node_7;
        node_8.right = node_9;

        System.out.println(lowestCommonAncestor2(root,node_1,node_9));
    }
}
