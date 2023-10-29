package com.zayar.mailsender.service;

public interface MailSenderService {
    void sendMail(String to , String subject , String message);
}
