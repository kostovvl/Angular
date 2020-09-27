package seenit.api.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import seenit.api.post.domain.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}