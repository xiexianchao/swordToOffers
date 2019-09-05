package com.xiechao.swordToOffers.interview.shence0830;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName Main
 * @Author xiechao
 * @Date 2019/8/30
 * @Time 15:51
 * @Description TODO
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        String s3 = scanner.nextLine();
        String s4 = scanner.nextLine();
        scanner.close();
        int N = Integer.parseInt(s1);
        int M = Integer.parseInt(s3);
        int[] a = new int[N];
        int[] b = new int[M];
        String[] split1 = s2.split(" ");
        String[] split2 = s4.split(" ");
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(split1[i]);
        }
        for (int i = 0; i < M ; i++) {
            b[i] = Integer.parseInt(split2[i]);
        }
        int max = 0;
        boolean[] used = new boolean[a.length];
        boolean over = true;
        Arrays.sort(a);
        Arrays.sort(b);
        int index = a.length-1;
        for (int i = b.length-1; i >= 0 ; i--) {
            over = true;
            for (int j = index; j >= 0 && over ; j--) {
                if ( a[j] <= b[i] && !used[j]){
                    max++;
                    used[j] = true;
                    over = false;
                    index = j-1;
                }
            }
        }
        System.out.println(max);

    }
}
