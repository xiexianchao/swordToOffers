package com.xiechao.swordToOffers.book.version2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @ClassName Probleam38
 * @Author xiechao
 * @Date 2018/9/26
 * @Time 20:23
 * @Description 求abc的全排列
 */
public class Problem38 {
    //private ArrayList<String> result = new ArrayList<>();
    private Set<String> set = new TreeSet<>();
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if(str == null) return result;
        Permutation(str.toCharArray(),0);
        result.addAll(set);
        return result;
    }

    private void Permutation(char[] chrs, int start) {
        if(start == chrs.length -1){
            set.add(new String(chrs));
        }
        for (int i = start; i < chrs.length; i++) {
            char temp = chrs[i];
            chrs[i] = chrs[start];
            chrs[start] = temp;

            Permutation(chrs,start+1);

            temp = chrs[i];
            chrs[i] = chrs[start];
            chrs[start] = temp;
        }
    }
    @Test
    public void test(){
        System.out.println(Permutation("abc"));
    }


}
