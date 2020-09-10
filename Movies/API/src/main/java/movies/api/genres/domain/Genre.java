package movies.api.genres.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import movies.api.movie.domain.Movie;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "genres")
public class Genre {

    public Long id;
    public String name;
    @JsonIgnore()
    public List<Movie> movies;

    public Genre() {
    }

    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany()
    @JoinTable(name = "genres_movies", joinColumns = @JoinColumn(name = "genre_id"),
    inverseJoinColumns = @JoinColumn(name = "movie_id"))
    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
