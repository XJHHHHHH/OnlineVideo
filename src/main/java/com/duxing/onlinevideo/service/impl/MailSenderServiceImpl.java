package com.duxing.onlinevideo.service.impl;

import com.duxing.onlinevideo.service.MailSenderService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
@Service
public class MailSenderServiceImpl implements MailSenderService {


    @Autowired
    private JavaMailSender javaMailSender;

    // 密码找回
    // 指定用户email 根据email找回
    // 生成token的参数
    // email + 时间(时间戳) + 服务器秘钥（123！@#随机生成） md5 = token
    // url?token=xxx&email=xx&t=xxx


    @Value("${mail.fromAddress}")
    private String from;


    @Override
    public void sendHtmlEmail(String to, String subject, String context){
        //利用javaMailSender创建一个邮件对象
        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            //找小弟 MimeMessageHelper 发送这个邮件
            MimeMessageHelper messageHelper = new MimeMessageHelper(message);
            //从哪里发送
            messageHelper.setFrom(from);
            //发送给谁
            messageHelper.setTo(to);
            //邮件主题
            messageHelper.setSubject(subject);
            //邮件内容
            messageHelper.setText(context);
            //发送邮件
            javaMailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
