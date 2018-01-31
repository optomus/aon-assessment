package aon.iplatform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"aon.iplatform"})
public class InsurancePlatformApp {
    public static void main(String[] args) {
        SpringApplication.run(InsurancePlatformApp.class, args);
    }
}
