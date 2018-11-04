package com.xiechao.swordToOffers.book.version2;

import org.junit.Test;

/**
 * @ClassName Problem58
 * @Author xiechao
 * @Date 2018/11/4
 * @Time 10:33
 * @Description 反转字符串中的单词
 * I am a student.  --》student. a am I
 */
public class Problem58 {

    //两次翻转
    public String ReverseSentence(String str) {
        if(str == null || str.length() <= 1) return str;
        String reverse_origin = reverse(str,0,str.length()-1);
        int p1 = 0; //指向第一个不为空格的位置
        int p2 = 0;  //指向p1之后的空格位置或者str.length

        while(p2 < reverse_origin.length()){
            while(p1 < reverse_origin.length() && reverse_origin.charAt(p1) == ' '){
                p1 ++;
            }
            p2 = p1;
            while(p2 < reverse_origin.length() && reverse_origin.charAt(p2) != ' '){
                p2 ++;
            }
            reverse_origin=reverse(reverse_origin,p1,p2-1);
            p1 = p2;
        }
        return reverse_origin;

    }
    private String reverse(String str,int start,int end){
        if( start >= end) return str;
        StringBuilder sb = new StringBuilder(str.substring(0,start));
        for (int i = end; i >= start ; i--) {
            sb.append(str.charAt(i));
        }
        for (int i = end+1; i < str.length(); i++) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    //两次翻转，数组实现
    public String ReverseSentence3(String str){
        if(str == null || str.length() <=1 ) return str;
        char[] chars = str.toCharArray();
        reverse3(chars,0,chars.length - 1);
        int low = 0;
        int high = 0;
        while(low < chars.length){
            if(chars[low] == ' '){
                low++;
                high++;
            }else if(high == chars.length || chars[high] == ' '){
                reverse3(chars,low,--high);
                low = ++high;
            }else
                high++;

        }
        return new String(chars);
    }

    private void reverse3(char[] chars, int low, int high) {
        if(low > high) return;
        while(low < high){
            char temp = chars[high];
            chars[high] = chars[low];
            chars[low] = temp;
            high--;
            low++;
        }
        return;
    }

    //拆分成单词数组
    public String ReverseSentence2(String str){
        if(str == null || str.length() <=1 ) return str;
        String[] split = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = split.length - 1; i >=0 ; i--) {
            sb.append(split[i]);
            if(i > 0)
                sb.append(" ");
        }
        return sb.toString();
    }


    @Test
    public void test(){
        System.out.println(ReverseSentence2(" "));
        System.out.println(ReverseSentence3("" +
                ". a am I"));
    }

}
