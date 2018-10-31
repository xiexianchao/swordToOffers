package com.xiechao.swordToOffers.book.version2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName Problem45
 * @Author xiechao
 * @Date 2018/10/31
 * @Time 10:54
 * @Description 把数组排列成最小的数字
 */
public class Problem45 {
    public String printMinNumber(int[] numbers) {
        if(numbers == null || numbers.length <=0) return "";
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (o1+""+o2).compareTo(o2+""+o1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int a:list) {
            sb.append(a);
        }
        return sb.toString();
    }
}
