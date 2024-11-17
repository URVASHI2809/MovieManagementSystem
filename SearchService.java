import java.util.List;

public class SearchService {
    private MovieDatabase movieDatabase;
    private CacheManager cacheManager;
    private CacheStatistics cacheStatistics;

    public SearchService(MovieDatabase movieDatabase, CacheManager cacheManager, CacheStatistics cacheStatistics) {
        this.movieDatabase = movieDatabase;
        this.cacheManager = cacheManager;
        this.cacheStatistics = cacheStatistics;
    }

    public List<Movie> search(int userId, String title, String genre, int year, double minRating) {
        String searchKey = generateSearchKey(title, genre, year, minRating);
        Movie cachedMovie = cacheManager.getFromCache(userId, searchKey);

        if (cachedMovie != null) {
            System.out.println("Cache Hit: " + cachedMovie);
            return List.of(cachedMovie);
        }

        List<Movie> result = movieDatabase.searchMovies(title, genre, year, minRating);
        if (!result.isEmpty()) {
            System.out.println("Primary store hit");
            cacheStatistics.incrementPrimaryHits();
            cacheManager.addToCache(userId, searchKey, result.get(0)); // Adding first match to cache
        }
        return result;
    }

    private String generateSearchKey(String title, String genre, int year, double minRating) {
        return (title != null ? title : "") + "|" + (genre != null ? genre : "") + "|" + year + "|" + minRating;
    }
}
