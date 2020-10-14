package examapi.adminservice.integrationTest;

import examapi.adminservice.domain.Comment;
import examapi.adminservice.innerSecurity.ApiKey;
import examapi.adminservice.repository.CommentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CommentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ApiKey apiKey;

    private final String apiPass = "123456";

    @BeforeEach
    public void setUp() {
        this.commentRepository.deleteAll();
        this.apiKey.setKey(apiPass);
    }

    @Test()
    public void should_Add_New_Comment() throws Exception {
        //act
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/comments/add/" + apiPass)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\" : 1, \"creatorName\" : \"Vlado\"}")
                .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());

        //assert
        Assertions.assertEquals(this.commentRepository.count() ,1);
    }

    @Test()
    public void should_Return_All_Comments() throws Exception {
        //arrange
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/comments/add/" + apiPass)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"id\" : 1, \"creatorName\" : \"Vlado\"}")
                .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());

        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/comments/add/" + apiPass)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\" : 2, \"creatorName\" : \"Ignat\"}")
                .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());

        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/comments/all/" + apiPass)
        ).andExpect(status().isOk());

        Assertions.assertEquals(2, this.commentRepository.count());
    }

    @Test
    public void should_Delete_Comment_When_Approved() throws Exception {
        //arrange
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/comments/add/" + apiPass)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"id\" : 1, \"creatorName\" : \"Vlado\"}")
                .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());

        //

        this.mockMvc.perform(MockMvcRequestBuilders
                .delete("/comments/delete/1/"  + apiPass)
        );

        //assert
        Assertions.assertEquals(0, this.commentRepository.count());
    }

}
