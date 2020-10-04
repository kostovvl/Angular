package examapi.contentservice.web;

import examapi.contentservice.domain.dto.CategoryDto;
import examapi.contentservice.innerSecurity.ApiKey;
import examapi.contentservice.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;
    private final ApiKey apiKey;

    public CategoryController(CategoryService categoryService, ApiKey apiKey) {
        this.categoryService = categoryService;
        this.apiKey = apiKey;
    }

    @PostMapping("/create/{apiKey}")
    public ResponseEntity<?> createCategory(@PathVariable(name = "apiKey") String apiKey
                                           ,@RequestBody CategoryDto categoryDto) {
        try {
            this.apiKey.checkKey(apiKey);
            return new ResponseEntity<>(this.categoryService.addCategory(categoryDto), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(categoryDto, HttpStatus.BAD_REQUEST);
        }

    }

}
