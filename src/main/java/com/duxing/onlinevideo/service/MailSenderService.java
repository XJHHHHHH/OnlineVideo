package com.duxing.onlinevideo.service;

public interface MailSenderService {
    void sendHtmlEmail(String to,String subject,String context);
}
