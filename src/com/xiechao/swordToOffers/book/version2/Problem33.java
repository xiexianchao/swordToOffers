package com.xiechao.swordToOffers.book.version2;

import org.junit.Test;

/**
 * @ClassName Problem33
 * @Author xiechao
 * @Date 2018/9/18
 * @Time 21:22
 * @Description TODO
 * 二叉搜索树的后序遍历序列
 * 给出一个序列，判断能否构成二叉搜索树
*/

public class Problem33 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if( sequence == null || sequence.length <=0) return false;


        return verifSquenceOfBSTCore(sequence,0,sequence.length-1);
    }
    private boolean verifSquenceOfBSTCore(int[] sequence,int start,int end){
        if( start >= end) return true;
        int root = sequence[end];
        int index = end;
        for (int i = start; i <= end ; i++) {
            if( sequence[i] > root) {
                index = i;
                break;
            }
        }
        for (int i = index; i <= end ; i++) {
            if(sequence[i] < root)
                return false;
        }
        return verifSquenceOfBSTCore(sequence,start,index-1) && verifSquenceOfBSTCore(sequence,index,end-1);
    }
    @Test
    public void test(){
        System.out.println(VerifySquenceOfBST(new int[]{7,4,6,5}));
    }
}
