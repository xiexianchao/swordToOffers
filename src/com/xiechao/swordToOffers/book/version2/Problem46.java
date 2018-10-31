package com.xiechao.swordToOffers.book.version2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Problem46
 * @Author xiechao
 * @Date 2018/10/31
 * @Time 11:04
 * @Description 把数字翻译成字符串
 * 回溯
 */
public class Problem46 {

    public List<String> translateNum(int n){
        List<String> result = new ArrayList<>();
        if(n < 0) return result;
        String number = String.valueOf(n);
        StringBuilder sb = new StringBuilder();
        helper(sb,result,number,0);
        return result;
    }

    private void helper(StringBuilder sb, List<String> result, String str,int start) {
        if(start == str.length()){
            result.add(sb.toString());
            return;
        }
        sb.append(num2char(str.charAt(start) +""));
        helper(sb,result,str,start+1);
        sb.deleteCharAt(sb.length() - 1);

        if(checkTwoChar(str,start)){
            sb.append(num2char(str.charAt(start) +"" +str.charAt(start+1)));
            helper(sb,result,str,start+2);
            sb.deleteCharAt(sb.length() -1);
        }
    }

    private boolean checkTwoChar(String str, int start) {
        if(start+1 >= str.length()) return false;
        Integer temp = Integer.parseInt(str.charAt(start) + "" + str.charAt(start+1));
        if(temp > 27) return false;
        return true;
    }

    private char num2char(String c) {
        int e = Integer.valueOf(c);
        return (char)(e+97);
    }
    @Test
    public void test(){
        System.out.println(translateNum(12258));
    }
}
