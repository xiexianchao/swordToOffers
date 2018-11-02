package com.xiechao.swordToOffers.book.version2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName Problem49
 * @Author xiechao
 * @Date 2018/11/1
 * @Time 9:39
 * @Description 丑数
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含因子7。习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class Problem49 {

    //存在重复计算
    public int uglyNumber(int index) {
        if(index < 1) return 0;
        if(index == 1) return 1;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        while(list.size() < index){
            int max2 = 0,max3 = 0,max5 =0;
            int maxUgly = list.get(list.size()-1);
            int i = 0;
            while(list.get(i)*2 <= maxUgly){
                i++;
            }
            max2 = list.get(i) * 2;
            //每次都从零开始算，存在重复
            i= 0;
            while(list.get(i)*3 <= maxUgly){
                i++;
            }
            max3 = list.get(i) * 3;
            //每次都从0开始重新计算，存在重复
            i = 0;
            while(list.get(i)*5 <= maxUgly){
                i++;
            }
            max5 = list.get(i) * 5;
            list.add(min(max2,max3,max5));
        }
        return list.get(list.size() - 1);
    }
    private int min(int max2,int max3,int max5){
        return Math.min(max2,Math.min(max3,max5));
    }

    public int uglyNumber2(int index){
        if(index < 1) return 0;
        if(index == 1) return 1;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        while(list.size() < index){
            int min = min(list.get(p2) * 2,list.get(p3)*3,list.get(p5)*5);
            list.add(min);
            while(list.get(p2) * 2 <= list.get(list.size()-1))
                p2++;
            while(list.get(p3) * 3 <= list.get(list.size() - 1)) //不能让p3从p2开始，尽管第一次符合逻辑，但之后就都不符合逻辑了
                p3++;
            while(list.get(p5) * 5 <= list.get(list.size() - 1))
                p5++;
        }
        return list.get(index-1);
    }


    @Test
    public void test(){
        System.out.println(uglyNumber2(3));
    }
}
