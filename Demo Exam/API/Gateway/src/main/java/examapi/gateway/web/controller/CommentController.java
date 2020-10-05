package examapi.gateway.web.controller;

import examapi.gateway.domain.comment.Comment;
import examapi.gateway.domain.comment.CommentContainer;
import examapi.gateway.web.client.CommentClient;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/comments")
public class CommentController {

    private final CommentClient commentClient;

    public CommentController(CommentClient commentClient) {
        this.commentClient = commentClient;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Comment comment) {
        Comment result = this.commentClient.create(comment);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/getForPost/{postId}")
    public ResponseEntity<?> getForPost(@PathVariable(name = "postId") long postId) {
        CommentContainer result = new CommentContainer(this.commentClient.getForPost(postId).getAll());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/update/{commentId}")
    public ResponseEntity<?> update(@PathVariable(name = "commentId") long commentId,
                                    @RequestBody() Comment comment) {
        this.commentClient.update(commentId, comment);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{commentId}")
    public ResponseEntity<?> delete(@PathVariable(name = "commentId") long commentId) {
        this.commentClient.delete(commentId);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}
