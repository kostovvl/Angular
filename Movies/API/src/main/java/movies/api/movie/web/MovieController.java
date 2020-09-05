package movies.api.movie.web;
import movies.api.movie.domain.Movie;
import movies.api.movie.domain.MovieDto;
import movies.api.movie.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/popular")
    public List<MovieDto> getPopularMovies() {
        return this.movieService.getPopularMovies();
    }

    @GetMapping("/top_rated")
    public List<MovieDto> getTopRated() {
        return this.movieService.getTopRated();
    }


}
