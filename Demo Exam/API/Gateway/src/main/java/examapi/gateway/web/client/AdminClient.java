package examapi.gateway.web.client;

import examapi.gateway.configuration.Global;
import examapi.gateway.domain.comment.Comment;
import examapi.gateway.domain.post.Post;
import examapi.gateway.innerSecurity.ApiKey;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AdminClient {

    private final RestTemplate restTemplate;
    private final ApiKey apiKey;

    public AdminClient(RestTemplate restTemplate, ApiKey apiKey) {
        this.restTemplate = restTemplate;
        this.apiKey = apiKey;
    }

    public void addPostForApproval(Post post) {
      Post result =  this.restTemplate.postForObject(Global.Admin_Service_Url + "/posts/add/" +
                this.apiKey.getKey(), post, Post.class);
    }

    public void addCommentForApproval(Comment comment) {
        Comment result =  this.restTemplate.postForObject(Global.Admin_Service_Url + "/comments/add/" +
                this.apiKey.getKey(), comment, Comment.class);
    }

    public void approvePost(long postId) {
        this.restTemplate.put(Global.Admin_Service_Url + "/posts/approve/"
        + postId + "/" + this.apiKey.getKey(), Object.class);
    }

    public void approveComment(long commentId) {
        this.restTemplate.put(Global.Admin_Service_Url + "/comments/approve/"
                + commentId + "/" + this.apiKey.getKey(), Object.class);
    }
}
