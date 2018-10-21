package com.xiechao.swordToOffers.algorithms.bfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xiechao
 * @Date : 2018/10/18
 * @Time : 21:53
 * @description :N-ary Tree Level Order Traversal
 * 求N树层序遍历的结果
 */
public class LeetCode429 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        List<Integer> list = new ArrayList<>();
        //list.add(root.val);
        result.add(list);
        helper(result,root,0);
        return result;
    }

    private void helper(List<List<Integer>> result, Node root, int level) {
        List<Integer> tempList = null;
        if(level >= result.size()){
            tempList = new ArrayList<>();
            result.add(tempList);
        }else{
            tempList = result.get(level);
        }

        tempList.add(root.val);
        if(root.children != null && root.children.size() >0) {
            for (Node node : root.children) {
                helper(result, node, level + 1);
            }
        }
    }
}
