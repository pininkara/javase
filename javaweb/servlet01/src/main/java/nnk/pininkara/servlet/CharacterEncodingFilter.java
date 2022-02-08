// 2022/2/8 15:37

package nnk.pininkara.servlet;

import javax.servlet.*;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("CharacterEncodingFilter正在初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.setCharacterEncoding("utf-8");
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=utf-8");
        System.out.println("执行前");
        filterChain.doFilter(servletRequest,servletResponse);//调用下一个Filter，不写则到此为止
        System.out.println("执行后");
    }

    @Override
    public void destroy() {
        System.out.println("CharacterEncodingFilter正在销毁");
    }
}
