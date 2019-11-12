package com.ysy.jt809.handler;

import com.ysy.jt809.bean.Message;
import com.ysy.jt809.constants.JT809DataTypeConstants;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 主链路链接保持处理
 *
 */
@Slf4j
@Component
public class UpLinkTestHandler implements CommonHandler{

    @Override
    public void handler(ChannelHandlerContext ctx, Message msg) {
        log.info("接收到心跳包");
        msg.getMsgHead().setMsgId((short) JT809DataTypeConstants.UP_LINKTEST_RSP);
        ctx.write(msg);
    }
}