package examapi.adminservice.service;

import examapi.adminservice.repository.PostsRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostsRepository postsRepository;

    public PostService(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }
}
