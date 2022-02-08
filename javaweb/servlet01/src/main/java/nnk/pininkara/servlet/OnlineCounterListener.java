// 2022/2/8 16:11

package nnk.pininkara.servlet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnlineCounterListener implements HttpSessionListener {
    //创建session监听，每当session被创建就触发
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext context=se.getSession().getServletContext();
        Integer onlineCount=(Integer) context.getAttribute("onlineCount");

        if (onlineCount == null) {
            onlineCount= 1;
        }else {
            int count= onlineCount;
            onlineCount=count+1;
        }

        context.setAttribute("onlineCount",onlineCount);
    }

    //每当session被销毁就触发
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext context=se.getSession().getServletContext();
        Integer onlineCount=(Integer) context.getAttribute("onlineCount");

        if (onlineCount == null) {
            onlineCount= 0;
        }else {
            int count= onlineCount;
            onlineCount=count-1;
        }

        context.setAttribute("onlineCount",onlineCount);
    }
}
