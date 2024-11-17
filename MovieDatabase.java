import java.util.*;

public class MovieDatabase {
    private Map<Integer, Movie> movieMap = new HashMap<>();

    public void addMovie(Movie movie) {
        if (movieMap.containsKey(movie.getId())) {
            System.out.println("Movie with ID already exists.");
        
        return result;
    }
}
