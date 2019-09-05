package com.xiechao.swordToOffers.interview.shence0830;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName Main2
 * @Author xiechao
 * @Date 2019/8/30
 * @Time 16:14
 * @Description TODO
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        String[] split = s1.split(" ");
        String[] split1 = s2.split(" ");
        int k = Integer.parseInt(split[0]);
        int n = Integer.parseInt(split[1]);
        int[] cost = new int[k];

        for (int i = 0; i < k; i++) {
            cost[i] = Integer.parseInt(split1[i]);
        }
        if (k == 1) {
            System.out.println( n * cost[0]);
            return;
        }
        if( n == 0){
            System.out.println(0);
            return;
        }


        int person = 0;
        int minute = 0;
        while (person < n){
            minute++;
            for (int i = 0; i < k && person<n; i++) {
                if (minute % cost[i] == 0){
                    person++;
                }
            }
        }

        System.out.println(minute);
    }
}
