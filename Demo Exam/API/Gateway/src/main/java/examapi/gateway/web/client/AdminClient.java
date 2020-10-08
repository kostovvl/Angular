package examapi.gateway.web.client;

import examapi.gateway.configuration.Global;
import examapi.gateway.domain.comment.Comment;
import examapi.gateway.domain.post.postadmin.PostAdmin;
import examapi.gateway.domain.post.postadmin.PostAdminContainer;
import examapi.gateway.domain.post.postuser.Post;
import examapi.gateway.innerSecurity.ApiKey;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

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

    public List<PostAdmin> allForApproval() {
        return this.restTemplate.getForObject(Global.Admin_Service_Url + "/posts/all/" + this.apiKey.getKey(),
                PostAdminContainer.class).getAll();
    }

    public void approvePost(long postId) {
        this.restTemplate.put(Global.Admin_Service_Url + "/posts/approve/"
        + postId + "/" + this.apiKey.getKey(), String.class);
    }

    public void approveComment(long commentId) {
        this.restTemplate.put(Global.Admin_Service_Url + "/comments/approve/"
                + commentId + "/" + this.apiKey.getKey(), String.class);
    }
}
