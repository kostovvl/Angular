package examapi.gateway.innerSecurity;

import examapi.gateway.configuration.Global;
import examapi.gateway.domain.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SecurityClient {

    private final RestTemplate restTemplate;
    private final KeyGenerator keyGenerator;
    private final ApiKey apiKey;

    @Autowired
    public SecurityClient(RestTemplate restTemplate, KeyGenerator keyGenerator, ApiKey apiKey) {
        this.restTemplate = restTemplate;
        this.keyGenerator = keyGenerator;
        this.apiKey = apiKey;
    }

    public UserEntity findByUsername(String username) {
        return this.restTemplate.getForObject(Global.User_Service_Url + "login", UserEntity.class);
    }

    public void sendKeys() {
        this.keyGenerator.generateKey();
        this.restTemplate.postForObject(Global.User_Service_Url + "security", this.apiKey.getKey(), String.class);
    }
}
