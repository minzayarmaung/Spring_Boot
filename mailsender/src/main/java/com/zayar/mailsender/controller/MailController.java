package com.zayar.mailsender.controller;

import com.zayar.mailsender.resource.MailMessage;
import com.zayar.mailsender.service.MailSenderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {

    private final MailSenderService mailSenderService;

    public MailController(MailSenderService mailSenderService){
        this.mailSenderService = mailSenderService;
    }

    @PostMapping("/send-mail")
    public ResponseEntity sendMail(@RequestBody MailMessage mailMessage){
        this.mailSenderService.sendMail(mailMessage.getTo() , mailMessage.getSubject(), mailMessage.getMessage());
        return ResponseEntity.ok("Success !");
    }
}
