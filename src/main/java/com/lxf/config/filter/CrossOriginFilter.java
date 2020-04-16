package com.lxf.config.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 跨域过滤器
 * springboot解决跨域，可以直接加注解@CrossOrigin,底层实现和手写程序一样
 */
//@Component 不要加，否则将过滤所有路径
@WebFilter(urlPatterns = {"/test/*"})
public class CrossOriginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("跨域Filter初始化");
    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("跨域Filter doFilter()");
        HttpServletResponse httpServletResponse = (HttpServletResponse)response;
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.addHeader("Access-Control-Allow-Credentials", "true");
        httpServletResponse.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
        httpServletResponse.addHeader("Access-Control-Allow-Headers", "Content-Type,X-CAF-Authorization-Token,sessionToken,X-TOKEN");
        System.out.println(((HttpServletRequest) request).getMethod());//GET
        if (((HttpServletRequest) request).getMethod().equals("OPTIONS")) {//预请求，跨域时，第一次试探服务器响应
            response.getWriter().println("ok");
            return;
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("跨域Filter销毁");
    }

}
