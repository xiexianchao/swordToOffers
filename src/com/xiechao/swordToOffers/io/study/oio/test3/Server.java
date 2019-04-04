package com.xiechao.swordToOffers.io.study.oio.test3;

import sun.java2d.pipe.OutlineTextRenderer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * @ClassName Server
 * @Author xiechao
 * @Date 2019/4/2
 * @Time 14:42
 * @Description TODO
 */
public class Server {
    private static void startup(int port){

            new Thread(new Runnable() {
                @Override
                public void run() {
                    ServerSocket server = null;
                    try {
                        server = new ServerSocket(port);
                        while (true) {
                            Socket client = server.accept();
                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    try{
                                        System.out.println("get connection from :" + client.getInetAddress().getHostAddress());
                                        OutputStream outputStream = client.getOutputStream();
                                        outputStream.write("Response from server".getBytes());
                                        outputStream.flush();
                                        InputStream inputStream = client.getInputStream();
                                        int len = 0;
                                        byte[] buf = new byte[1024];
                                        while ((len = inputStream.read(buf)) != -1) {
                                            String request = new String(buf, 0, len, "UTF-8");
                                            System.out.println(request);
                                        }
                                        System.out.println("over");

                                    }catch (Exception e){
                                        e.printStackTrace();
                                    }finally {
                                        try {
                                            client.close();
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                    }
                            }
                            }).start();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        if (server != null) {
                            try {
                                server.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }).start();
    }
    public static void main(String...args){
       // Server server = new Server();
        startup(20000);
    }
}
