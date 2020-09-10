package movies.api.movie.domain;

import movies.api.category.domain.Category;
import movies.api.genres.domain.Genre;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "movies")
public class Movie {

    public Long id;
    public String title;
    private String releaseDate;
    public String imageURL;
    public Category category;
    public String description;
    private List<Genre> genres;

    public Movie() {
    }

    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "release_date")
    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Column(name = "image_Url")
    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @ManyToOne()
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Column(name = "description", columnDefinition = "text")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToMany(mappedBy = "movies", targetEntity = Genre.class,
    fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }
}
