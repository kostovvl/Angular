package examapi.gateway.web.controller;

import examapi.gateway.domain.category.Category;
import examapi.gateway.web.client.CategoryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryClient categoryClient;

    public CategoryController(CategoryClient categoryClient) {
        this.categoryClient = categoryClient;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createCategory(@RequestBody Category category) {

        try {
            Category response = this.categoryClient.createNew(category);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{categoryId}")
    public ResponseEntity<?> updateCategory(@PathVariable(name = "categoryId") long categoryId,
                                            @RequestBody Category category) {

        try {
            boolean response = this.categoryClient.update(categoryId ,category);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{categoryId}")
    public ResponseEntity<?> delete(@PathVariable(name = "categoryId") long categoryId) {
        boolean result = this.categoryClient.delete(categoryId);
        if (result) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
    }
}