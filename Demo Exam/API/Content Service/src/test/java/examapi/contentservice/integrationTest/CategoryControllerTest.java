package examapi.contentservice.integrationTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import examapi.contentservice.domain.dto.AllCategories;
import examapi.contentservice.domain.dto.CategoryDto;
import examapi.contentservice.domain.entity.Category;
import examapi.contentservice.innerSecurity.ApiKey;
import examapi.contentservice.repository.CategoryRepository;
import examapi.contentservice.service.CategoryService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ApiKey apiKey;

    @Autowired
    private ObjectMapper objectMapper;

    private final String apiPass = "123456";

    @BeforeEach
    public void setUp() {
        this.categoryRepository.deleteAll();
        this.apiKey.setKey(apiPass);
    }

    @Test
    public void should_Add_Entity() throws Exception {
        //arrange
        CategoryDto category = new CategoryDto();
        category.setId(1);
        category.setName("Category 1");

        //act
        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders
                .post("/categories/create/" + apiPass)
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(category))
                .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andReturn();
        CategoryDto result1 = this.objectMapper.readValue(result.getResponse().getContentAsString(),
                CategoryDto.class);

        //assert
        Assertions.assertEquals(category.getId(), result1.getId());
        Assertions.assertEquals(category.getName(), result1.getName());
    }

    @Test
    public void should_Return_All() throws Exception {
        //arrange
        CategoryDto category1 = new CategoryDto();
        category1.setId(1);
        category1.setName("Category 1");

        CategoryDto category2 = new CategoryDto();
        category2.setId(2);
        category2.setName("Category 2");

         this.mockMvc.perform(MockMvcRequestBuilders
                .post("/categories/create/" + apiPass)
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(category1))
                .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andReturn();

        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/categories/create/" + apiPass)
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(category2))
                .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andReturn();

        //act
        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders
                .get("/categories/all/" + apiPass)
        ).andExpect(status().isOk()).andReturn();
        AllCategories result1 = this.objectMapper.readValue(result.getResponse().getContentAsString(),
                AllCategories.class);

        //assert
        Assertions.assertEquals(2, result1.getAll().size());
    }

    @Test
    public void should_Update_Category() throws Exception {
        //arrange
        CategoryDto original = new CategoryDto();
        original.setId(1);
        original.setName("Category 1");

        CategoryDto updated = new CategoryDto();
        updated.setName("Category 2");

        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/categories/create/" + apiPass)
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(original))
                .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andReturn();

        //act
        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/categories/update/" + original.getId() + "/" + apiPass)
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(updated))
                .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
        Category result = this.categoryRepository.findById((long)1).orElse(null);

        //assert
        Assertions.assertEquals(updated.getName(), result.getName());
    }

    @Test
    public void should_Delete() throws Exception {
        //arrange
        CategoryDto category = new CategoryDto();
        category.setId(1);
        category.setName("Category");

        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/categories/create/" + apiPass)
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(category))
                .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andReturn();

        //act
        this.mockMvc.perform(MockMvcRequestBuilders
                .delete("/categories/delete/" + category.getId() + "/" + apiPass)
        ).andExpect(status().isOk());

        //assert
        Assertions.assertEquals(0, this.categoryRepository.count());
    }

}
