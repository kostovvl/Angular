package examapi.contentservice.integrationTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import examapi.contentservice.innerSecurity.ApiKey;
import examapi.contentservice.repository.CommentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

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

    @BeforeEach
    public void setUp() {
        this.commentRepository.deleteAll();
        this.apiKey.setKey(apiPass);
    }

    @Test
    public void should_Create_Comment() {
        //arrange

    }

}
