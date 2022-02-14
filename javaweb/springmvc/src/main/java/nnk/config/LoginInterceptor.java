// 2022/2/14 17:19

package nnk.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();
        if (request.getRequestURI().contains("login")){
            return true;
        }
        if (session.getAttribute("user")!= null) {
            return true;
        }
        request.getRequestDispatcher("/jsp/login.jsp").forward(request,response);
        return true;
    }
}
