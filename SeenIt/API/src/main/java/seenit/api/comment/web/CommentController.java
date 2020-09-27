package seenit.api.comment.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import seenit.api.comment.domain.CommentDto;
import seenit.api.comment.service.CommentService;
import seenit.api.post.domain.PostDto;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createComment(@RequestBody() CommentDto commentDto, Principal principal) {
        try {
            return new ResponseEntity<>(this.commentService.createNew(commentDto, principal.getName()),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<?> getAllByPost(@PathVariable(name = "postId") long postId) {
        try {
            return new ResponseEntity<>(this.commentService.getAllByPost(postId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getAllByUser(@PathVariable(name = "userId") long userId, Principal principal) {
        try {
            return new ResponseEntity<>(this.commentService.getAllByUser(userId, principal.getName()), HttpStatus.OK);
        } catch (UnsupportedOperationException e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable(name = "commentId") long commentId, Principal principal) {
        try {
            this.commentService.delete(commentId, principal.getName());
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (UnsupportedOperationException e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
