package com.mamba.popidea.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Component
@ConfigurationProperties(prefix = "spring.mail")
public class EmailTool {


    private String host;
    private String username;
    private String password;

    public void setHost(String host) {
        this.host = host;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSender(JavaMailSenderImpl sender) {
        this.sender = sender;
    }

    @Autowired
    private JavaMailSenderImpl sender;

    public void send(String text, String toEmail) {

        try {
            sender.setHost(host);
            sender.setUsername(username);
            sender.setPassword(password);

            Properties javaMailProperties = new Properties();
            javaMailProperties.put("mail.smtp.auth", true);
            javaMailProperties.put("mail.smtp.starttls.enable", true);
            javaMailProperties.put("mail.smtp.timeout", 5000);
            sender.setJavaMailProperties(javaMailProperties);


            MimeMessage message = sender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);
            helper.setFrom(username);
            helper.setTo(toEmail);
            helper.setText(text,true);
            helper.setSubject("欢迎注册PopIdea");
            sender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
