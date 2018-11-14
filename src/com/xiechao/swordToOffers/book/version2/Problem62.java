package com.xiechao.swordToOffers.book.version2;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @author: xiechao
 * @Date : 2018/11/13
 * @Time : 11:25
 * @description :圆圈中最后剩下的数字
 * 约瑟夫圆环问题，环形链表解决
 */
public class Problem62 {
    public int LastRemaining_Solution(int n, int m) {
        if(n <=0 || m <=0 ) return -1;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n ; i++) {
            list.add(i);
        }
        int index = 0;
        while(list.size() > 1){
            for (int i = 0; i < m -1; i++) {
                index++;
            }
            index = index % list.size();
            list.remove(index);
        }
        return list.getFirst();
    }
    @Test
    public void test(){
        System.out.println(LastRemaining_Solution(5,3));
    }
}
