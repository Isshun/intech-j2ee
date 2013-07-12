package org.intech;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import sun.misc.BASE64Decoder;

@Stateless
@LocalBean
public class MailerService {

    //@Asynchronous
    //public Future<String> sendMessage(String email) {
    public String sendMessage(String email, String subject, String body) throws UnsupportedEncodingException, IOException {
    	System.out.println(String.format("MailerService: send mail (%s %s %s)", email, subject, body));
    	
        String status;
        Logger logger = Logger.getLogger(this.getClass().getName());


        final String username = "alexis.lauper@gmail.com";
        final String password = new String((new BASE64Decoder()).decodeBuffer("cXphcGlvbGpr"));

        System.out.println(password);
        
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
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
            message.setFrom();
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(email, false));
            message.setSubject(subject);
            message.setHeader("X-Mailer", "JavaMail");
            DateFormat dateFormatter = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.SHORT);
            Date timeStamp = new Date();
//            String messageBody = "This is a test message from the async example "
//                    + "of the Java EE Tutorial. It was sent on "
//                    + dateFormatter.format(timeStamp)
//                    + ".";
            message.setText(body);
            message.setSentDate(timeStamp);
            Transport.send(message);
            status = "Sent";
            logger.log(Level.INFO, "Mail sent to {0}", email);
        } catch (MessagingException ex) {
            status = "Encountered an error";
            logger.severe("Error in sending message.");
            logger.severe(ex.getMessage() + " " + ex.getNextException().getMessage());
            logger.severe(ex.getCause().getMessage());
        }
        //return new AsyncResult<String>(status);
        
        return status;
    }
}
