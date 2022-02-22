package nnk.nono.sw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableAsync
@EnableScheduling
public class SwApplication {
    public static void main(String[] args) {
        SpringApplication.run(SwApplication.class, args);
    }

}
