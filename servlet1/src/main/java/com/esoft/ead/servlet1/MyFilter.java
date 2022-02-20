package com.esoft.ead.servlet1;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyFilter doFilter() is invoked.");
        Enumeration<String> params = servletRequest.getParameterNames();
        while (params.hasMoreElements()) {
            String param=params.nextElement();
            System.out.println("Parameter:"+param+"Value:"+servletRequest.getParameter(param));
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
