package examapi.contentservice.service;

import examapi.contentservice.domain.dto.CategoryDto;
import examapi.contentservice.domain.entity.Category;
import examapi.contentservice.repository.CategoryRepository;
import examapi.contentservice.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final PostRepository postRepository;
    private final ModelMapper mapper;

    public CategoryService(CategoryRepository categoryRepository, PostRepository postRepository,
                           ModelMapper mapper) {
        this.categoryRepository = categoryRepository;
        this.postRepository = postRepository;
        this.mapper = mapper;
    }

    public CategoryDto addCategory(CategoryDto newCategory) {
        Category category = this.mapper.map(newCategory, Category.class);
        this.categoryRepository.saveAndFlush(category);

        return newCategory;
    }

    public void updateCategory(long categoryId, CategoryDto updatedCategory) {
        Category category = this.categoryRepository.getOne(categoryId);

        category.setName(updatedCategory.getName());
        this.categoryRepository.saveAndFlush(category);

    }

    public void deleteCategory(long categoryId) {

        //TODO when deleting I have to start from the comments, beacuse deleting category means deleting all posts and all comments

    }
}
