package examapi.gateway.web.controller;

import examapi.gateway.domain.comment.Comment;
import examapi.gateway.web.client.CommentClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
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

    @PutMapping("/update/{commentId}")
    public ResponseEntity<?> update(@PathVariable(name = "commentId") long commentId,
                                    @RequestBody() Comment comment) {
        Comment result = this.commentClient.update(commentId, comment);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/approve/{commentId}")
    public ResponseEntity<?> approve(@PathVariable(name = "commentId") long commentId) {
        this.commentClient.approve(commentId);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{commentId}")
    public ResponseEntity<?> delete(@PathVariable(name = "commentId") long commentId) {
        this.commentClient.delete(commentId);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}
