// 2022/2/9 15:29

package nnk.mail;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailTest {
    public static void main(String[] args) throws Exception {
        Properties pro = new Properties();
        pro.setProperty("mail.host", "smtp.office365.com");
        pro.setProperty("mail.transport.protocol", "smtp");
        pro.setProperty("mail.smtp.auth", "true");

        //设置SSL加密
        MailSSLSocketFactory sslSocketFactory = new MailSSLSocketFactory();
        sslSocketFactory.setTrustAllHosts(true);
        pro.put("mail.smtp.ssl.enable", "true");
        pro.put("mail.smtp.socketFactory.class", "com.sun.mail.util.MailSSLSocketFactory");
        pro.put("mail.smtp.ssl.socketFactory", sslSocketFactory);

        //1.创建Session对象
        Session session = Session.getDefaultInstance(pro, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("111@111.com", "aquhcsj");
            }
        });

        session.setDebug(true);

        //2.通过Session得到transport对象
        Transport transport = session.getTransport();
        //3.连接服务器
        transport.connect("smtp.exmail.qq.com", "111@111.com", "aquhcsj");
        //4.创建邮件
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("ILoveYou@insight.com"));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("111@222.com"));
        message.setSubject("I love you nnk");
        message.setContent("<h1 style='color=red'>你好世界</h1>", "text/html;charset=utf-8");
        //5.发送邮件
        transport.sendMessage(message, message.getAllRecipients());
        //6.关闭连接
        transport.close();
    }
}
