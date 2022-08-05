package de.kosoft.examples.wiremock_example_001.feign;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@EnableConfigurationProperties
public class HelloWorldFeignClientTest {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(options().port(9500));

    @Autowired
    private HelloWorldFeignClient helloWorldFeignClient;

    @org.junit.Before
    public void setUp() {
        stubFor(get("/greeting").willReturn(aResponse().withBody("Hello User").withStatus(200)));
    }

    @org.junit.Test
    public void getGreeting() {
        assertEquals("Hello User", helloWorldFeignClient.getGreeting());
    }
}