// 2022/2/7 13:54

package nnk.pininkara.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;


@WebServlet(name = "cookie1",urlPatterns = "/cookie1")
public class CookieDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("gbk");
        resp.setCharacterEncoding("gbk");

        PrintWriter out= resp.getWriter();

        Cookie[] cookies=req.getCookies();
        if (cookies != null) {
            out.write("上次访问时间为: ");
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("time")){
                    long lastTime =Long.parseLong(cookie.getValue());
                    Date date=new Date(lastTime);
                    out.write(date.toLocaleString());
                }
            }
        }else {
            out.println("第一次来捏");
        }

        Cookie cookie=new Cookie("time",System.currentTimeMillis()+"");
        cookie.setMaxAge(24*60*60);
        resp.addCookie(cookie);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
