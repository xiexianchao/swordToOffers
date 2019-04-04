package com.xiechao.swordToOffers.pattern.behavior.responsibilitychain;

import javax.servlet.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MyFilterChain
 * @Author xiechao
 * @Date 2019/4/4
 * @Time 14:46
 * @Description TODO
 */
public class MyFilterChain implements FilterChain {
    private List<Filter> filterList = new ArrayList<>();
    private int index = 0;

    public MyFilterChain(){
        init();
    }
    public MyFilterChain init(){
        filterList.add(new FirstFilter());
        filterList.add(new SecondFilter());
        filterList.add(new ThirdFilter());
        index = 0;
        return this;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException, ServletException {
        if( filterList.size() > index){
            filterList.get(index ++ ).doFilter(servletRequest, servletResponse,this);
        }
    }
}
