package movies.api.genres.service;

import movies.api.genres.domain.GenreDto;
import movies.api.genres.repository.GenreRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class GenreService {

    private final GenreRepository genreRepository;
    private final ModelMapper mapper;

    public GenreService(GenreRepository genreRepository, ModelMapper mapper) {
        this.genreRepository = genreRepository;
        this.mapper = mapper;
    }

    public GenreDto findById(Long id) {
     return this.genreRepository.findById(id)
             .map(g -> this.mapper.map(g, GenreDto.class))
             .orElse(null);
    }
}
