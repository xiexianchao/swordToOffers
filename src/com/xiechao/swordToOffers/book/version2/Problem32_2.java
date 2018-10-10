package com.xiechao.swordToOffers.book.version2;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @ClassName Problem32_2
 * @Author xiechao
 * @Date 2018/9/18
 * @Time 21:03
 * @Description TODO
 * 之字形打印二叉树
 */
public class Problem32_2 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(pRoot == null) return result;
        Stack<TreeNode>[] stacks = new Stack[2];
        stacks[0] = new Stack<>();
        stacks[1] = new Stack<>();
        ArrayList<Integer> curList = new ArrayList<>();
        int current = 0;
        int next = 1;
        stacks[current].push(pRoot);
        while( !stacks[0].isEmpty() || !stacks[1].isEmpty()){
            TreeNode cur = stacks[current].pop();
            if(current == 0){
                if( cur.left != null)
                    stacks[next].add(cur.left);
                if(cur.right != null)
                    stacks[next].add(cur.right);
            }else{
                if( cur.right != null)
                    stacks[next].add(cur.right);
                if( cur.left != null)
                    stacks[next].add(cur.left);
            }
            curList.add(cur.val);
            if(stacks[current].isEmpty()){
                result.add(curList);
                curList = new ArrayList<>();
                current = 1 - current;
                next = 1- next;
            }
        }
        return result;


    }



}
