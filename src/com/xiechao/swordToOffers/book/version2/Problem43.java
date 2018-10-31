package com.xiechao.swordToOffers.book.version2;

import org.junit.Test;

/**
 * @ClassName Problem43
 * @Author xiechao
 * @Date 2018/10/31
 * @Time 9:03
 * @Description 1~n整数中1出现的次数
 * 输入一个整数n，求1~n这n个整数的十进制表示中1出现的次数，例如输入12, 1~12中出现1的有1、10、11、12共5次
 */
public class Problem43 {
    //暴力法，直接拼成字符串来一个一个统计
    public int NumberOf1From1To(int n) {
        if(n <= 0) return 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n ; i++) {
            sb.append(i);
        }
        int count = 0;
        for (int i = 0; i < sb.length(); i++) {
            count += ( sb.charAt(i) == '1' ? 1 : 0);
        }
        return count;
    }

    //神一样的方法
    /*
    1可以出现在任意一位，比如3245，1出现在个、十、百、千位都可以。只要固定某一位为1，计算出该位是1的所有情况，将固定每一位得到的情况数相加就是最终结果。

要固定某一位为1，可以使用m = 1, 10, 100, 1000....，对n作除、余操作，将输入整数分为高位和低位两部分。举个例子，对于输入n = 3101592，m = 100，如果令a = n / m, b = n % m，将得到a = 31015，b= 92两部分，现在固定百位为1（始终固定a的最低位），即xxxx1xx这样的形式，这样形式的数有多少个呢？

0000 1 00
0000 1 01
.....
0000 1 99
0001 1 00
......
0001 1 99
0002 1 00
......
0002 1 99
......
3101 1 00
......
3101 1 99
为了看得直观，上面刻意将数字从百位处分隔开，对于百位之前的高位数，总共有0000~3101共3102种情况，而每一种情况对应着低位有00~99共100种情况，因此百位为1的情况数是3102*100，也就是(a / 10 + 1) * m种情况。好，现在得到百位为1的情况数了，个位与千位等其他位计算方法和上面类似，只需取不同的m就能将输入的整数分成两部分并固定某一位为1.

接下来m = 1000时，3101592被分成a = 3101和b = 592两部分，现在固定千位为1，但是此时千位本来就是1了，来看和上面有什么不同

000 1 000
......
000 1 999
309 1 000
......
309 1 999
310 1 000
......
310 1 592
可以看到千位前的高位从000~309和上面一样，每一种情况都有000~999种可能，但是到310时，后面最多只能到592，共000~592是593种情况。此时千位为1的情况总数为：310 * 1000 + 593，即当前要被固定的位在输入中本来就是1的话有(a / 10) * m + b + 1种情况。

再看m = 10000，固定万位的情况。a = 310, b = 1592.

00 1 0000
......
00 1 9999
30 1 0000
......
30 1 9999
没有了，共31 * 10000种，即当前要被固定的位在输入中是0的话有(a / 10) * m种情况。

一开始固定百位其实就是当前要被固定的位在输入中是2~9这种情况。

分析得差不多了，现在考虑这三种情况计算就好了。

 */
    public int NumberOf1From1To2(int n){
        int ones = 0;
        for (long m = 1; m <= n ; m *= 10) {
            long a = n / m;
            long b= n % m;
            if(a % 10 == 0 ) ones += (a / 10) * m;
            else if( a % 10 == 1) ones += (a / 10) * m + ( b + 1 );
            else ones += ((a / 10) + 1) * m ;
        }
        return ones;
    }


    @Test
    public void test(){
        System.out.println(NumberOf1From1To2(1410065408));
    }

}
