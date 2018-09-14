package com.xiechao.swordToOffers.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: xiehcao
 * @Date : 2018/9/14
 * @Time : 9:51
 * @description :Roman to Integer
 */
public class LeetCode13 {

    //113ms
    public int romanToInt(String s) {
        if( null == s || s.length() <=0)
            return 0;
        int[] code_V = new int[]{1,5,10,50,100,500,1000};
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',0);
        map.put('V',1);
        map.put('X',2);
        map.put('L',3);
        map.put('C',4);
        map.put('D',5);
        map.put('M',6);

        int pre = -3;
        int result = 0;
        int pre_value = 0;
        for (int i = 0; i < s.length(); i++) {
             int cur = map.get(s.charAt(i));
            if( (( pre == 0) || (pre == 2) || (pre == 4)) &&
                    (cur - pre <=2) && (cur - pre >0)){
                result -=pre_value;
                pre_value = code_V[cur] - code_V[pre];
                result +=pre_value;
            }else{
                pre_value = code_V[map.get(s.charAt(i))];
                result += pre_value;
            }
            pre = cur;

        }
        return result;
    }
    static Map<Character,Integer> map = new HashMap<>();
    static{
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
    }
    //LeetCode大神
    public int romanToInt2(String s){
        if( null == s || s.length() <=0)
            return 0;
        int result = 0;
        int curVal = 0;
        int preval = 1000;
        for (int i = 0; i < s.length(); i++) {
            curVal = map.get(s.charAt(i));
            if(curVal > preval) {
                result += curVal - preval - preval;
            }
            else
                result += curVal;
            preval = curVal;
        }
        return result;

    }


    @Test
    public void test(){
        System.out.println(romanToInt2("LVIII"));
    }
}
