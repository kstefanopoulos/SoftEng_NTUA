package ch2;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class AppConfig {

	    @Bean
	    public JavaMailSender getMailSender(){
	        
	    	 JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	         	         
	        //Using gmail
	        mailSender.setHost("smtp.gmail.com");
	        mailSender.setPort(465);
	        mailSender.setUsername("littlecherries2@gmail.com");
	        mailSender.setPassword("qapilndvtmbcshkc");
	         
	        Properties javaMailProperties = new Properties();
	        javaMailProperties.put("mail.smtp.starttls.enable", "true");
	        javaMailProperties.put("mail.smtp.auth", "true");
	        javaMailProperties.put("mail.transport.protocol", "smtps");
	        javaMailProperties.put("mail.debug", "true");//Prints out everything on screen
	         
	        mailSender.setJavaMailProperties(javaMailProperties);
	        return mailSender;
	    }
	
	
} 

