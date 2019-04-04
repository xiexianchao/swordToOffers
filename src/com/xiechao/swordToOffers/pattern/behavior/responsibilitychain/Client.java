package com.xiechao.swordToOffers.pattern.behavior.responsibilitychain;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @ClassName Client
 * @Author xiechao
 * @Date 2019/4/4
 * @Time 14:54
 * @Description TODO
 */
public class Client {
    public static void main(String[] args) throws IOException, ServletException {
        FilterChain chain = new MyFilterChain();
        chain.doFilter(null,null);
    }
}
