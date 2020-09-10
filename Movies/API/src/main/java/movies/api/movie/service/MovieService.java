package movies.api.movie.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import movies.api.movie.domain.MovieBaseDto;
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

    public List<MovieBaseDto> getMovies(String categoryName) {
        return this.movieRepository.findAllByCategoryName(categoryName)
                .stream()
                .map(m -> this.mapper.map(m, MovieBaseDto.class))
                .collect(Collectors.toList());
    }


}
