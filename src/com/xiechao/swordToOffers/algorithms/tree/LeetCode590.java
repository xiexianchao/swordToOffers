package com.xiechao.swordToOffers.algorithms.tree;
import com.xiechao.swordToOffers.algorithms.tree.LeetCode589;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName LeetCode590
 * @Author xiechao
 * @Date 2019/3/7
 * @Time 9:43
 * @Description LeetCode 590. N-ary Tree Postorder Traversal
 *
 * 返回一个N叉树的后序遍历
 */
public class LeetCode590 {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new LinkedList<>();
        helper(root, result);
        return result;
    }
    private void helper(Node root, List<Integer> result){
        if(root == null) return;
        if(root.children == null || root.children.size() <= 0) {
            result.add(root.val);
            return;
        }
        for (int i = 0; i < root.children.size(); i++) {
            helper(root.children.get(i), result);
        }
        result.add(root.val);
    }
}
