package com.xiechao.swordToOffers.algorithms.tree;

/**
 * @ClassName LeetCode559
 * @Author xiechao
 * @Date 2019/3/8
 * @Time 9:13
 * @Description
 *
 * 求N叉树的最大深度
 */
public class LeetCode559 {
    public int maxDepth(Node root) {
        if(root == null) return 0;
        if(root.children == null || root.children.size() <=0) return 1;
        int max = 0;
        for (int i = 0; i < root.children.size(); i++) {
            max = Math.max(maxDepth(root.children.get(i)), max);
        }
        return 1 + max;
    }
}
