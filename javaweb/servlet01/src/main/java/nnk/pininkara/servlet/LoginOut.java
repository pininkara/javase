// 2022/2/9 10:30

package nnk.pininkara.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "logout", urlPatterns = "/logout")
public class LoginOut extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object session = req.getSession().getAttribute("USER_SESSION");
        if (session != null) {
            req.getSession().removeAttribute("USER_SESSION");
        }
        resp.sendRedirect("/ser01/index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
