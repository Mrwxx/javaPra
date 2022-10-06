package com.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Mr.wxx
 * @create 2021-06-25-20:39
 **/
@WebFilter(filterName = "wxFilter", urlPatterns = "/admin")
public class WxFilter implements Filter {
    public void destroy() {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //从req中获取session
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();
        String user = (String)session.getAttribute("user");
        if(user.equals("wx")){
            chain.doFilter(req, resp);
        }else{
            resp.getWriter().write("你不是wx用户，无法访问");
        }
    }

    public void init(FilterConfig config) throws ServletException {
        ServletContext servletContext = config.getServletContext();
        System.out.println("WxFilter初始化");
    }

}
