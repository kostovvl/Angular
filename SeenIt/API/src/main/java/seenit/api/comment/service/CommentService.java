package seenit.api.comment.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seenit.api.comment.domain.Comment;
import seenit.api.comment.domain.CommentDto;
import seenit.api.comment.repository.CommentRepository;
import seenit.api.post.domain.Post;
import seenit.api.post.domain.PostDto;
import seenit.api.post.repository.PostRepository;
import seenit.api.user.domain.UserEntity;
import seenit.api.user.repository.UserEntityRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserEntityRepository userEntityRepository;
    private final PostRepository postRepository;
    private final ModelMapper mapper;

    @Autowired
    public CommentService(CommentRepository commentRepository, UserEntityRepository userEntityRepository,
                          PostRepository postRepository, ModelMapper mapper) {
        this.commentRepository = commentRepository;
        this.userEntityRepository = userEntityRepository;
        this.postRepository = postRepository;
        this.mapper = mapper;
    }

    public CommentDto createNew(CommentDto commentDto, String username) {

        UserEntity userEntity = this.userEntityRepository.findById(commentDto.getCreatorId()).orElse(null);
        if (!userEntity.getUsername().equals(username)) {
            throw new UnsupportedOperationException("Shit");
        }
        Post post = this.postRepository.findById(commentDto.getPostId()).orElse(null);

        Comment comment = this.mapper.map(commentDto, Comment.class);
        comment.setCreator(userEntity);
        comment.setPost(post);

        Set<Comment> userComments = userEntity.getComments();
        userComments.add(comment);
        userEntity.setComments(userComments);

        Set<Comment> postComments = post.getComments();
        postComments.add(comment);
        post.setComments(postComments);

        CommentDto result = this.mapper.map(this.commentRepository.saveAndFlush(comment), CommentDto.class);
        result.setPostId(post.getId());
        result.setCreatorId(userEntity.getId());

        return result;
    }

    public List<CommentDto> getAllByPost(long postId) {
        return this.commentRepository.findByPostId(postId)
                .stream()
                .map(c -> {
                    CommentDto result = this.mapper.map(c, CommentDto.class);
                    result.setPostId(c.getPost().getId());
                    result.setCreatorId(c.getCreator().getId());
                    return result;
                }).collect(Collectors.toList());
    }

    public List<CommentDto> getAllByUser(long userId, String name) {

        UserEntity userEntity = this.userEntityRepository.findById(userId).orElse(null); 
        if (!userEntity.getUsername().equals(name)) {
            throw new UnsupportedOperationException("Shit");
        }

        return this.commentRepository.findByCreatorId(userId)
                .stream()
                .map(c -> {
                    CommentDto result = this.mapper.map(c, CommentDto.class);
                    result.setPostId(c.getPost().getId());
                    result.setCreatorId(c.getCreator().getId());
                    return result;
                }).collect(Collectors.toList());
    }

    public void delete(long commentId, String name) {
        Comment comment = this.commentRepository.findById(commentId).orElse(null);
        UserEntity creator = this.userEntityRepository.findById(comment.getCreator().getId()).orElse(null);

        if (!creator.getUsername().equals(name)) {
            throw new UnsupportedOperationException("Shit");
        }

        Post post = this.postRepository.findById(comment.getPost().getId()).orElse(null);

        Set<Comment> creatorComments = creator.getComments();
        creatorComments = creatorComments.stream()
                .filter(c -> c.getId() != commentId)
                .collect(Collectors.toSet());
        creator.setComments(creatorComments);

        Set<Comment> postComments = post.getComments();
        postComments = postComments.stream()
                .filter(c -> c.getId() != commentId)
                .collect(Collectors.toSet());
        post.setComments(postComments);

        this.commentRepository.deleteById(commentId);

    }
}
