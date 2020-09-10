package movies.api.movie.web;
import movies.api.movie.domain.MovieBaseDto;
import movies.api.movie.service.MovieService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping("/popular")
    public List<MovieBaseDto> getPopularMovies() {
        return this.movieService.getMovies("Popular");
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping("/top_rated")
    public List<MovieBaseDto> getTopRated() {
        return this.movieService.getMovies("Top Rated");
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping("/now_playing")
    public List<MovieBaseDto> getNowPlaying() {
        return this.movieService.getMovies("Now Playing");
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping("/upcoming")
    public List<MovieBaseDto> getUpcoming() {
        return this.movieService.getMovies("Upcoming");
    }

}
