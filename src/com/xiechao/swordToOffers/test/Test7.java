package com.xiechao.swordToOffers.test;

import java.util.Arrays;

/**
 * @ClassName Test7
 * @Author xiechao
 * @Date 2019/4/24
 * @Time 9:18
 * @Description TODO
 */
public class Test7 {
    public static void main(String[] args) {
        String line ="";
        String[] split = line.split(",");
        System.out.println(split.length);//1
        System.out.println(Arrays.toString(split)); //split[0]=""
        line = ",";
        String[] split1 = ",".split(",");
        System.out.println(split1.length);//0
        System.out.println(Arrays.toString(split1));//[]
        line = "     ";
        String[] split2 = line.split(",");
        System.out.println(split2.length); //1
        System.out.println(Arrays.toString(split2));//[           ]

        line="a      a,";
        String[] split3 = line.split(",");
        System.out.println(split3.length); //1
        System.out.println(Arrays.toString(split3));//[a        a]

        line=",a      a";
        String[] split4 = line.split(",");
        System.out.println(split4.length);  //2
        System.out.println(Arrays.toString(split4));//[""],[a    a]

        line=",aaa";
        String[] split5 = line.split(",");
        System.out.println(split5.length);   //2
        System.out.println(Arrays.toString(split5));//[""],[aaa]

    }
}
