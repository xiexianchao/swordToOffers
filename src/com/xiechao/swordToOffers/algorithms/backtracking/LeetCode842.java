package com.xiechao.swordToOffers.algorithms.backtracking;

import com.sun.org.apache.regexp.internal.RE;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: xiechao
 * @Date : 2018/10/22
 * @Time : 12:01
 * @description :Split Array into Fibonacci Sequence
 * 基于组合
 */
public class LeetCode842 {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> result = new ArrayList<>();
        if(S == null || S.length() < 3) return result;
        helper(result,new ArrayList<>(),S,0,new boolean[]{false});
        return result;
    }

    private void helper(List<Integer> result,List<Integer> tempList,String s, int start,boolean[] isOver) {
        if(isOver[0]) return;              //得到结果的判断
        if(start == s.length() && tempList.size() >= 3){    //递归终止
            for (Integer e:tempList) {
                result.add(e);
            }
            isOver[0] = true;
            return;
        }else if(start == s.length()){            //递归终止
            return;
        }
        for (int i = start; i < s.length() && !isOver[0]; i++) {        //组合式
            String str = s.substring(start,i+1);              //获得子串,和之前回文组合那题一样的思路

            if(checkOutMaxValue(s.substring(start,i+1))) continue; //MAX_VALUE 检查
            if(s.charAt(start) == '0' && str.length() > 1) continue;  //去除前导0

            Integer temp = Integer.parseInt(str);               //转成整型
            if(tempList.size() < 2){                    //初试元素添加,=2的时候就是插入第三个元素了，所以不包括=2
                tempList.add(temp);
                helper(result,tempList,s,i+1,isOver);
                tempList.remove(tempList.size() - 1);
            }else if(temp == tempList.get(tempList.size() - 1) + tempList.get(tempList.size() - 2)) //斐波那契剪枝
            {
                tempList.add(temp);
                helper(result,tempList,s,i+1,isOver);
                tempList.remove(tempList.size() - 1);
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
      /*  System.out.println(splitIntoFibonacci("123456579"));
        System.out.println(splitIntoFibonacci("11235813"));
        System.out.println(splitIntoFibonacci("112358130"));
        System.out.println(splitIntoFibonacci("0123"));
        System.out.println(splitIntoFibonacci("1101111"));*/
        System.out.println(splitIntoFibonacci("1011"));
    }
}
