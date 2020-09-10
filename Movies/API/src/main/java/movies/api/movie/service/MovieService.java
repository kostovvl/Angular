package movies.api.movie.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import movies.api.movie.domain.MovieDto;
import movies.api.movie.repository.MovieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final ModelMapper mapper;

    public MovieService(MovieRepository movieRepository, ModelMapper mapper) {
        this.movieRepository = movieRepository;
        this.mapper = mapper;
    }

    public List<MovieDto> getPopularMovies() {
        return this.movieRepository.findAllByCategoryName("Popular")
                .stream()
                .map(m -> this.mapper.map(m, MovieDto.class))
                .collect(Collectors.toList());
    }
    
    public List<MovieDto> getTopRated() {
        return this.movieRepository.findAllByCategoryName("Top Rated")
                .stream()
                .map(m -> this.mapper.map(m, MovieDto.class))
                .collect(Collectors.toList());
    }
}
