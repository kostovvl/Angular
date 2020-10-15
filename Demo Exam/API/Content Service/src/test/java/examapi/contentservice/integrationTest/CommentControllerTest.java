package examapi.contentservice.integrationTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import examapi.contentservice.domain.dto.CommentDto;
import examapi.contentservice.domain.entity.Comment;
import examapi.contentservice.innerSecurity.ApiKey;
import examapi.contentservice.repository.CommentRepository;
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

    @Autowired
    private ObjectMapper objectMapper;

    private final String apiPass = "123456";

    private CommentDto comment1;
    private CommentDto comment2;

    @BeforeEach
    public void setUp() {
        this.commentRepository.deleteAll();
        this.apiKey.setKey(apiPass);

        this.comment1 = new CommentDto();
        this.comment1.setId(1);
        this.comment1.setContent("Content 1");
        this.comment1.setApproved(true);

        this.comment2 = new CommentDto();
        this.comment2.setId(2);
        this.comment2.setContent("Content 2");
        this.comment2.setApproved(true);
    }

    @Test
    public void should_Create_Comment() throws Exception {
        //act
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/comments/create/" + apiPass)
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(this.comment1))
                .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());

        //assert
        Assertions.assertEquals(1, this.commentRepository.count());
    }

    @Test
    public void should_Update_Comment() {

    }

}
