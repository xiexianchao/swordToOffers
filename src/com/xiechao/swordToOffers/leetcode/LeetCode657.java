package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LeetCode657 {

    // 124ms
    public boolean judgeCircle1(String moves){
        boolean result = false;
        if( null != moves && moves.length() >0 && moves.length() %2 ==0){
            Map<Character, Integer> map = new HashMap<>();
            map.put('U',0);
            map.put('D',0);
            map.put('R',0);
            map.put('L',0);
            for (int i = 0; i < moves.length(); i++) {
                map.merge(moves.charAt(i),1,Integer::sum);
            }
           if(((map.get('U') - map.get('D'))==0)&&((map.get('L')-map.get('R'))==0)){
                result = true;
           }
        }
        return result;
    }

    //12ms
    public boolean judgeCircle2(String moves){
        int[] arr = new int[26];
        /*for (char c:moves.toCharArray()) {
            arr[c - 'A'] ++;
        }*/
        for (int i = 0; i < moves.length() ; i++) {
            arr[moves.charAt(i) - 'A']++;
        }
        return (arr['U'-'A'] == arr['D'-'A']) && (arr['L'-'A'] == arr['R'-'A']);

    }


    @Test
    public void test(){
        System.out.println(judgeCircle2("UD"));
    }
}
