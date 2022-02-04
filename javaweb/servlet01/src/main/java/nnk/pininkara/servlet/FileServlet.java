// 2022/2/4 16:14

package nnk.pininkara.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet(name = "file", urlPatterns = "/file")
public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取下载文件的路径
        String path = "E:\\Picture\\2b6b77c563c74689c63e6954940e8f01_1_1_art.png";
        //2.下载文件的文件名
        String name = path.substring(path.indexOf("\\") + 1);
        //3.让浏览器支持下载
        resp.setHeader("Content-Disposition", "attachment;filename=" + name);
        //4.获取下载文件的输入流
        FileInputStream fileInputStream = new FileInputStream(path);
        //5.创建缓冲区
        int len;
        byte[] buffer = new byte[1024];
        //6.获取OutputStream对象
        ServletOutputStream out = resp.getOutputStream();
        //7.将FileOutputStream流写入buffer缓冲区
        while ((len = fileInputStream.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }
        //8.关闭流
        fileInputStream.close();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
