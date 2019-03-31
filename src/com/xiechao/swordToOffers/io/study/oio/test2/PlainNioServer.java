package com.xiechao.swordToOffers.io.study.oio.test2;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * @ClassName PlainNioServer
 * @Author xiechao
 * @Date 2019/3/28
 * @Time 15:56
 * @Description TODO
 */
public class PlainNioServer {
    public void server(int port) throws Exception{
        System.out.println("Listening for connections on port " + port);
        Selector selector = Selector.open();
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        ServerSocket serverSocket = serverChannel.socket();
        serverSocket.bind(new InetSocketAddress(port));
        serverChannel.configureBlocking(false);
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);
        final ByteBuffer msg = ByteBuffer.wrap("Hi\r\n".getBytes());
        while(true){
            int n = selector.select();
            if(n > 0){



            }
        }

    }

}
