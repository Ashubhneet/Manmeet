package com.demo.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class EmailService {
    @Autowired
    JavaMailSender javaMailSender;
//    private final String basePath="http:\\localhost:8080\";

        public void sendMail(String receiver,String token,String usertype){
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom("manmeet.kaur1@tothenew.com");
            simpleMailMessage.setTo(receiver);
            simpleMailMessage.setSubject("Email Activation");
            if(usertype.equals("customer"))
            simpleMailMessage.setText("Your account is registered please activate the account by " +
                    "clicking below link:http://localhost:8080/auth/customer/activation?token=" +token);
            else
                simpleMailMessage.setText("Your account is registered please activate the account by " +
                        "clicking below link:http://localhost:8080/supplier/register "+token);
            javaMailSender.send(simpleMailMessage);

        }
    }



