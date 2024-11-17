public class User {
    private int id;
    private String name;
    private String preferredGenre;

    public User(int id, String name, String preferredGenre) {
        this.id = id;
        this.name = name;
        this.preferredGenre = preferredGenre;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getPreferredGenre() { return preferredGenre; }

    @Override
    public String toString() {
        return String.format("User{id=%d, name='%s', preferredGenre='%s'}", id, name, preferredGenre);
    }
}