package examapi.gateway.web.client;

import examapi.gateway.configuration.Global;
import examapi.gateway.domain.category.Category;
import examapi.gateway.innerSecurity.ApiKey;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CategoryClient {

    private final RestTemplate restTemplate;
    private final ApiKey apiKey;

    public CategoryClient(RestTemplate restTemplate, ApiKey apiKey) {
        this.restTemplate = restTemplate;
        this.apiKey = apiKey;
    }

    public Category createNew(Category category) {
        return this.restTemplate.postForObject(Global.Content_Service_Url + "/categories/create/" + this.apiKey.getKey(),
                category, Category.class);
    }

    public boolean update(long categoryId, Category updated) {
        try {
            this.restTemplate.put(Global.Content_Service_Url + "/categories/update/" + categoryId + "/" + this.apiKey.getKey(),
                    updated);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean delete(long categoryId) {
        try {
            this.restTemplate.delete(Global.Content_Service_Url + "/categories/" + categoryId + "/" + this.apiKey.getKey());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
