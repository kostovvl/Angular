package examapi.gateway.web.controller;

import examapi.gateway.web.client.AdminClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminClient adminClient;

    public AdminController(AdminClient adminClient) {
        this.adminClient = adminClient;
    }

    @PutMapping("/approve/post/{postId}")
    public ResponseEntity<?> approvePost(@PathVariable(name = "postId") long postId) {
        this.adminClient.approvePost(postId);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }


    @PutMapping("/approve/comment/{commentId}")
    public ResponseEntity<?> approveComment(@PathVariable(name = "commentId") long commentId) {
        this.adminClient.approveComment(commentId);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }


}
