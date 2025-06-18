package com.codegym.service;

import com.codegym.model.Mail;

public class MailService {
    private static final Mail mail = new Mail();

    public static Mail get(){
        return mail;
    }

    public static Mail save(Mail mail){
        return mail;
    }
}
