package au.com.aon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"au.com.aon"})
public class InsurancePlatformApp {
    public static void main(String[] args) {
        SpringApplication.run(InsurancePlatformApp.class, args);
    }
}
