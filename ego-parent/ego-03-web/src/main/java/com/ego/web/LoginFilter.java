package com.ego.web;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 0. 跨域
 * 0.1 一个Servlet容器（Tomcat）中项目，调用另一个Servlet容器（Tomcat）中项目，称之为：跨域。
 * 1. Ajax 在研发时，处于安全考虑，不允许跨域请求的。
 * 1.1 解决办法：使用JsonP。
 * 1.2 由访问自己的控制器，自己的Service，在自己的Service中使用HttpClient调用其它控制器的方法。
 * 2. Ajax 跨域数据请求发展由来。
 * 2.1 如果Ajax请求的控制器返回的就是字符串或者Json数据，不能访问。
 * 2.2 如果Ajax请求的访问另一个项目的JS文件，可以访问。
 * 2.3 使用Ajax访问另一个项目的控制器，但是控制器返回的结果伪装成JS文件。
 * 2.4 使用JsonP时服务端返回的数据格式：函数名(返回的数据)。
 *
 * 3. 设置跨域请求相关参数的过滤器。
 * 3.1 过滤器是一个对象，它对资源(servlet或静态内容)的请求或资源的响应执行过滤任务，或对两者执行过滤任务。
 *
 * @author liuweiwei
 * @since 2020-09-04
 */
@WebFilter(filterName = "LoginFilter", urlPatterns = "*.do")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response1 = (HttpServletResponse) response;
        response1.setHeader("Access-Control-Allow-Origin", "*");
        response1.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
        response1.setHeader("Access-Control-Max-Age", "3600");
        response1.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, client_id, uuid, Authorization");
        response1.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response1.setHeader("Pragma", "no-cache");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
