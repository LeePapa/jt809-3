package com.ysy.jt809.handler;

import com.ysy.jt809.bean.Message;
import io.netty.channel.ChannelHandlerContext;

/**
 * 逻辑处理
 *
 */
public interface CommonHandler {

    void handler(ChannelHandlerContext ctx, Message msg);
}
