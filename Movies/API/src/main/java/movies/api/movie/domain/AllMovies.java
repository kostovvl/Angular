package movies.api.movie.domain;

import java.util.List;

public class AllMovies {

    List<MovieBinding> results;

    public AllMovies() {
    }

    public List<MovieBinding> getResults() {
        return results;
    }

    public void setResults(List<MovieBinding> results) {
        this.results = results;
    }
}
