package com.xiechao.swordToOffers.io.study.oio.test3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @ClassName Client
 * @Author xiechao
 * @Date 2019/4/2
 * @Time 14:57
 * @Description TODO
 */
public class Client {

    private static void connect(String host, int port){
        Socket socket =  null;
        try {
             socket = new Socket(host,port);


            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("aaaa".getBytes());
            outputStream.flush();
            InputStream in = socket.getInputStream();
             byte[] buf = new byte[1024];
             int len = 0;
             while((len = in.read(buf)) != -1){
                 String s = new String(buf,0 , len,"UTF-8");
                 System.out.println(s);
             }

        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String...args){
        //Client client = new Client();
        connect("localhost", 20000);
    }
}
