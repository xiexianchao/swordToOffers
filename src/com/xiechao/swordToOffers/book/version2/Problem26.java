package com.xiechao.swordToOffers.book.version2;

/**
 * 树的子结构
 */

public class Problem26 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root2 == null)
            return false;
        if(root1 == null)
            return false;
       boolean result = false;
       if(root1.val == root2.val)
           result = hasSubtreeCore(root1,root2);
       if(!result)
           result = HasSubtree(root1.left,root2);
       if(!result)
           result = HasSubtree(root1.right,root2);

       return result;
    }
    private boolean hasSubtreeCore(TreeNode root1,TreeNode root2){
        if( root2 == null)
            return true;
        if( root1 == null)
            return false;
        if( root1.val != root2.val)
            return false;
        return hasSubtreeCore(root1.left,root2.left) && hasSubtreeCore(root1.right,root2.right);
    }

}
