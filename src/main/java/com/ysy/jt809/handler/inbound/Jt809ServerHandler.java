package com.ysy.jt809.handler.inbound;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author mc
 * Create date 2019/11/10 10:16
 * Version 1.0
 * Description
 */
@Slf4j
public class Jt809ServerHandler extends ChannelInboundHandlerAdapter {

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		ByteBuf buf = (ByteBuf) msg;
		byte[] req = new byte[buf.readableBytes()];
		buf.readBytes(req);
		String body = new String(req, "utf-8");
		System.out.println("Server :" + body );
		String response = "进行返回给客户端的响应：" + body ;
		ctx.writeAndFlush(Unpooled.copiedBuffer(response.getBytes())).addListener(future -> {
			if (!future.isSuccess()) {
				log.error("发送失败", future.cause());
			}
		});
	}
	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.flush();
	}
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable t)	throws Exception {
		ctx.close();
	}
}
