package com.xiechao.swordToOffers.commom;

/**
 * @author: xiehcao
 * @Date : 2018/9/3
 * @Time : 16:54
 * @description :
 */
public class LinkNode<T> {
    private T value;
    private LinkNode<T> next;

    /**
     * value = null
     * next = null
     * */
    public LinkNode(){
        value = null;
        next = null;
    }

    /**
     * @param value
     * @description: next = null
     */
    public LinkNode(T value){
        this.value = value;
        this.next = null;
    }

    public LinkNode(T value, LinkNode<T> next) {
        this.value = value;
        this.next = next;
    }

}
