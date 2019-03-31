package com.xiechao.swordToOffers.io.study.oio.test1;

import java.io.*;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;

/**
 * @ClassName Client
 * @Author xiechao
 * @Date 2019/3/28
 * @Time 15:39
 * @Description TODO
 */
public class Client {
    private static List<Queue> queueCache = new LinkedList<Queue>();
   // private static CountDownLatch countDownLatch = new CountDownLatch(10);
    public static void main(String...args) throws IOException, InterruptedException {
        String host="127.0.0.1";
        int  port = 8899;
        Socket client = new Socket(host,port);
      //  countDownLatch.countDown();
        Writer writer = new OutputStreamWriter(client.getOutputStream());
        writer.write("Hello Server");
        writer.write("eof\n");
        writer.flush();
     //   countDownLatch.await();
        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String temp = "";
        int index;
        while((temp = br.readLine())!= null){
            if( (index = temp.indexOf("eof")) != -1){
                sb.append(temp.substring(0,index));
                break;
            }
            sb.append(temp);
        }
        System.out.println("from server :" + sb);

        br.close();
        writer.close();
        client.close();
    }

}
