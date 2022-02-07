// 2022/2/7 15:32

package nnk.pininkara.cookie;

import nnk.pininkara.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "session1",urlPatterns = "/session1")
public class SessionDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("gbk");
        resp.setCharacterEncoding("gbk");
        resp.setContentType("text/html;charset=gbk");

        HttpSession session=req.getSession();//获得Session
        session.setAttribute("name","nnk");//在Session中存东西
        String id =session.getId();  //获得SessionID
        if (session.isNew()){
            resp.getWriter().write("Session创建成功，ID为："+id);
        }else {
            resp.getWriter().write("Session已经创建，ID为："+id);
        }
        System.out.println("有东西嘛?");
        Person person = new Person((String) session.getAttribute("name"));
        System.out.println(person);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
