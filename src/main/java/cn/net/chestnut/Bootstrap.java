package cn.net.chestnut;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication(scanBasePackages = {"cn"})
public class Bootstrap implements WebMvcConfigurer {

    public static void main(String... args) {
        SpringApplication.run(Bootstrap.class, args);
    }

}
