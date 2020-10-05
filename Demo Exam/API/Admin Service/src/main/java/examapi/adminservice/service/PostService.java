package examapi.adminservice.service;

import examapi.adminservice.domain.Post;
import examapi.adminservice.repository.PostsRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostsRepository postsRepository;

    public PostService(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    public void add(Post post) {
        this.postsRepository.saveAndFlush(post);
    }

    public void delete(long postId) {
        this.postsRepository.deleteById(postId);
    }
}
