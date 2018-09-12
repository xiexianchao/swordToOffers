package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LeetCode559 {
    private static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    public int maxDepth(Node root) {
        if(root == null) return 0;
        if( root.children == null || root.children.size() <=0) return 1;

        int maxSubTreeDeep = 0;
        for (Node node : root.children) {
            int subDeep = maxDepth(node);
            if(maxSubTreeDeep < subDeep)
                maxSubTreeDeep = subDeep;

        }
        return 1 + maxSubTreeDeep;
    }

    @Test
    public void test(){
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();
        Node node5 = new Node();
        Node node6 = new Node();
        node1.children = new ArrayList<>();
        node1.children.add(node2);
        node1.children.add(node3);
        node1.children.add(node4);
        node3.children = new ArrayList<>();
        node3.children.add(node5);
        node3.children.add(node6);
        System.out.println(maxDepth(node1));
    }

}
