package com.xiechao.swordToOffers.commom;

/**
 * @author: xiehcao
 * @Date : 2018/9/3
 * @Time : 16:54
 * @description :
 */
public class ListNode<T> {
    public T value;
    public ListNode<T> next;

    /**
     * value = null
     * next = null
     * */
    public ListNode(){
        value = null;
        next = null;
    }

    /**
     * @param value
     * @description: next = null
     */
    public ListNode(T value){
        this.value = value;
        this.next = null;
    }

    public ListNode(T value, ListNode<T> next) {
        this.value = value;
        this.next = next;
    }

}
