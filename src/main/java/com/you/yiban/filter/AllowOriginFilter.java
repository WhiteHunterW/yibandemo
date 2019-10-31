package com.you.yiban.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.apache.commons.lang3.StringUtils;

/**
 * @author w.z
 * @date 2019/8/13 15:25
 */
public class AllowOriginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String origin = request.getHeader("Origin");
        if (StringUtils.isNotBlank(origin)) {
            //设置响应头，允许跨域访问
            //带cookie请求时，必须为全匹配，不能使用*
            /**
             * 表示允许 origin 发起跨域请求。
             */
            response.addHeader("Access-Control-Allow-Origin", "*");
        }

        /**
         * GET,POST,OPTIONS，PUT,DELETE 表示允许跨域请求的方法
         */
        response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS, PUT, DELETE");

        /**
         * 表示在86400秒内不需要再发送预校验请求
         */
        response.addHeader("Access-Control-Max-Age", "86400");

        //支持所有自定义头
        String headers = request.getHeader("Access-Control-Request-Headers");
        if (StringUtils.isNotBlank(headers)) {
            //允许JSON请求，并进行预检命令缓存
            response.addHeader("Access-Control-Allow-Headers", headers);
        }

        response.addHeader("Access-Control-Max-Age", "3600");

        //允许cookie
        response.addHeader("Access-Control-Allow-Credentials", "true");
        filterChain.doFilter(servletRequest, response);
    }
}
