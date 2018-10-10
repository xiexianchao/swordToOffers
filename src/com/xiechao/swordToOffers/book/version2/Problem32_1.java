package com.xiechao.swordToOffers.book.version2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Problem32_1
 * @Author xiechao
 * @Date 2018/9/18
 * @Time 20:32
 * @Description TODO
 */
public class Problem32_1 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(pRoot == null) return result;
        Queue<TreeNode> queue =  new LinkedList<>();
        queue.add(pRoot);
        int last = 1;
        int next = 0;
        ArrayList<Integer> curList = new ArrayList<>();
        while( !queue.isEmpty()){
            TreeNode cur = queue.remove();
            last--;
            if(cur.left != null)
            {
                queue.add(cur.left);
                next++;
            }
            if(cur.right != null){
                queue.add(cur.right);
                next++;
            }
            if( last == 0){
                curList.add( cur.val);
                result.add(curList);
                curList = new ArrayList<>();
                last = next;
                next = 0;
            }else{
                curList.add( cur.val );
            }

        }
        return result;

    }
}
