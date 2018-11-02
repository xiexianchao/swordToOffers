package com.xiechao.swordToOffers.algorithms.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xiechao
 * @Date : 2018/10/23
 * @Time : 11:08
 * @description : Additive Number 字符串是否满足斐波那契
 * 题目要求解决大数问题
 */
public class LeetCode306 {
    //Integer版本
    public boolean isAdditiveNumber(String num) {
        if(num == null || num.length() <= 2) return false;
        boolean[] result = new boolean[]{false};
        helper(result,num,0,new ArrayList<Integer>());
        return result[0];
    }

    private void helper(boolean[] result, String num, int start, List<Integer> tempList) {
        if(result[0]) return;
        if(start == num.length() && tempList.size() >=3){
            result[0] = true;
            return;
        }
        for (int i = start; i < num.length(); i++) {
         String str = num.substring(start,i+1);
         if(str.startsWith("0") && str.length() > 1) continue; //前导0剪枝
         if(checkOutMaxValue(str)) continue;
         Integer temp = Integer.parseInt(str);
         if(tempList.size() < 2){
             tempList.add(temp);
             helper(result,num,i+1,tempList);
             tempList.remove(tempList.size()-1);
         }else if( temp == (tempList.get(tempList.size() -1 )) + tempList.get(tempList.size() - 2)){
             tempList.add(temp);
             helper(result,num,i+1,tempList);
             tempList.remove(tempList.size()-1);
         }else if(temp > tempList.get(tempList.size() - 1) + tempList.get(tempList.size() - 2)){
             return;
         }
        }
    }
    private boolean checkOutMaxValue(String substring) {
        int len = (Integer.MAX_VALUE+"").length();
        if(substring.length() > len)
            return  true;
        else if(substring.length() == len){
            return substring.compareTo(Integer.MAX_VALUE+"") > 0;
        }else
            return false;
    }
    @Test
    public void test(){
        System.out.println(isAdditiveNumber("199100199"));
        System.out.println(isAdditiveNumber("112358"));
        System.out.println(isAdditiveNumber("121474836472147483648"));
    }

}
