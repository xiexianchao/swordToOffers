package com.xiechao.swordToOffers.algorithms.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xiechao
 * @Date : 2018/10/23
 * @Time : 10:02
 * @description : Restore IP Addresses
 */
public class LeetCode93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if(s == null ||s.length() <=0 || s.length() > 12) return result;
        helper(result,new ArrayList<Integer>(),s,0);
        return result;
    }

    private void helper(List<String> result,  ArrayList<Integer> tempList, String origin,int start) {
        if(origin.length() == start ){
            String str = "";
            for (Integer e:tempList) {
                str += e+".";
            }
            result.add(str.substring(0,str.length()-1));
            return;
        }
        for (int i = start; i < origin.length(); i++) {
            if ((i - start + 1) > 3) continue;              //剪枝子串长度大于3的情况
            String str = origin.substring(start, i + 1);
            if (str.startsWith("0") && str.length() > 1) continue;  //去除前导0
            if (Integer.parseInt(str) > 255) continue;  //剪枝大于255
            if (tempList.size() <= 3) {             //剪枝 子串个数大于4的情况
                tempList.add(Integer.parseInt(str));
                helper(result, tempList, origin, i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
    @Test
    public void test(){
        System.out.println(restoreIpAddresses("25525511135"));
        System.out.println(restoreIpAddresses("010010"));
    }
}
