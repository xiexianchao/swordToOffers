package com.xiechao.swordToOffers.commom;

/**
 * @author: xiehcao
 * @Date : 2018/9/3
 * @Time : 16:54
 * @description :
 */
public class TreeNode<T> {
    private T data;
    private TreeNode<T> right;
    private TreeNode<T> left;

    /**
     *
     */
    public TreeNode(){

    }

    /**
     *
     * @param value
     */
    public TreeNode(T value){
        this.data = value;
        this.left = null;
        this.right = null;
    }



    /**
     *
     * @param data
     * @param right
     * @param left
     */
    public TreeNode(T data, TreeNode<T> right, TreeNode<T> left) {
        this.data = data;
        this.right = right;
        this.left = left;
    }

}
