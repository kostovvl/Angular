package movies.api.movie.repository;

import movies.api.movie.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie>findAllByCategoryName(String categoryName);

}
