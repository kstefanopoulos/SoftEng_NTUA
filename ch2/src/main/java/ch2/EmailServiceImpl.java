package ch2;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service 
public class EmailServiceImpl implements MailService{

	  private final JavaMailSender emailSender;
	
	   @Autowired
	    public EmailServiceImpl(JavaMailSender emailSender)  {
	        this.emailSender = emailSender;
	
	    }

	   public  void sendMail(MimeMessage message, MimeMessageHelper helper, String To, String Text, String Subject) throws MessagingException {

	      
	        helper.setTo(To);
	        helper.setText(Text);
	        helper.setSubject(Subject);
	        helper.setFrom("littlecherrie2@gmail.com");
	        emailSender.send(message);
	    }
	
}

