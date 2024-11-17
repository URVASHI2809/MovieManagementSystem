import java.util.*;

public class Driver {
    private stse();
    private static CacheManager cacheManager = new CacheManager(cacheStatistics);
    private static SearchService searchService = new SearchService(movieDatabase, cacheManager,cacheStatistics);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter commands:");
        while (scanner.hasNextLine()) {
            String command = scanner.nextLine();
            String[] parts = command.split(" ", 2);

            
                switch (parts[0]) {
                    case "ADD_MOVIE":
                        addMovie(parts[1]);
                        break;
                    case "ADD_USER":
                        addUser(parts[1]);
                        break;
                    case "SEARCH":
                        search(parts[1]);
                        break;
                    case "SEARCH_MULTI":
                        searchMulti(parts[1]);
                        break;
                    case "VIEW_CACHE_STATS":
                        cacheStatistics.displayStats();
                     

    private static void addMovie(String args) {
        String[] details = args.split(" ", 5);
        if (details.length < 5) {
            System.out.println("Error: Invalid number of arguments for ADD_MOVIE.");
            return;
        }
        int id = Integer.parseInt(details[0]); // Parse movie ID
        String title = details[1].replace("\"", ""); // Remove quotes from title
        String genre = details[2].replace("\"", ""); // Remove quotes from genre
        int year = Integer.parseInt(details[3]); // Parse year
        double rating = Double.parseDouble(details[4]); // Parse rating

        // Create the Movie object
   
        String[] details = args.split(" ");
        int userId = Integer.parseInt(details[0]);
        String searchType = details[1];
        String searchValue = details[2].replace("\"", "");

        List<Movie> results;
        switch (searchType) {
            case "TITLE":
                results = searchService.search(userId, searchValue, null, 0, 0);
                break;
            case "GENRE":
                results = searchService.search(userId, null, searchValue, 0, 0);
                break;
            case "YEAR":
                results = searchService.search(userId, null, null, Integer.parseInt(searchValue), 0);
                break;
            default:
                System.out.println("Invalid search type.");
                return;
        }
        displaySearchResults(results);
    }

    private static void searchMulti(String args) {
        String[] details = args.split(" ");
        int userId = Integer.parseInt(details[0]);
        String genre = details[1].replace("\"", "");
        int year = Integer.parseInt(details[2]);
        double minRating = Double.parseDouble(details[3]);

        List<Movie> results = searchService.search(userId, null, genre, year, minRating);
        displaySearchResults(results);
    }

    private static void displaySearchResults(List<Movie> results) {
        if (results.isEmpty()) {
            System.out.println("No movies found.");
        } else {
            for (Movie movie : results) {
                System.out.println(movie);
            }
        }
    }

    private static void clearCache(String details) {
        String[] detail = details.split(" ", 2);
        String cacheLevel = detail[0];
        int userId = Integer.parseInt(detail[1]);
        if (cacheLevel.equals("L1")) {
            cacheManager.clearL1Cache(userId);
            System.out.println("L1 cache cleared successfully");
        } else if (cacheLevel.equals("L2")) {
            cacheManager.clearL2Cache();
            System.out.println("L2 cache cleared successfully");
        } else {
            System.out.println("Invalid cache level. Use 'L1' or 'L2'.");
        }
    }
}
