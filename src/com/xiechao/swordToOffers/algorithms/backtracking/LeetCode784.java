package com.xiechao.swordToOffers.algorithms.backtracking;

import com.sun.org.apache.regexp.internal.RE;

import javax.xml.stream.events.Characters;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: xiechao
 * @Date : 2018/10/19
 * @Time : 9:25
 * @description : Letter Case Permutation
 */
public class LeetCode784 {
    //10ms
    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        helper(result,S,0,"");
        return result;
    }

    private void helper(List<String> result, String s, int start,String t) {
        if(start == s.length()){
            result.add(t);
            return;
        }
        Character c= s.charAt(start);
        if(Character.isLetter(c)){
            helper(result,s,start+1,t+Character.toLowerCase(c));
            helper(result,s,start+1,t+Character.toUpperCase(c));
        }else{
            helper(result,s,start+1,t + c);
        }
    }

    public List<String> letterCasePermutation2(String S) {
        List<String> result = new ArrayList<>();
        helper2(result,S.toCharArray(),0);
        return result;
    }

    //8ms
    private void helper2(List<String> result, char[] chars, int start) {
        if(start == chars.length){
            result.add(new String(chars));
            return;
        }
        if(Character.isLetter(chars[start])){
            chars[start] = Character.toUpperCase(chars[start]);
            helper2(result,chars,start+1);

            chars[start] = Character.toLowerCase(chars[start]);
            helper2(result,chars,start+1);
        }else{
            helper2(result,chars,start+1);
        }
    }

}
