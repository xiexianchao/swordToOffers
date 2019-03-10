package com.xiechao.swordToOffers.algorithms.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName LeetCode429
 * @Author xiechao
 * @Date 2019/3/9
 * @Time 9:16
 * @Description LeetCode429 N-ary Tree Level Order Traversal
 * 返回一棵N叉树的层序遍历,借助表示层的索引i和递归来做
 */
public class LeetCode429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new LinkedList<>();
        helper(result,root,0);
        return result;
    }

    private void helper(List<List<Integer>> result, Node root, int i) {
        if(root == null) return;
        List<Integer> temp = null;
        if(result.size()  <= i) {
            temp = new LinkedList<>();
            result.add(temp);
        }
        temp = result.get(i);
        temp.add(root.val);
        for (Node node:root.children) {
            helper(result,node,i+1);
        }
    }
}
