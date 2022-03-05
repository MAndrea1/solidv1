package com.example.utilidades;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Properties;

public class SendMail {
    private static String username;
    private static String password;
    private Properties properties;
    private Session session;

    public static void sendMail(File file, String user, String pass) throws MessagingException, IOException {
        username = user;
        password = pass;
        SendMail sendMail = new SendMail();
        sendMail.configureProperties();
        sendMail.configureSession();
        sendMail.createMimeMessage(file);
    }

    private void configureProperties() {
        properties = new Properties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.mailtrap.io");
        properties.put("mail.smtp.port", "25");
        properties.put("mail.smtp.ssl.trust", "smtp.mailtrap.io");
    }

    private void configureSession() {
        session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
    }

    private void createMimeMessage(File file) throws MessagingException, IOException {
        MimeMessage mimeMessage = new MimeMessage(session);
        mimeMessage.setFrom(new InternetAddress("reports@thestore.com"));
        mimeMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse("usermail@gmail.com"));
        mimeMessage.setSubject("Inventory report");

        LocalDateTime myObj = LocalDateTime.now();
        String bodyMessage = "Inventory report - required on " + myObj;

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(bodyMessage, "text/html");

        MimeBodyPart attatchment = new MimeBodyPart();
        attatchment.attachFile(file);

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);
        multipart.addBodyPart(attatchment);

        mimeMessage.setContent(multipart);
        Transport.send(mimeMessage);
        System.out.println("Email sent");
    }


}
