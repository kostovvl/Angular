package examapi.contentservice.service;

import examapi.contentservice.domain.dto.CommentDto;
import examapi.contentservice.domain.entity.Comment;
import examapi.contentservice.domain.entity.Post;
import examapi.contentservice.repository.CommentRepository;
import examapi.contentservice.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final ModelMapper mapper;

    public CommentService(CommentRepository commentRepository, PostRepository postRepository, ModelMapper mapper) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.mapper = mapper;
    }

    @Transactional
    public CommentDto createComment(CommentDto newComment) {
        Post post = this.postRepository.getOne(newComment.getPostId());
        Comment comment = this.mapper.map(newComment, Comment.class);

        Set<Comment> existingPostComments = post.getComments();
        existingPostComments.add(comment);

        comment.setPost(post);
        comment.setApproved(false);
        // Maybe will have to save the post...
        this.commentRepository.saveAndFlush(comment);
        return newComment;
    }

    public CommentDto updateComment(long id, CommentDto updatedComment) {
        Comment comment = this.commentRepository.getOne(id);
        comment.setContent(updatedComment.getContent());

        return updatedComment;
    }

    public void approveComment(long id) {
        Comment comment = this.commentRepository.getOne(id);
        comment.setApproved(true);
    }

    public List<CommentDto> getByPost(long postId) {
        return this.commentRepository.getCommentsForPost(postId)
                .stream()
                .map(c -> this.mapper.map(c, CommentDto.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(long id) {
        Comment comment = this.commentRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        Post post = this.postRepository.getOne(comment.getPost().getId());

        Set<Comment> existingPostComments = post.getComments();

        existingPostComments = existingPostComments.stream()
                .filter(c -> c.getId() != id)
                .collect(Collectors.toSet());
        post.setComments(existingPostComments);

        this.commentRepository.deleteById(id);
    }

}
