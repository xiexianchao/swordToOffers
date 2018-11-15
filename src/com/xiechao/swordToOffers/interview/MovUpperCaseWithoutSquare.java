package com.xiechao.swordToOffers.interview;

import org.junit.Test;

import java.util.Scanner;

/**
 * @ClassName MovUpperCaseWithoutSquare
 * @Author xiechao
 * @Date 2018/11/5
 * @Time 9:37
 * @Description 给出一个字符串把大写字母移动到后面，不适用额外空间
 */
public class MovUpperCaseWithoutSquare {
    //88 ms 基于冒泡排序的算法
    public String moving(String str){
        if(str == null || str.length() <= 1) return str;
        char[] chars = str.toCharArray();
        for (int i = chars.length - 1; i >= 0 ; i--) {
            if(chars[i] >= 'A' && chars[i] <= 'Z') {
                for (int j = chars.length - 1; j > i;) {
                    if(chars[j] >= 'A' && chars[j] <= 'Z'){
                        j--;
                    }else{
                        char temp = chars[i];
                        for (int k = i; k < j ; k++) {
                            chars[k] = chars[k+1];
                        }
                        chars[j] = temp;
                        break;
                    }
                }
            }
        }
        return new String(chars);
    }


  /*  public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String str = scan.nextLine();
            System.out.println(moving(str));
        }
    }*/



    @Test
    public void test(){
        System.out.println(moving("AkleBiCeilD"));
    }

}
