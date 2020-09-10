package movies.api.movie.domain;

import movies.api.category.domain.Category;
import movies.api.genres.domain.Genre;

import java.util.List;

public class MovieDetailsDto {

    public Long id;
    public String title;
    private String releaseDate;
    public String imageURL;
    public String description;
    private List<String> genresTitles;

    public MovieDetailsDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getGenresTitles() {
        return genresTitles;
    }

    public void setGenresTitles(List<String> genresTitles) {
        this.genresTitles = genresTitles;
    }
}
