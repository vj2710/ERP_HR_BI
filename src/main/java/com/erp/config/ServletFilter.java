package com.erp.config;


import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ServletFilter implements Filter {
@Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException,ServletException{
    HttpServletResponse response = (HttpServletResponse) servletResponse;
    response.setHeader("Access-Control-Allow-Origin","*");
    response.setHeader("Access-Control-Allow-Origin", "POST, PUT, GET, OPTIONS, DELETE");
    response.setHeader("Access-Control-Allow-Origin","Authorization, Content-Type");
    response.setHeader("Access-Control-Allow-Origin","3600");
    filterChain.doFilter(servletRequest, servletResponse);

}
@Override
    public void destroy(){

}
@Override
    public void init(FilterConfig filterConfig) throws ServletException {}

}
