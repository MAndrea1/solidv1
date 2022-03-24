package com.example.model;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import java.io.File;

class SendMailTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void sendMailWithEmtpyUserAndPasswordExceptionShouldBeCatched() {
        File file = new File("File");
        String user = "";
        String pass = "";
        SendMail.sendMail(file, user, pass);

        exception.expect(Exception.class);
    }

    @Test
    public void testSendMail() {
        File file = new File("File");
        String user = "";
        String pass = "";
        SendMail.sendMail(file, user, pass);
    }

}