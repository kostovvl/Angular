package examapi.contentservice.web;

import examapi.contentservice.domain.dto.CommentDto;
import examapi.contentservice.domain.entity.AllCommentsDto;
import examapi.contentservice.innerSecurity.ApiKey;
import examapi.contentservice.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;
    private final ApiKey apiKey;

    public CommentController(CommentService commentService, ApiKey apiKey) {
        this.commentService = commentService;
        this.apiKey = apiKey;
    }

    @PostMapping("/create/{apiKey}")
    public ResponseEntity<?> createNew(@PathVariable(name = "apiKey") String apiKey,
                                       @RequestBody CommentDto commentDto) {
        this.apiKey.checkKey(apiKey);
        CommentDto result = this.commentService.createComment(commentDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/update/{commentId}/{apiKey}")
    public ResponseEntity<?> update(@PathVariable(name = "commentId") long commentId,
                                    @PathVariable(name = "apiKey") String apiKey,
                                    @RequestBody CommentDto updated) {
        this.apiKey.checkKey(apiKey);
        CommentDto result = this.commentService.updateComment(commentId, updated);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/approve/{commentId}/{apiKey}")
    public ResponseEntity<?> approve(@PathVariable(name = "commentId") long commentId,
                                     @PathVariable(name = "apiKey") String apiKey) {
        this.apiKey.checkKey(apiKey);
        this.commentService.approveComment(commentId);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @GetMapping("/getForPost/{postId}/{apiKey}")
    public ResponseEntity<?> getForPost (@PathVariable(name = "postId") long postId,
                                       @PathVariable(name = "apiKey") String apiKey) {
        this.apiKey.checkKey(apiKey);
        AllCommentsDto result = new AllCommentsDto(this.commentService.getByPost(postId));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{commentId}/{apiKey}")
    public ResponseEntity<?> delete(@PathVariable(name = "commentId") long commentId,
                                    @PathVariable(name = "apiKey") String apiKey) {
        this.apiKey.checkKey(apiKey);
        this.commentService.delete(commentId);

        return new ResponseEntity<>(true, HttpStatus.OK);
    }


}
