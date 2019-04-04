package com.xiechao.swordToOffers.pattern.behavior.responsibilitychain;

import javax.servlet.*;
import java.io.IOException;

/**
 * @ClassName ThirdFilter
 * @Author xiechao
 * @Date 2019/4/4
 * @Time 14:51
 * @Description TODO
 */
public class ThirdFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("ThirdFilter 初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("ThirdFilter doFilter 执行了");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("ThirdFilter doFilter 执行结束了");
    }

    @Override
    public void destroy() {
        System.out.println("ThirdFilter destory");
    }
}
