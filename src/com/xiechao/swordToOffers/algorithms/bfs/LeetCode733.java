package com.xiechao.swordToOffers.algorithms.bfs;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: xiechao
 * @Date : 2018/10/18
 * @Time : 12:10
 * @description :用newColor填充给定坐标的4连通区域
 */
public class LeetCode733 {
    //自己写的代码虽然能跑通，但思路混乱，结构冗余,使用的额外的空间
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length <=0 || image[0] == null || image[0].length <=0)
            return null;
        int[][] newImage = new int[image.length][image[0].length];
        boolean[][] used = new boolean[image.length][image[0].length];
        for (int i = 0; i < newImage.length; i++) {
            newImage[i] = Arrays.copyOf(image[i],image[i].length);
            used[i] = new boolean[image[0].length];
        }
        helper(newImage,image,sr,sc,newColor,used);
        return newImage;
    }

    private void helper(int[][] newImage, int[][] image, int sr, int sc, int newColor,boolean[][] used) {
        if( sr >=0 && sr < newImage.length && sc >=0 && sc < newImage[0].length){
            newImage[sr][sc] = newColor;
            used[sr][sc] = true;
            setNewColor(newImage,image,sr-1,sc,newColor,image[sr][sc],used);
            setNewColor(newImage,image,sr+1,sc,newColor,image[sr][sc],used);
            setNewColor(newImage,image,sr,sc-1,newColor,image[sr][sc],used);
            setNewColor(newImage,image,sr,sc+1,newColor,image[sr][sc],used);
        }else{
            return;
        }
    }
    private void setNewColor(int[][] newImage,int[][] image,int sr,int sc,int newColor,int key,boolean[][] used){
        if( sr >=0 && sr < newImage.length && sc >=0 && sc < newImage[0].length && image[sr][sc] == key && !used[sr][sc]){
            newImage[sr][sc] = newColor;
            used[sr][sc] = true;
            helper(newImage,image,sr,sc,newColor,used);
        }else{
            return;
        }
    }
    //LeetCode 大神 11ms 思路清晰明朗
    public int[][] floodFill2(int[][] image, int sr, int sc, int newColor){
        if(image == null || image.length <=0 || image[0] == null || image[0].length <=0)
            return image;
        if(image[sr][sc] == newColor) return image;
        helper2(image,sr,sc,image[sr][sc],newColor);
        return image;
    }

    private void helper2(int[][] image, int sr, int sc, int color, int newColor) {
        if(sr >=0 && sr < image.length && sc >=0 && sc < image[0].length && image[sr][sc] == color){
            image[sr][sc] = newColor;
            helper2(image,sr+1,sc,color,newColor);
            helper2(image,sr-1,sc,color,newColor);
            helper2(image,sr,sc-1,color,newColor);
            helper2(image,sr,sc+1,color,newColor);
        }

    }


    @Test
    public void test(){
        int[][] array = new int[2][3];
        array[0] = new int[]{0,0,0};
        array[1] = new int[]{0,0,0};
        //array[2] = new int[]{1,0,1};
        floodFill(array,0,0,2);
    }
}
