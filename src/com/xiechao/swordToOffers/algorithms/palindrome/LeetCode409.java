package com.xiechao.swordToOffers.algorithms.palindrome;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @ClassName LeetCode409
 * @Author xiechao
 * @Date 2018/10/26
 * @Time 11:14
 * @Description  Longest Palindrome
 * 给定一个由小写或大写字母组成的字符串，找到可以用这些字母构建的最长的回文长度。
 * 区分大小写
 * 很简单：回文子串如果是偶数个，必定是n对字符；如果是奇数个，必定是2*n+1
 * 统计字符串s中出现成对出现字符的个数，如果出现奇数m次，那么m-1就是偶数
 */
public class LeetCode409 {

    //LeetCode大神 7ms
    public int longestPalindrome2(String s) {
        if(s == null || s.length() <=0 ) return 0;
        boolean[] map = new boolean[128];
        int len = 0 ;
        for (Character c:s.toCharArray()) {
            map[c] = !map[c];
            if(!map[c]) len +=2;
        }
        if(len < s.length())
            len ++;
        return len;
    }


    //暴力法，全排列，求最大回文长度
    // timeout
    public int longestPalindrome(String s) {
        if(s == null || s.length() <=0 ) return 0;
        if(s.length() == 1) return 1;
        int[] max = new int[]{0};
        helper(new ArrayList<Character>(),max,0,s,new boolean[s.length()]);
        return max[0];
    }

    private void helper(ArrayList<Character> tempList, int[] max, int start,String s,boolean[] used) {
        if(checkisPalindrome(tempList)){
            max[0] = Math.max(max[0],tempList.size());
        }
        if(start == s.length()){
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if(used[i]) continue;
            tempList.add(s.charAt(i));
            used[i] = true;
            helper(tempList,max,start+1,s,used);
            used[i] = false;
            tempList.remove(tempList.size()-1);
        }
    }

    private boolean checkisPalindrome(ArrayList<Character> tempList) {
        if(tempList.size() <= 1) return true;
        int start = 0;
        int end  = tempList.size() -1;
        while(start < end){
            if(tempList.get(start) != tempList.get(end)) return false;
            start++;
            end--;
        }
        return true;
    }
    @Test
    public void test(){
        System.out.println(longestPalindrome("tattarrattat"));
    }
}
