package de.kosoft.examples.wiremock_example_001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {
        "de.kosoft.examples.wiremock_example_001.feign"
})
@EnableFeignClients
public class WiremockExample001Application {

    public static void main(String[] args) {
        SpringApplication.run(WiremockExample001Application.class, args);
    }

}
