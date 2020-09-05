package movies.api.movie.service;

import movies.api.movie.repository.MovieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final ModelMapper mapper;

    public MovieService(MovieRepository movieRepository, ModelMapper mapper) {
        this.movieRepository = movieRepository;
        this.mapper = mapper;
    }
}
