package movies.api.movie.web;
import movies.api.movie.domain.MovieBaseDto;
import movies.api.movie.domain.MovieDetailsDto;
import movies.api.movie.service.MovieService;
import org.springframework.web.bind.annotation.*;

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

    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping("/details/{id}")
    public MovieDetailsDto getDetails(@PathVariable(name = "id") long id) {
        return this.movieService.getDetails(id);
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping("/search/{title}")
    public List<MovieBaseDto> getDetails(@PathVariable(name = "title") String title) {
        return this.movieService.getByTitleSearch(title);
    }

}
