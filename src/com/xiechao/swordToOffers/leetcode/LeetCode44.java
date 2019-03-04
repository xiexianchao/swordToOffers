package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName LeetCode44
 * @Author xiechao
 * @Date 2019/1/24
 * @Time 9:02
 * @Description 通配符匹配，给出一个S，一个P（P中包括？，*这样的通配符），判断是否match
 */
public class LeetCode44 {
   /* boolean isMatch = false;
    public boolean isMatch(String s, String p){
        if (s == null || s.length() <= 0 ){
            if(p == null || p.length() <= 0) return true;
            for ( char e:p.toCharArray()) {
                if( e != '*')
                    return false;
            }
            return true;
        }else if((p == null || p.length() <= 0 ))
            return false;
        else{
            int pIndex = 0;
            int sIndex = 0;
            int pEnd = p.length() - 1;
            int sEnd = s.length() - 1;
            char[] pArr = p .toCharArray();
            char[] sArr = s.toCharArray();
            while(  pArr[pIndex] != '*' && pArr[pIndex] != '?'){
                if(pArr[pIndex] == sArr[sIndex]){
                    pIndex++;
                    sIndex++;
                }else{
                    return false;
                }
            }
            while(pArr[pEnd] != '*' && pArr[pEnd] != '?'){
                if(pArr[pEnd] == sArr[sEnd]){
                    pEnd--;
                    sEnd--;
                }else{
                    return false;
                }
            }

            return  isMatchCore(Arrays.copyOfRange(pArr,pIndex,pEnd),Arrays.copyOfRange(sArr,sIndex,sEnd),0,0);
        }
    }
    private boolean isMatchCore(char[] s, char[]p, int startS,int startP) {
        if (isMatch)
            return true;
        if (startS >= s.length) {  //s匹配完了
            if(startP >= p.length) {   //p也匹配完了
                isMatch = true;
                return true;
            }else{                    //p没有匹配完
                for(int i = startP ; i < p.length ;i++){
                    if(p[i] != '*')
                        return false;
                }
                isMatch = true;
                return true;
            }
        } else if (startS < s.length && startP >= p.length) {
            return false;
        } else {
            if (p[startP] == '?') {
                return isMatchCore(s, p, startS + 1, startP + 1);
            } else if (p[startP] >= 'a' && p[startP] <= 'z') {
                if (p[startP] == s[startS]) {
                    return isMatchCore(s, p, startS + 1, startP + 1);
                } else
                    return false;
            } else if (p[startP] == '*') {
                boolean temp = false;
                for (int i = startS; i <= s.length; i++)
                    temp |= isMatchCore(s, p, i, startP + 1);
                return temp;
            }
        }
        return true;
    }
*/

    public boolean isMatch(String s, String p) {
        if(s == null || s.length() <= 0){
            if(p == null || p.length() <=0 || allStar(p,0))
                return true;
            else
                return false;
        }else if(p == null || p.length() <= 0 )
            return false;
        else{
            int pStart = 0;
            int pEnd = p.length() - 1;
            int sStart = 0;
            int sEnd = s.length() - 1;
            char[] pArr = p.toCharArray();
            char[] sArr = s.toCharArray();
            //把s,p前后的小写字符都去掉
            /*while(Character.isLowerCase(pArr[pStart])){
                if(sArr[sStart] == pArr[pStart]){
                    sStart++;
                    pStart++;
                }else
                    return false;
            }*/




            return false;
        }
    }

    /**
     *
     * @param p 要判断的字符串
     * @param i 判断的其实位置，inclusive
     * @return: 判断一个字符串从i位置开始到结束是否都是*
     */
    private boolean allStar(String p, int i) {
        for(; i < p.length() ; i++){
            if(p.charAt(i) != '*')
                return false;
        }
        return true;
    }
    @Test
    public void test(){
        System.out.println(allStar("*a**",1));
    }




}
