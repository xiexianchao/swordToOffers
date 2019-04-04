package com.xiechao.swordToOffers.io.study.nio.demo1;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/**
 * @ClassName ClientHandler
 * @Author xiechao
 * @Date 2019/4/1
 * @Time 20:22
 * @Description TODO
 */
public class ClientHandler extends ChannelInboundHandlerAdapter {
    private final ByteBuf byteBuf;

    public ClientHandler(){
        byte[] bytes = "client messgae".getBytes();
        byteBuf = Unpooled.buffer(bytes.length);
        byteBuf.writeBytes(bytes);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
       // super.channelActive(ctx);
        ctx.writeAndFlush(byteBuf);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        byte[] bytes = new byte[buf.readableBytes()];
        buf.readBytes(bytes);
        String message = new String(bytes, Charset.forName("UTF-8"));
        System.out.println("client get response :" + message);

    }
}
