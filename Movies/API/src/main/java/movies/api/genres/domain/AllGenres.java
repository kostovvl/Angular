package movies.api.genres.domain;

import java.util.List;

public class AllGenres {

    public List<GenreDto> genres;

    public AllGenres() {
    }

    public List<GenreDto> getGenres() {
        return genres;
    }

    public void setGenres(List<GenreDto> genres) {
        this.genres = genres;
    }
}
