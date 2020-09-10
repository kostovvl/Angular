package movies.api.init;

import movies.api.category.domain.Category;
import movies.api.category.repository.CategoryRepository;
import movies.api.genres.domain.AllGenres;
import movies.api.genres.domain.Genre;
import movies.api.genres.domain.GenreDto;
import movies.api.genres.repository.GenreRepository;
import movies.api.movie.domain.AllMovies;
import movies.api.movie.domain.Movie;
import movies.api.movie.domain.MovieBinding;
import movies.api.movie.repository.MovieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class InitializeData implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final MovieRepository movieRepository;
    private final ModelMapper mapper;
    private final RestTemplate restTemplate;
    private final GenreRepository genreRepository;

    private  List<Genre> genres = new ArrayList<>();

    private final String POPULAR_URL = "https://api.themoviedb.org/3/movie/popular";
    private final String TOP_RATED_URL = "https://api.themoviedb.org/3/movie/top_rated";
    private final String NOW_PLAYING = "https://api.themoviedb.org/3/movie/now_playing";
    private final String ALL_GENRES = "https://api.themoviedb.org/3/genre/movie/list";

    private final String API_KEY = "?api_key=3954e7ab993e8e5f832230b29248785b";
    private final String API_KEY_ALT = "?api_key=3954e7ab993e8e5f832230b29248785b";

    public InitializeData(CategoryRepository categoryRepository, MovieRepository movieRepository,
                          ModelMapper mapper, RestTemplate restTemplate, GenreRepository genreRepository) {
        this.categoryRepository = categoryRepository;
        this.movieRepository = movieRepository;
        this.mapper = mapper;
        this.restTemplate = restTemplate;
        this.genreRepository = genreRepository;
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {

        //set categories
        if (this.categoryRepository.count() == 0) {
            Category popular = new Category("Popular");
            Category topRated = new Category("Top Rated");
            Category nowPlaying = new Category("Now Playing");
            Category upcoming = new Category ("Upcoming");

            this.categoryRepository.saveAll(List.of(popular, topRated, nowPlaying, upcoming));
        }

        //set genres

        if (this.genreRepository.count() == 0) {
         this.genres = this.restTemplate.getForObject(ALL_GENRES + API_KEY_ALT, AllGenres.class).getGenres()
          .stream().map(g -> this.mapper.map(g, Genre.class)).collect(Collectors.toList());

        }

        if (this.movieRepository.count() != 0) {
            return;
        }
        // Seed Database with movies with category Popular from movies DB
              this.restTemplate.getForObject((POPULAR_URL + API_KEY), AllMovies.class).getResults()
                      .forEach(movie -> seedToDb(movie, "Popular", genres));

        // Seed Database with movies with category Theatre from movies DB
        this.restTemplate.getForObject((TOP_RATED_URL + API_KEY), AllMovies.class).getResults()
                .forEach(movie -> seedToDb(movie, "Top Rated", genres));


        //Seed movies to the genres

        List<Movie> allMovies = this.movieRepository.findAll();

        this.genres.forEach(genre -> {
                    genre.setMovies(allMovies.stream().filter(m -> {
                        boolean contains = false;
                        for (Genre mGenre : m.getGenres()) {
                            if (mGenre.name.equals(genre.name)) {
                                contains = true;
                                break;
                            }
                        }
                        return contains;
                    }).collect(Collectors.toList()));
                });


        //seed genres to Db
        this.genreRepository.saveAll(this.genres);

    }


    // private method for seeding movie entity from movie binding
    private void seedToDb(MovieBinding movieBinding, String categoryName, List<Genre> genresList) {
        Movie movie = new Movie();
        movie.setId(movieBinding.getId());
        movie.setTitle(movieBinding.getTitle());
        movie.setReleaseDate(movieBinding.getRelease_date());
        movie.setImageURL(movieBinding.getPoster_path());
        movie.setDescription(movieBinding.overview);
        movie.setGenres(generateGenres(movieBinding.getGenre_ids(), genresList));


        movie.setCategory(this.categoryRepository.findByName(categoryName));
        this.movieRepository.saveAndFlush(movie);

    }

    private List<Genre> generateGenres(List<Long> ids, List<Genre> genreList) {
        List<Genre> result = new ArrayList<>();
        for (Long id : ids) {
            Genre current = genreList.stream().filter(g -> g.id.equals(id)).findFirst().orElse(null);
            result.add(current);
        }
        return result;
    }


}
