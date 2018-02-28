package ch2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.MultipartAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration(exclude={MultipartAutoConfiguration.class})
@SpringBootApplication
@ComponentScan() 
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
