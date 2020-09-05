package movies.api.category.domain;

import movies.api.movie.domain.Movie;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cateories")
public class Category {

    public Long id;
    public String name;
    public Set<Movie>movies;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToMany(mappedBy = "category", targetEntity = Movie.class,
    fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }
}
