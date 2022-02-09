// 2022/2/9 14:23

package nnk.servlet;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet(name = "file", urlPatterns = "/file")
public class FileServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //判断是否为携带文件的表单
        if (!ServletFileUpload.isMultipartContent(req)) {
            return;//普通表单
        }
        //创建路径，保存在WEB-INF目录下
        String path = this.getServletContext().getRealPath("/WEB-INF/upload");
        File file = new File(path);
        if (!file.exists()) {
            file.mkdir();
        }
        //缓存，临时文件
        String tmpPath = this.getServletContext().getRealPath("/WEB-INF/tmp");
        File tmpFile = new File(path);
        if (!file.exists()) {
            file.mkdir();
        }

        //通过流

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }


}
