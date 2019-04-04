package com.xiechao.swordToOffers.io.study.nio.demo1;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.util.CharsetUtil;

/**
 * @ClassName Server
 * @Author xiechao
 * @Date 2019/4/1
 * @Time 17:29
 * @Description TODO
 */
public class Server {
    private void bind(int port){
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try{
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group( bossGroup, workerGroup)   //设置EventLoopGroup:boss,worker
            .channel(NioServerSocketChannel.class)    // 服务端是ServerSocketChannel
            .option(ChannelOption.SO_BACKLOG,1024)
            .childHandler(new ChildChannelHandler());


            ChannelFuture f = bootstrap.bind(port).sync();

            f.channel().closeFuture().sync();
        }catch (InterruptedException e){
            System.out.println("启动netty服务端异常");
            e.printStackTrace();
        }finally{
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }
    private class ChildChannelHandler extends ChannelInitializer<SocketChannel>{

        @Override
        public void initChannel(SocketChannel socketChannel) throws Exception {
            //socketChannel.pipeline().addLast(new StringDecoder(CharsetUtil.UTF_8));
            socketChannel.pipeline().addLast(new ServerHandler());
        }
    }
    public static void main(String[] args){
        new Server().bind(8888);
    }

}
