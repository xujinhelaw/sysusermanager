package com.unity.authentication.manager.filter;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 自定义的过滤器，用于修改请求的content-type
 * 修改content-type是通过CustomHttpRequest中重写getContentType方法
 * 测试方法：post http://127.0.0.1:8088/xml/user content-type修改为application/x-www-form-urlencoded
 * 在过滤器中奖content-type修改为 application/xml
 * 在FilterConfig中奖filter注册到springboot,并定义拦截的url匹配规则
 */
@Order(1)
public class ModifyContentTypeFilter implements javax.servlet.Filter {
    CustomHttpRequest customHttpRequest;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        javax.servlet.Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        customHttpRequest = new CustomHttpRequest((HttpServletRequest) servletRequest);
        filterChain.doFilter(customHttpRequest, servletResponse);
    }

    @Override
    public void destroy() {
        javax.servlet.Filter.super.destroy();
    }
}
