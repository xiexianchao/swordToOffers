package com.xiechao.swordToOffers.io.study.oio.test2;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * @ClassName PalinOioServer
 * @Author xiechao
 * @Date 2019/3/28
 * @Time 15:49
 * @Description TODO
 */
public class PalinOioServer {
    public void sever(int port) throws IOException {
        final ServerSocket socket = new ServerSocket(port);
        while(true){
            final Socket clientSocket = socket.accept();
            System.out.println("Accepted connection fom " + clientSocket);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    OutputStream out;
                    try {
                        out = clientSocket.getOutputStream();
                        out.write("Hi!\r\n".getBytes(Charset.forName("UTF-8")));
                        out.flush();
                        clientSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();  //一个线程处理一个socket
        }
    }

}
