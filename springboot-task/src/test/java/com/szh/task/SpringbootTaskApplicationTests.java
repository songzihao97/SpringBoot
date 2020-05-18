package com.szh.task;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class SpringbootTaskApplicationTests {

    @Autowired
    JavaMailSenderImpl javaMailSender;

    @Test
    void contextLoads() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject("java邮件测试");
        simpleMailMessage.setText("测试是否发送成功");
        simpleMailMessage.setTo("1198521193@qq.com");
        simpleMailMessage.setFrom("songzihao97@163.com");
        javaMailSender.send(simpleMailMessage);
    }

    @Test
    void sendMail() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);//multipart:是否文件上传
        helper.setText("<b style='color:red'>今天学习到11点<b>",true);
        helper.setSubject("测试");
        helper.setTo("1198521193@qq.com");
        helper.setFrom("songzihao97@163.com");
        helper.addAttachment("07.jpg", new File("D:\\下载\\文件\\07.jpg"));
        javaMailSender.send(mimeMessage);
    }
}
