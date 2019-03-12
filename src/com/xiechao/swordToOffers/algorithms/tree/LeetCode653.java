package com.xiechao.swordToOffers.algorithms.tree;

import com.xiechao.swordToOffers.algorithms.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @ClassName LeetCode653
 * @Author xiechao
 * @Date 2019/3/11
 * @Time 20:34
 * @Description Two Sum IV - Input is a BST
 */
public class LeetCode653 {
    public boolean findTarget(TreeNode root, int k) {
        return helper(root,root,k);
    }
    private boolean helper(TreeNode root, TreeNode cur ,int k){
        if(cur == null) return false;
        //当前节点算在内 || 不算在内，递归到当前节点的左子树 || 不算在内，递归到当前节点的右子树
        //至于，两个节点分别位于左右子树的情况，因为下面的search是从根节点来另一个节点，所以也能找到。
        return search(root, cur, k - cur.val) || helper(root, cur.left,k) ||helper(root,cur.right,k);
    }
    //在树种寻找另一个节点
    private boolean search(TreeNode root,TreeNode cur, int k){
        if(root == null) return false;
        return (root != cur) && (root.val == k) || ( root.val > k) && search(root.left,cur, k ) || (root.val < k) && search(root.right,cur,k );
    }
    //直接使用额外空间,没用使用BST的性质
    public boolean findTarget2(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return helper2(root, k, set);
    }
    private boolean helper2(TreeNode root, int value, Set<Integer> set){
        if(root == null) return false;
        if(set.contains(value - root.val)) return true;
        set.add(root.val);
        return helper2(root.left,value,set) || helper2(root.right, value, set);
    }

    //把节点有序的放到一个排序数组中，然后头尾指针
    public boolean findTarget3(TreeNode root, int k) {
        if(root == null) return false;
        List<Integer> list = new LinkedList<>();
        inoder(root,list);
        int p1 = 0;
        int p2 = list.size() - 1;
        while(p1 < p2){
            if(list.get(p1) + list.get(p2) == k)
                return true;
            else if(list.get(p1) + list.get(p2) < k){
                p1++;
            }else{
                p2--;
            }
        }
        return false;
    }

    private void inoder(TreeNode root, List<Integer> list) {
        if(root == null) return;
        inoder(root.left, list);
        list.add(root.val);
        inoder(root.right,list);
    }
}
