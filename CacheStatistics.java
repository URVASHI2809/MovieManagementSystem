public class CacheStatistics {
    private int l1Hits;
    private int l2Hits;
    private int primaryHits;

    public void incrementL1Hits() { l1Hits++; }
    public void incrementL2Hits() { l2Hits++; }
    public void incrementPrimaryHits() { primaryHits++; }

    public void displayStats() {
        System.out.println("L1 Cache Hits: " + l1Hits);
        System.out.println("L2 Cache Hits: " + l2Hits);
        System.out.println("Primary Store Hits: " + primaryHits);
        System.out.println("Total Searches: " + (l1Hits + l2Hits + primaryHits));
    }
}
