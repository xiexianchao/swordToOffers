package com.xiechao.swordToOffers.algorithms.tree;

import com.xiechao.swordToOffers.algorithms.ListNode;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName LeetCode589
 * @Author xiechao
 * @Date 2019/3/7
 * @Time 9:35
 * @Description LeetCode589 N-ary Tree Preorder Traversal
 * 返回一个N叉树的前序遍历
 */
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}
public class LeetCode589 {

    public List<Integer> preorder(Node root) {
        List<Integer> list = new LinkedList<>();
        if(root == null) return list;
        helper(root,list);
        return list;
    }

    private void helper(Node root,List<Integer> result) {
        if(root == null) return;
        result.add(root.val);
        if(root.children == null || root.children.size() <= 0)
            return;
        for (int i = 0; i < root.children.size(); i++) {
            helper(root.children.get(i),result);
        }
    }
}
