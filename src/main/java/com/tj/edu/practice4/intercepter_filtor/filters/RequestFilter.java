package com.tj.edu.practice4.intercepter_filtor.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

    @WebFilter(urlPatterns = {"/api/*"})
    public class RequestFilter implements Filter {

        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("doFilter 시작 ------------");

        chain.doFilter(request, response);

        System.out.println("doFilter 끝 ------------");
    }
}
