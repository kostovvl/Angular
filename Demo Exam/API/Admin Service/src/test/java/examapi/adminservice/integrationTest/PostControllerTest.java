package examapi.adminservice.integrationTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import examapi.adminservice.domain.AllPosts;
import examapi.adminservice.innerSecurity.ApiKey;
import examapi.adminservice.repository.PostsRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PostsRepository postsRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ApiKey apiKey;

    private final String apiPass = "123456";

    @BeforeEach()
    public void setUp() {
        this.postsRepository.deleteAll();
        this.apiKey.setKey(apiPass);
    }

    @Test
    public void should_Add_New() throws Exception {
        //act
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/posts/add/" + apiPass)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\" : 1, \"title\":\"TestPost1\"}")
        ).andExpect(status().isOk());

        //assert
        Assertions.assertEquals(1, this.postsRepository.count());
    }

    @Test
    public void should_return_all() throws Exception {
        //assert
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/posts/add/" + apiPass)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\" : 1, \"title\":\"TestPost1\"}")
        ).andExpect(status().isOk());

        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/posts/add/" + apiPass)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\" : 2, \"title\":\"TestPost2\"}")
        ).andExpect(status().isOk());


        //act
       MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders
                .get("/posts/all/" + apiPass)
        ).andExpect(status().isOk()).andReturn();
        AllPosts result1 = this.objectMapper.readValue(result.getResponse().getContentAsString(), AllPosts.class);


        //assert
        Assertions.assertEquals(2, result1.getAll().size());
    }

    @Test
    public void should_Delete_Post_On_Approval() throws Exception {
        //assert
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/posts/add/" + apiPass)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\" : 1, \"title\":\"TestPost1\"}")
        ).andExpect(status().isOk());

        //act
        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/posts/approve/1/" + apiPass)
        ).andExpect(status().isOk());

        //assert
        Assertions.assertEquals(0, this.postsRepository.count());
    }

    @Test
    public void should_Delete_Post_On_Deletion() throws Exception {
        //assert
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/posts/add/" + apiPass)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\" : 1, \"title\":\"TestPost1\"}")
        ).andExpect(status().isOk());

        //act
        this.mockMvc.perform(MockMvcRequestBuilders
                .delete("/posts/delete/1/" + apiPass)
        ).andExpect(status().isOk());

        //assert
        Assertions.assertEquals(0, this.postsRepository.count());
    }



}
