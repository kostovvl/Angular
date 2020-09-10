package movies.api.genres.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import movies.api.movie.domain.MovieDto;

import java.util.List;

public class GenreDto {

    public Long id;
    public String name;

    public GenreDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
