package com.xiechao.swordToOffers.io.study.nio.demo1;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @ClassName ServerHandler
 * @Author xiechao
 * @Date 2019/4/1
 * @Time 17:45
 * @Description TODO
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        byte[] bytes = new byte[buf.readableBytes()];
        buf.readBytes(bytes);
        String message = new String(bytes,"UTF-8");
        System.out.println("服务端收到信息 ：" + message);

        String response = "hello client\r\n";
        System.out.println("服务端返回response ：" + response);
        ByteBuf buffer = Unpooled.copiedBuffer(response.getBytes());
        ctx.write(buffer);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelReadComplete ...");
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("exceptionCaught....");
    }
}
