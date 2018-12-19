package util;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class MailUtilGmail {
    public static void sendMail(String to, String from, String subject, String body, boolean bodyIsHTML)
    throws MessagingException{
        Properties props = new Properties();
        props.put("mail.transport.protocol", "smtps");//giao thuc thu 1
        props.put("mail.smtps.host", "smtp.gmail.com");
        props.put("mail.smtps.port", 465);
        props.put("mail.smtps.auth", "true");
        props.put("mail.smtps.quitwait", "false");
        
        Session session = Session.getDefaultInstance(props);
        
        //2.Create message
        Message message = new MimeMessage(session);
        message.setSubject(subject);
        
        if(bodyIsHTML){
            message.setContent(body,"text/html");
        }else{
            message.setText(body);
        }
        
        //3.Aside Address
        Address fromAddress = new InternetAddress(from);
        Address toAddress = new InternetAddress(to);
        message.setFrom(fromAddress);
        message.setRecipient(Message.RecipientType.TO, toAddress);
        
        //4. send the mail
        Transport transport = session.getTransport();
        transport.connect("ductest12@gmail.com","aimabiethaban");
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }
}
