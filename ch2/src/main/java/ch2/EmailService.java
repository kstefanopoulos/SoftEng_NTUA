/* package ch2;

import java.io.File;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class EmailService implements MailService {
 
    @Autowired
    public  JavaMailSender mailSender;
     
    
    public void sendMail(String To, String Subject, String body)throws MailException{
    	
    
        
        SimpleMailMessage mail = new SimpleMailMessage() ; 
    	
        mail.setFrom("littlecherries2@gmail.com");
    	mail.setSubject(Subject);
    	mail.setTo(To);
    	mail.setText(body);
    	
    	mailSender.send(mail); 
    }  
}

*/ 

    