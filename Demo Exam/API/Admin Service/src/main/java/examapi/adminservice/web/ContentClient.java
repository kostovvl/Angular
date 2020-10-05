package examapi.adminservice.web;

import examapi.adminservice.innerSecurity.ApiKey;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ContentClient {

    private final static String approve_post_url = "http://localhost:8082/posts/approve/";
    private final static String approve_comment_url = "http://localhost:8082/comments/approve/";
    private final RestTemplate restTemplate;
    private final ApiKey apiKey;

    public ContentClient(RestTemplate restTemplate, ApiKey apiKey) {
        this.restTemplate = restTemplate;
        this.apiKey = apiKey;
    }

    public void approvePost(long postId) {
        this.restTemplate.put(approve_post_url + postId + this.apiKey.getKey(), Object.class);
    }

    public void approveComment(long commentId) {
        this.restTemplate.put(approve_comment_url + commentId + this.apiKey.getKey(), Object.class);
    }

}
