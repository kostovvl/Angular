package examapi.gateway.web.controller;

import examapi.gateway.domain.post.Post;
import examapi.gateway.domain.post.PostContainer;
import examapi.gateway.web.client.PostClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostClient postClient;

    public PostController(PostClient postClient) {
        this.postClient = postClient;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Post post) {
        Post result = this.postClient.create(post);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/update/{postId}")
    public ResponseEntity<?> update(@PathVariable(name = "postId") long postId,
                                    @RequestBody() Post updatedPost) {
      this.postClient.update(postId, updatedPost);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?> all() {
        PostContainer allPosts = new PostContainer(this.postClient.all().getAll());
        return new ResponseEntity<>(allPosts.getAll(), HttpStatus.OK);
    }

    @GetMapping("/by_category/{categoryId}")
    public ResponseEntity<?> all(@PathVariable(name = "categoryId") long categoryId){
        PostContainer allForCategory= new PostContainer(this.postClient.allForCategory(categoryId).getAll());
        return new ResponseEntity<>(allForCategory.getAll(), HttpStatus.OK);
    }

    @GetMapping("/details/{postId}")
    public ResponseEntity<?> getById(@PathVariable(name = "postId") long postId){
        Post result = this.postClient.details(postId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{postId}")
    public ResponseEntity<?> delete(@PathVariable(name = "postId") long postId) {
        this.postClient.delete(postId);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}
