package examapi.gateway.web.controller;

import examapi.gateway.domain.category.Category;
import examapi.gateway.web.client.AdminClient;
import examapi.gateway.web.client.CategoryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminClient adminClient;
    private final CategoryClient categoryClient;

    public AdminController(AdminClient adminClient, CategoryClient categoryClient) {
        this.adminClient = adminClient;
        this.categoryClient = categoryClient;
    }

    @PostMapping("/category/create")
    public ResponseEntity<?> createCategory(@RequestBody Category category) {

        try {
            Category response = this.categoryClient.createNew(category);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
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