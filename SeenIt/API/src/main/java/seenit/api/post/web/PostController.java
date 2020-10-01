package seenit.api.post.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import seenit.api.post.domain.PostDto;
import seenit.api.post.service.PostService;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody() PostDto postDto, Principal principal) {

        PostDto responsePost = this.postService.createNewPost(postDto, principal.getName());

        return new ResponseEntity<>(responsePost, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PostDto>> getAllPosts() {
        return new ResponseEntity<>(this.postService.getAllPosts(), HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getAllByUser(@PathVariable(name = "userId") long userId, Principal principal) {
        try {
            return new ResponseEntity<>(this.postService.getAllByUser(userId, principal.getName()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/details/{postId}")
    public ResponseEntity<?> getDetails(@PathVariable(name = "postId") long postId) {
        try {
            return new ResponseEntity<>(this.postService.details(postId) ,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("edit/{postId}")
    public ResponseEntity<?> editPost(@PathVariable(name = "postId") long postId,
                                      @RequestBody() PostDto editedPost) {
        try {
            PostDto result = this.postService.editPost(postId, editedPost);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable(name = "postId") long postId, Principal principal) {
        try {
            this.postService.deletePost(postId, principal.getName());
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }
    }

}
