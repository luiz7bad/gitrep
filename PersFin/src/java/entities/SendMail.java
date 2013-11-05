/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.media.j3d.Behavior;

/**
 *
 * @author luiz
 */
public class SendMail{
    
     public SendMail() { }
        
     public static void mail(){   
     final String username = "aguiar.jln@gmail.com";
        final String password = "##25firejl07##";

        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
          });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("aguiar.jln@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse("luiz.aguiar@hotmail.co.uk"));
            message.setSubject("Alerta de vencimento");
            message.setText("Prezado Luiz,"
                + "\n\n sua conta de tipo + valor + vencera dia + dataVencimento!");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        
        }
    }
      

   
}
