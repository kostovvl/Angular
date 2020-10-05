package examapi.adminservice.web;

import examapi.adminservice.domain.Post;
import examapi.adminservice.innerSecurity.ApiKey;
import examapi.adminservice.service.PostService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final ApiKey apiKey;
    private final PostService postService;
    private final ContentClient contentClient;

    public PostController(ApiKey apiKey, PostService postService, ContentClient contentClient) {
        this.apiKey = apiKey;
        this.postService = postService;
        this.contentClient = contentClient;
    }

    @PostMapping("/add/{apiKey}")
    public void add(@PathVariable(name = "apiKey") String apiKey,
                    @RequestBody Post post) {
        this.apiKey.checkKey(apiKey);
        this.postService.add(post);
    }

    @PutMapping("/approve/{postId}/{apiKey}")
    public void approve(@PathVariable(name = "postId") long postId,
                        @PathVariable(name = "apiKey") String apiKey) {
        this.apiKey.checkKey(apiKey);
        this.contentClient.approvePost(postId);
        this.postService.delete(postId);
    }

}
