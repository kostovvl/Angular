package seenit.api.post.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seenit.api.post.domain.Post;
import seenit.api.post.domain.PostDto;
import seenit.api.post.repository.PostRepository;
import seenit.api.user.domain.UserEntity;
import seenit.api.user.repository.UserEntityRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserEntityRepository userEntityRepository;
    private final ModelMapper mapper;

    @Autowired
    public PostService(PostRepository postRepository, UserEntityRepository userEntityRepository,
                       ModelMapper mapper) {
        this.postRepository = postRepository;
        this.userEntityRepository = userEntityRepository;
        this.mapper = mapper;
    }

    @Transactional
    public PostDto createNewPost(PostDto postDto, String username) {

        UserEntity userEntity = this.userEntityRepository.findByUsername(username).orElse(null);

        Post newPost = this.mapper.map(postDto, Post.class);

        Set<Post> userPosts = userEntity.getPosts();
        userPosts.add(newPost);

        newPost.setCreatorId(userEntity);

        PostDto result = this.mapper.map(this.postRepository.saveAndFlush(newPost), PostDto.class);
        result.setCreatorId(userEntity.getId());

        return result;
    }

    public List<PostDto> getAllPosts() {
        return this.postRepository.findAll()
                .stream()
                .map(p -> {
                    PostDto result = this.mapper.map(p, PostDto.class);
                    result.setCreatorId(p.getCreatorId().getId());
                    return result;
                }).collect(Collectors.toList());
    }

    public List<PostDto> getAllByUser(long userId, String username) {
        UserEntity userEntity = this.userEntityRepository.findByUsername(username).orElse(null);

        if (userId != userEntity.getId()) {
            throw new UnsupportedOperationException();
        }

        return this.postRepository.getAllByCreatorIdId(userId)
                .stream()
                .map(p -> {
                    PostDto result = this.mapper.map(p, PostDto.class);
                    result.setCreatorId(p.getCreatorId().getId());
                    return result;
                }).collect(Collectors.toList());

    }

    public PostDto details (long postId) {
        return this.postRepository.findById(postId)
                .map(p -> {
                    PostDto result = this.mapper.map(p, PostDto.class);
                    result.setCreatorId(p.getCreatorId().getId());
                    return result;
                }).orElse(null);
    }

    @Transactional
    public void deletePost(long postId, String username) {
        UserEntity userEntity = this.userEntityRepository.findByUsername(username).orElse(null);

        Set<Post> userPosts = userEntity.getPosts();

        userPosts = userPosts.stream()
                .filter(p -> p.getId() != postId)
                .collect(Collectors.toSet());

        userEntity.setPosts(userPosts);

        this.postRepository.deleteById(postId);
    }

}
