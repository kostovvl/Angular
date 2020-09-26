package seenit.api.comment.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seenit.api.comment.repository.CommentRepository;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final ModelMapper mapper;

    @Autowired
    public CommentService(CommentRepository commentRepository, ModelMapper mapper) {
        this.commentRepository = commentRepository;
        this.mapper = mapper;
    }
}
