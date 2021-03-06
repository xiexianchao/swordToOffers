package com.xiechao.swordToOffers.book.version2;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Problem50
 * @Author xiechao
 * @Date 2018/11/1
 * @Time 10:05
 * @Description 在一个字符串(0<=字符串长度<=10000，
 * 全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 */
public class Problem50 {
    public int FirstNotRepeatingChar(String str) {
        if(str == null || str.length() <= 0) return -1;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            map.merge(str.charAt(i),1,Integer::sum);
        }
        for (int i = 0; i < str.length(); i++) {
            if(map.get(str.charAt(i)) == 1)
                return i;
        }
        return -1;
    }
}
