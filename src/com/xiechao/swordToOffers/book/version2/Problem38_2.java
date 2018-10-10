package com.xiechao.swordToOffers.book.version2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName Probleam39
 * @Author xiechao
 * @Date 2018/9/26
 * @Time 21:05
 * @Description 求abc的组合，a,b,c,ab.ac,bc,abc
 * 在n个字符中求m个字符的组合？
 * 可以将n个字符分为1,n-1个字符。问题就分解为：在n-1个字符中求m-1个字符的组合 + 在n-1个字符中求m个字符的组合
 *
 * */
public class Problem38_2 {
    List<List<Character>>  result = new ArrayList<>();
    Stack<Character> stack = new Stack<>();
    public List combination(String str){
        if(str == null) return result;
        char[] chars = str.toCharArray();
        for (int i = 1; i <= chars.length ; i++) {
            combinationCore(chars,0,chars.length-1,i);
        }
        return result;
    }

    private void combinationCore(char[] chars,int start, int end ,int i) {
        if( i == 0){
            ArrayList<Character> list = new ArrayList<>();
            list.addAll(stack);
            result.add(list);
            return;
        }
        if(start > end)                  //必须放在 i == 0 后面，不然 start=3,end=2 ,i=0,将不存在
            return;
        stack.push(chars[start]);
        combinationCore(chars,start+1,end,i-1);
        stack.pop();
        combinationCore(chars,start+1,end,i);
    }
    @Test
    public void test(){
        System.out.println(combination("abc"));
    }


}
