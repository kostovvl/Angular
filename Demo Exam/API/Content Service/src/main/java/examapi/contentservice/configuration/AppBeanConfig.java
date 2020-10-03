package examapi.contentservice.configuration;

import examapi.contentservice.innerSecurity.ApiKey;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppBeanConfig {

    @Bean
    public ApiKey apiKey() {
        return new ApiKey();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
