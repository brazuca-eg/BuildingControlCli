package ua.nure.kravchenko.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan("ua.nure.kravchenko")
public class MyConfig {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
