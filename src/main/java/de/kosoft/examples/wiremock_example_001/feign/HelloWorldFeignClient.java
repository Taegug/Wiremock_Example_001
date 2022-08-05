package de.kosoft.examples.wiremock_example_001.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "hello-world-client",url = "${helloworldservice.url}")
public interface HelloWorldFeignClient {

    @GetMapping("/greeting")
    String getGreeting();
}
