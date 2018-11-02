package com.xiechao.swordToOffers.book.version2;

import com.xiechao.swordToOffers.algorithms.TreeNode;

/**
 * @ClassName Problem55_1
 * @Author xiechao
 * @Date 2018/11/2
 * @Time 9:43
 * @Description 判断二叉树是否平衡
 */
public class Problem55_1 {

    //剑指offer上的方法，后序遍历
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null) return true;
        return helper(root,new int[]{0});
    }

    //需要传递两个值，深度和是否平衡
    private boolean helper(TreeNode root, int[] depth) {
        if(root == null){
            depth[0] = 1;
            return true;
        }
        int[] left = new int[]{0};
        int[] right = new int[]{0};
        if(helper(root.left,left) && helper(root.right,right)){
            depth[0] = Math.max(left[0],right[0]) + 1;
            if(Math.abs(left[0] - right[0]) <= 1){
                return true;
            }
        }
        return false;
    }

    //github 大神
    /*
    仍然是先求得左右子树的深度，
    如果做差不超过1，就正常返回深度；如果超过了1就说明这不是棵平衡二叉树了，
    于是不断返回-1，直到根结点。
    如果不是平衡二叉树，最后会得到该二叉树的深度为-1，
    所以只需判断一棵二叉树的深度是不是大于等于0即可。
     */
    public boolean IsBalanced_Solution2(TreeNode root){
        return depth(root) >= 0;
    }

    private int depth(TreeNode root) {
        if(root == null) return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        return (left >=0 && right >=0 && Math.abs(left-right) <=1)?Math.max(left,right)+1:-1;
    }


}
