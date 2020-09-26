package seenit.api.post;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seenit.api.post.repository.PostRepository;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final ModelMapper mapper;

    @Autowired
    public PostService(PostRepository postRepository, ModelMapper mapper) {
        this.postRepository = postRepository;
        this.mapper = mapper;
    }
}
