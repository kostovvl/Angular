package movies.api.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppBeanConfig {

    @Bean
    public ModelMapper mapper() {
        return new ModelMapper();
    }

    @Bean
    public RestTemplate restTemplate() {
        return  new RestTemplate();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/popular").allowedOrigins("http://localhost:4200");
                registry.addMapping("/top_rated").allowedOrigins("http://localhost:4200");
                registry.addMapping("/now_playing").allowedOrigins("http://localhost:4200");
                registry.addMapping("/upcoming").allowedOrigins("http://localhost:4200");
                registry.addMapping("/details/*").allowedOrigins("http://localhost:4200");
            }
        };
    }

}
