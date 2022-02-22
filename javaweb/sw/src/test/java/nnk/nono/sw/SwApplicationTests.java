package nnk.nono.sw;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@SpringBootTest
class SwApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;


    @Test
    void contextLoads() {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("捏捏卡永远滴神！");
        message.setText("捏捏卡什么的，最喜欢了");
        message.setTo("111@111.com");
        message.setFrom("111@111.com");
        mailSender.send(message);
    }

}
