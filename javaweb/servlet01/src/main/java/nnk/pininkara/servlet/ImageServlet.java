// 2022/2/4 17:22

package nnk.pininkara.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "image", urlPatterns = "/image")
public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //让浏览器5秒刷新一次
        resp.setHeader("refresh","5");
        //在内存中创建一个图片
        BufferedImage image = new BufferedImage(80,20,BufferedImage.TYPE_INT_RGB);
        //得到图片
        Graphics2D graphics2D = (Graphics2D) image.getGraphics();//画笔
        //设置图片的背景颜色
        graphics2D.setColor(Color.white);
        graphics2D.fillRect(0,0,80,20);
        //给图片写数据
        graphics2D.setColor(Color.blue);
        graphics2D.setFont(new Font(null,Font.BOLD,20));
        graphics2D.drawString(makeRan(),0,20);
        //告诉浏览器，这个请求用图片的方式打开
        resp.setContentType("image/jpeg");
        //让浏览器不缓存
        resp.setDateHeader("expires",-1);
        resp.setHeader("Cache-Control","no-cache");
        resp.setHeader("Pragma","no-cache");
        //把图片写给浏览器
        boolean write = ImageIO.write(image, "jpg", resp.getOutputStream());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    /**
     * 生成随机数
     * @return 随机数
     */
    private String makeRan(){
        Random random=new Random();
        String s = random.nextInt(99999999) + "";
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 7 - s.length(); i++) {
            stringBuffer.append("0");
        }
        String s1 = stringBuffer.toString() + s;
        return s1;
    }
}
