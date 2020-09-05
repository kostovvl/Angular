package movies.api.init;

import movies.api.category.domain.Category;
import movies.api.category.repository.CategoryRepository;
import movies.api.movie.repository.MovieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class InitializeData implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final MovieRepository movieRepository;
    private final ModelMapper mapper;
    private final RestTemplate restTemplate;

    public InitializeData(CategoryRepository categoryRepository, MovieRepository movieRepository,
                          ModelMapper mapper, RestTemplate restTemplate) {
        this.categoryRepository = categoryRepository;
        this.movieRepository = movieRepository;
        this.mapper = mapper;
        this.restTemplate = restTemplate;
    }

    @Override
    public void run(String... args) throws Exception {

        if (this.categoryRepository.count() == 0) {
            Category popular = new Category("Popular");
            Category theater = new Category("Theater");

            this.categoryRepository.saveAll(List.of(popular, theater));
        }

        //TODO tap into the database of IMDB, connect to the API and seed the database with movies from there...

    }
}
