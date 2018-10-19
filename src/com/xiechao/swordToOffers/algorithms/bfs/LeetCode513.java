package com.xiechao.swordToOffers.algorithms.bfs;

import com.xiechao.swordToOffers.algorithms.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xiechao
 * @Date : 2018/10/19
 * @Time : 8:57
 * @description :Find Bottom Left Tree Value
 */
public class LeetCode513 {
    //我的方法 6ms 笨方法，把层序遍历序列保存下来，然后取出来
    public int findBottomLeftValue(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root,result,0);
        return result.get(result.size()-1).get(0);
    }

    private void helper(TreeNode root, List<List<Integer>> result,int level) {
        List<Integer> tempList = null;
        if(level >= result.size()){
            tempList = new ArrayList<>();
            result.add(tempList);
        }else{
            tempList = result.get(level);
        }
        tempList.add(root.val);
        if(root.left != null)
            helper(root.left,result,level+1);
        if(root.right != null)
            helper(root.right,result,level+1);
    }
    int level;
    int result;
    //LeetCode大神 3ms
    public int findBottomLeftValue2(TreeNode root) {
         level = -1;
         result = -1;
         helper2(root,0);
         return result;
    }

    private void helper2(TreeNode root, int currentLevel) {
        if(root == null) return;
        if(currentLevel > level){
            level = currentLevel;
            result = root.val;
        }
        helper2(root.left,currentLevel+1);
        helper2(root.right,currentLevel+1);
    }

}
