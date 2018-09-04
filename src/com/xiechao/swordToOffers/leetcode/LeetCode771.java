package com.xiechao.swordToOffers.leetcode;

/**
 *
 */
public class LeetCode771 {
    //25ms
    public int numJewelsInStones1(String J, String S) {
        char[] chars = S.toCharArray();
        int result = 0;
        for (char c:chars) {
            if(J.contains(c+"")){
                result++;
            }

        }
        return result;
    }
    //15ms
    public int numJewelsInStones2(String J,String S){
        int result = 0;
        char[] charS = S.toCharArray();
        char[] charJ = J.toCharArray();
        for (int i = 0; i < charS.length; i++) {
            for (int j = 0; j < charJ.length; j++) {
                if(charS[i] == charJ[j])
                    result++;
            }
        }
        return result;
    }
    //13ms
    public int numJewelsInStones3(String J,String S){
        int result = 0;
        for (int i = 0; i < S.length(); i++) {
            if(J.indexOf(S.charAt(i)) != -1)
                result ++;
        }
        return result;
    }
    
}
