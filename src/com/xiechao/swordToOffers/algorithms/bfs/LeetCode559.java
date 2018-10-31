package com.xiechao.swordToOffers.algorithms.bfs;

import java.util.List;

/**
 * @author: xiechao
 * @Date : 2018/10/18
 * @Time : 21:44
 * @description : Maximum Depth of N-ary Tree
 * 求N树的最大深度
 */
public class LeetCode559 {
    class Node {
        public int val;
        public List<Node> children;
        public Node() {}
        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    public int maxDepth(Node root) {
        if(root == null) return 0;
        if(root.children == null) return 1;
        if(root.children.size() == 0) return 1;
        int max = Integer.MIN_VALUE;
        for (Node node:root.children) {
            max = Math.max(max,maxDepth(node));
        }
        return max + 1;
    }
}
