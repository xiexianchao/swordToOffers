package com.xiechao.swordToOffers.book.version2;

import org.junit.Test;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author: xiehcao
 * @Date : 2018/9/26
 * @Time : 15:44
 * @description :序列化反序列化二叉树
 */
public class Problem37{
    private  class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    String Serialize(TreeNode root) {
       if( root == null ) return null;
       StringBuffer sb = new StringBuffer();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node != null) {
                sb.append(node.val);
                sb.append(',');

                if (node.right != null) {
                    stack.push(node.right);
                } else {
                    stack.push(null);
                }

                if (node.left != null) {
                    stack.push(node.left);
                } else {
                    stack.push(null);
                }
            }else{
                sb.append("$,");
            }
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
    int index = 0;

    //使用前序遍历
    TreeNode Deserialize(String str) {
        if(str == null || index >= (str.length()-1)) return null;
        String[] chars = str.split(",");

        return deserializeCore(chars);
    }
    TreeNode deserializeCore(String[] chars){
        if(index >= chars.length) return null;
        String c = chars[index];
        index++;
        if(c.equals("$")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(c));
        root.left = deserializeCore(chars);
        root.right = deserializeCore(chars);
        return root;
    }


    //使用层序遍历
    String Serialize2(TreeNode root){
        if(root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.remove();
            if(node != null){
                queue.add(node.left);
                queue.add(node.right);
                sb.append(node.val);
                sb.append(',');
            }else{
                sb.append("$,");
            }
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
    TreeNode dDeserialize2(String string){
        if(string == null || string.length() <= 0) return null;
        String[] strs = string.split(",");
        TreeNode[] treeNodes = new TreeNode[strs.length];
        for (int i = 0; i < strs.length; i++) {
            if(! strs[i].equals("$")){
                treeNodes[i] = new TreeNode(Integer.parseInt(strs[i]));
            }
        }
        int j = 1;
        for (int i = 0; i < treeNodes.length && j < treeNodes.length; i++) {
            if(treeNodes[i] != null){
                treeNodes[i].left = treeNodes[j++];
                treeNodes[i].right = treeNodes[j++];
            }
        }
        return treeNodes[0];

    }





    @Test
    public void test(){
        TreeNode node_1 = new TreeNode(8);
        TreeNode node_2 = new TreeNode(6);
        TreeNode node_3 = new TreeNode(10);
        TreeNode node_4 = new TreeNode(5);
        TreeNode node_5 = new TreeNode(7);
        TreeNode node_6 = new TreeNode(9);
        TreeNode node_7 = new TreeNode(11);
        node_1.left = node_2;
       // node_1.right = node_3;
        node_2.left = node_4;
       // node_2.right = node_5;
        node_4.left = node_6;
        //node_3.right = node_7;

     //   String string = Serialize(node_1);
     //   System.out.println(Serialize(node_1));
     //   TreeNode root = Deserialize(string);

        String string = Serialize2(node_1);
        System.out.println(string);

    }



}
