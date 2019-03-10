package com.xiechao.swordToOffers.algorithms.tree;

import com.xiechao.swordToOffers.algorithms.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName LeetCode637
 * @Author xiechao
 * @Date 2019/3/10
 * @Time 9:14
 * @Description LeetCode637. Average of Levels in Binary Tree
 *
 * 求二叉树每一层节点的平均值，输出列表
 *
 */
public class LeetCode637 {
    //我的代码真是丑陋不堪
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new LinkedList<>();
        if(root == null) return list;
        int cur = 0;
        int numOfLevel = 1;
        int numOfNextLevel = 0;
        long sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(! queue.isEmpty()){
            TreeNode node = queue.remove();
            if(cur == numOfLevel){
                list.add(1.0 * sum / numOfLevel);
                sum = 0;
                numOfLevel = numOfNextLevel;
                numOfNextLevel = 0;
                cur = 0;
            }
            sum += node.val;
            cur ++;
            if(node.left != null){
                queue.add(node.left);
                numOfNextLevel ++;
            }
            if(node.right != null){
                queue.add(node.right);
                numOfNextLevel++;
            }
        }
        if(cur == numOfLevel){
            list.add(1.0 * sum / numOfLevel);
        }
        return list;
    }


    //LeetCode大神
    public List<Double> averageOfLevels2(TreeNode root) {
        List<Double> result = new LinkedList<>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while( !queue.isEmpty() ){
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {  //每次正好是一层的长度
                TreeNode node = queue.poll();
                sum += node.val;
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            result.add(sum / size);
        }
        return result;
    }
}
