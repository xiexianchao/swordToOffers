package com.xiechao.swordToOffers.pattern.behavior.responsibilitychain;

import javax.servlet.*;
import java.io.IOException;

/**
 * @ClassName SecondFilter
 * @Author xiechao
 * @Date 2019/4/4
 * @Time 14:49
 * @Description TODO
 */
public class SecondFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("SecondFilter 初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("SecondFilter doFilter 执行了");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("SecondFilter doFilter 执行结束了");
    }

    @Override
    public void destroy() {
        System.out.println("SecondFilter destory");
    }
}
