package com.bpf;

import org.junit.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class GetIconTest {

    @Test
    public void test() throws MalformedURLException {
        URL url = new URL("http://www.blogjava.net/liuguly/archive/2017/11/14/432891.html");

        url = new URL("http://localhost:9095/user/login?name=admin&password=12");
        // 协议 http
        System.out.println(url.getProtocol());
        // 主机
        System.out.println(url.getHost());
        // URI
        System.out.println(url.getPath());
        // 主机:端口
        System.out.println(url.getAuthority());

        String ip = url.getProtocol() + "://" + url.getAuthority();
        System.out.println(ip);

        url = new URL(ip + "/favicon.ico");
    }
}
