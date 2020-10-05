package examapi.adminservice.service;

import examapi.adminservice.domain.Comment;
import examapi.adminservice.repository.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public void add(Comment comment) {

        this.commentRepository.saveAndFlush(comment);

    }

    public void delete(long commentId) {

        this.commentRepository.deleteById(commentId);

    }
}
