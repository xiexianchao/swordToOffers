package com.xiechao.swordToOffers.algorithms.backtracking;

import com.sun.org.apache.regexp.internal.RE;

/**
 * @author: xiechao
 * @Date : 2018/10/23
 * @Time : 10:30
 * @description :Word Search
 * 在二维数组中寻找是否包含指定的单词。剑指offer原题
 */
public class LeetCode79 {
    public boolean exist(char[][] board, String word) {
        boolean[] isExist = new boolean[]{false};
        if(word == null || word.length() <=0) return true;
        if(board == null || board.length <=0 || board[0] == null || board[0].length <=0)
            return isExist[0];
        boolean[][] used = new boolean[board.length][];
        for (int i = 0; i < used.length; i++) {
            used[i] = new boolean[board[i].length];
        }
        for (int i = 0; i < board.length && !isExist[0]; i++) {
            for (int j = 0; j < board[i].length &&!isExist[0]; j++) {
                helper(board,word,isExist,used,0,i,j);
            }
        }

        return isExist[0];
    }

    private void helper(char[][] board, String word, boolean[] isExists,boolean[][] used,int start,int row,int clo) {
        if(isExists[0]) return;         //剪枝
        if(start == word.length()){
            isExists[0] = true;
            return;
        }
        if(row >=0 && row<board.length && clo >=0 && clo < board[0].length
                && board[row][clo] == word.charAt(start) && !used[row][clo]){
            used[row][clo] = true;
            helper(board,word,isExists,used,start+1,row+1,clo);
            helper(board,word,isExists,used,start+1,row-1,clo);
            helper(board,word,isExists,used,start+1,row,clo+1);
            helper(board,word,isExists,used,start+1,row,clo-1);
            used[row][clo] = false;
        }
    }
}
