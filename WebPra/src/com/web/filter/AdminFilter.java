package com.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Mr.wxx
 * @since 2021-04-08-9:04
 **/
@WebFilter(filterName = "AdminFilter", urlPatterns = "/admin/file.html")
public class AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("AdminFilter初始化");
    }

    /**
     * 拦截请求
     *
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 获取SESSION
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //之前在Servlet中将用户登录信息设置在Session域中
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        //如果user为null，表示还没有登录
        if(user == null){
            //跳转到登录界面
            servletRequest.getRequestDispatcher("/html/login.html").forward(servletRequest,servletResponse);
        }else{
            //可以继续访问资源
            filterChain.doFilter(servletRequest,servletResponse);
            //去除掉user参数，即去除登录信息
//            session.removeAttribute("user");
        }
    }

    @Override
    public void destroy() {
        System.out.println("Filter销毁");
    }
}
