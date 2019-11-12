package com.ysy.jt809.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 主链路登陆请求
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpConnectReq {
    private int userId;
    private String password;
    private String downLinkIp;
    private int downLinkPort;
}
