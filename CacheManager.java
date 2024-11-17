import java.util.*;

public class CacheManager {
    private static final int L1_CACHE_LIMIT = 5;
    private static final int L2_CACHE_LIMIT = 20;

    private Map<Integer, LinkedHashMap<String, Movie>> l1Cache = new HashMap<>();
    private LinkedHashMap<String, Movie> l2Cache = new LinkedHashMap<>(L2_CACHE_LIMIT, 0.75f, true);
    private CacheStatistics hitTracker;

        }
        return null; // Cache miss
    }

    public void clearL1Cache(int userId) {
        if (l1Cache.containsKey(userId)) {
            l1Cache.get(userId).clear(intln("L1 cache cleared for user " + userId);
        }
    }

    public void clearL2Cache() {
        l2Cache.clear();
        System.out.println("L2 cache cleared.");
    }

    public void addToCache(int userId, String searchKey, Movie movie) {
        addToL1Cache(userId, searchKey, movie);

        // L2 Cache for global popular searches
        if (l2Cache.size() >= L2_CACHE_LIMIT) {
            Iterator<String> it = l2Cache.keySet().iterator();
            it.next();
            it.remove();
        }
        l2Cache.put(searchKey, movie);
    }

    private void addToL1Cache(int userId, String searchKey, Movie movie) {
        l1Cache.computeIfAbsent(userId, k -> new LinkedHashMap<>(L1_CACHE_LIMIT, 0.75f, true));
        if (l1Cache.get(userId).size() >= L1_CACHE_LIMIT) {
            Iterator<String> it = l1Cache.get(userId).keySet().iterator();
            it.next();
            it.remove();
        }
        l1Cache.get(userId).put(searchKey, movie);
    }
}
