package movies.api.init;

import movies.api.category.domain.Category;
import movies.api.category.repository.CategoryRepository;
import movies.api.movie.domain.AllMovies;
import movies.api.movie.domain.Movie;
import movies.api.movie.domain.MovieBinding;
import movies.api.movie.repository.MovieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class InitializeData implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final MovieRepository movieRepository;
    private final ModelMapper mapper;
    private final RestTemplate restTemplate;
    private final String POPULAR_URL = "https://api.themoviedb.org/3/movie/popular?";
    private final String TOP_RATED_URL = "https://api.themoviedb.org/3/movie/top_rated?";
    private final String API_KEY = "api_key=3954e7ab993e8e5f832230b29248785b";

    public InitializeData(CategoryRepository categoryRepository, MovieRepository movieRepository,
                          ModelMapper mapper, RestTemplate restTemplate) {
        this.categoryRepository = categoryRepository;
        this.movieRepository = movieRepository;
        this.mapper = mapper;
        this.restTemplate = restTemplate;
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {

        if (this.categoryRepository.count() == 0) {
            Category popular = new Category("Popular");
            Category theater = new Category("Top Rated");

            this.categoryRepository.saveAll(List.of(popular, theater));
        }

        if (this.movieRepository.count() != 0) {
            return;
        }
        // Seed Database with movies with category Popular from movies DB
              this.restTemplate.getForObject((POPULAR_URL + API_KEY), AllMovies.class).getResults()
                      .forEach(movie -> seedToDb(movie, "Popular"));

        // Seed Database with movies with category Theatre from movies DB
        this.restTemplate.getForObject((TOP_RATED_URL + API_KEY), AllMovies.class).getResults()
                .forEach(movie -> seedToDb(movie, "Top Rated"));

    }


    private void seedToDb(MovieBinding movieBinding, String categoryName) {
        Movie movie = new Movie();
        movie.setTitle(movieBinding.getTitle());
        movie.setReleaseDate(movieBinding.getRelease_date());
        movie.setImageURL(movieBinding.getPoster_path());
        movie.setCategory(this.categoryRepository.findByName(categoryName));
        this.movieRepository.saveAndFlush(movie);

    }
}
