package movies.api.movie.repository;

import movies.api.genres.domain.Genre;
import movies.api.movie.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie>findAllByCategoryName(String categoryName);
    List<Movie> findAll();
    @Query("select m from Movie as m where m.title like %:title%")
    List<Movie> customTitleSearch(String title);

}
