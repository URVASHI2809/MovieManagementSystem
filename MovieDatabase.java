import java.util.*;

public class MovieDatabase {
    private Map<Integer, Movie> movieMap = new HashMap<>();

    public void addMovie(Movie movie) {
        if (movieMap.containsKey(movie.getId())) {
            System.out.println("Movie with ID already exists.");
        } else {
            movieMap.put(movie.getId(), movie);
            System.out.println("Movie '" + movie.getTitle() + "' added successfully");
        }
    }

    public List<Movie> searchMovies(String title, String genre, int year, double minRating) {
        System.out.println("Searching in Primary Store");
        List<Movie> result = new ArrayList<>();
        for (Movie movie : movieMap.values()) {
            if ((title == null || movie.getTitle().equalsIgnoreCase(title)) &&
                    (genre == null || movie.getGenre().equalsIgnoreCase(genre)) &&
                    (year <= 0 || movie.getReleaseYear() == year) &&
                    (minRating <= 0.0 || movie.getRating() >= minRating)) {
                result.add(movie);
            }
        }
        return result;
    }
}
