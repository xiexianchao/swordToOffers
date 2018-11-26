package com.xiechao.swordToOffers.interview;

import com.xiechao.swordToOffers.algorithms.TreeNode;

/**
 * @ClassName ParentTreeAndSub
 * @Author xiechao
 * @Date 2018/11/25
 * @Time 17:34
 * @Description 输入两棵二叉树A，B，判断B是不是A的子结构。
 * （ps：我们约定空树不是任意一个树的子结构）
 */
public class ParentTreeAndSub {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if( root2 == null || root1 == null) return false;
        boolean result = false;
        if(root1.val == root2.val){
            result = twoTreeEquals(root1,root2);
        }
        if(!result)
        result = HasSubtree(root1.left,root2);
        if(!result)
        result = HasSubtree(root1.right,root2);
        return result;
    }

    private boolean twoTreeEquals(TreeNode root1,TreeNode root2){
        if(root2 == null ) return true;
        if(root1 == null) return false;
        if(root1.val == root2.val){
            return twoTreeEquals(root1.left,root2.left) && twoTreeEquals(root1.right,root2.right);
        }else
            return false;
    }



}
