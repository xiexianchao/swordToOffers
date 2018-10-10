package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;

/**
 * @author: xiehcao
 * @Date : 2018/10/9
 * @Time : 15:01
 * @description :289. Game of Life
 * 要求空间复杂度为O(n)
 */
public class LeetCode289 {
    //O(n) O(n)
    public void gameOfLife(int[][] board) {
        if( null  == board || board.length <=0 || null == board[0] || board[0].length <=0)
            return;
        int[][] newBoard = new int[board.length][];
        for (int i = 0; i < newBoard.length; i++) {
            newBoard[i] = new int[board[i].length];
        }
        for (int i = 0; i < newBoard.length; i++) {
            for (int j = 0; j < newBoard[i].length; j++) {
                newBoard[i][j] = getAliveOrDeath(board,i,j);
            }
        }
        for (int i = 0; i < newBoard.length; i++) {
            for (int j = 0; j < newBoard[i].length; j++) {
                board[i][j] = newBoard[i][j];
            }
        }

    }
    private int getAliveOrDeath(int[][] board, int i, int j) {
        int count = (i-1 >= 0? board[i-1][j]:0) + (i+1 < board.length? board[i+1][j]:0)+
                (j-1 >=0? board[i][j-1]:0) + (j+1 < board[i].length?board[i][j+1]:0)+
                ((i-1 >=0 && j+1 < board[i].length)?board[i-1][j+1]:0) +
                ((i-1 >=0 && j-1 >= 0)?board[i-1][j-1]:0) +
                ((i+1 < board.length && j-1 >= 0)?board[i+1][j-1]:0) +
                ((i+1 < board.length && j+1 < board[i].length)?board[i+1][j+1]:0);
        if(board[i][j] == 1){
            if(count <2) return 0;
            if(count >=2 && count <=3) return 1;
            if(count >3) return 0;

        }else{
            if(count ==3)
                return 1;
        }
        return board[i][j];
    }
    public void gameOfLife2(int[][] board){
        if( null  == board || board.length <=0 || null == board[0] || board[0].length <=0)
            return;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int lives = getAliveOrDeath2(board,i,j);
                if(board[i][j] == 1 && lives >=2 && lives <=3)
                    board[i][j] = 3;
                if(board[i][j] == 0 && lives == 3)
                    board[i][j] = 2;
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] >>= 1;
            }
        }


    }

    private int getAliveOrDeath2(int[][] board, int i, int j) {
        int lives = 0;
        int count = (i-1 >= 0? board[i-1][j]&1:0) + (i+1 < board.length? board[i+1][j]&1:0)+
                (j-1 >=0? board[i][j-1]&1:0) + (j+1 < board[i].length?board[i][j+1]&1:0)+
                ((i-1 >=0 && j+1 < board[i].length)?board[i-1][j+1]&1&1:0) +
                ((i-1 >=0 && j-1 >= 0)?board[i-1][j-1]&1:0) +
                ((i+1 < board.length && j-1 >= 0)?board[i+1][j-1]&1:0) +
                ((i+1 < board.length && j+1 < board[i].length)?board[i+1][j+1]&1:0);
        return count;

    }


    @Test
    public void test(){
        int[][] board = new int[4][3];
        board[0] = new int[]{0,1,0};
        board[1] = new int[]{0,0,1};
        board[2] = new int[]{1,1,1};
        board[3] = new int[]{0,0,0};
        gameOfLife2(board);
    }

}
