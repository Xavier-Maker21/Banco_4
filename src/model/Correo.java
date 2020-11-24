/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Javier
 */
public class Correo {

    private final static String CORREOB = "bancofunao@gmail.com";
    private final static String CLAVE = "Funa1234";
    private final static String HOST = "smtp.gmail.com";

    //private String correoUsuario, correoDestino, mensaje, clave;
    private Properties properties = System.getProperties();

    private Session session;

    public Correo() {

        properties.put("mail.smtp.host", HOST);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(CORREOB, CLAVE);
            }
        });
        session.setDebug(true);
    }

    public boolean enviarCorreo(String destino, String titulo, String texto) {
        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);
            // Set From: header field of the header.
            message.setFrom(new InternetAddress(CORREOB));
            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destino));
            // Set Subject: header field
            message.setSubject(titulo);
            // Now set the actual message
            message.setText(texto);

            Transport.send(message);
            return true;
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
        return false;
    }
}
