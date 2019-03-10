package com.xiechao.swordToOffers.algorithms.tree;

import com.xiechao.swordToOffers.algorithms.TreeNode;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName LeetCode993
 * @Author xiechao
 * @Date 2019/3/10
 * @Time 9:44
 * @Description LeetCode993  Cousins in Binary Tree
 * 判断两个节点是否是堂兄弟(有相同深度，但父节点不是同一个)
 */
public class LeetCode993 {
    //LeetCode大神
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while( !queue.isEmpty()){
            int size = queue.size();
            boolean isExistsA = false, isExistsB = false;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node.val == x) isExistsA = true;
                if(node.val == y) isExistsB = true;
                if(node.left != null && node.right != null){
                    if (node.left.val == x & node.right.val == y) {
                        return false;
                    }
                    if (node.left.val == y && node.right.val == x) {
                        return false;
                    }
                }
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            if(isExistsA && isExistsB) return true;
        }
        return false;
    }

}
