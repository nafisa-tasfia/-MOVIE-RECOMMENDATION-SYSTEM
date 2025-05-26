import java.util.*;

public class User extends Person {
    private List<String> favoriteGenres;
    private List<Movie> watchlist;

    public User(String name, int age, List<String> favoriteGenres) {
        super(name, age); // calling Person constructor
        this.favoriteGenres = favoriteGenres;
        this.watchlist = new ArrayList<>();
    }

    public List<String> getFavoriteGenres() {
        return favoriteGenres;
    }

    public void addToWatchlist(Movie movie) {
        watchlist.add(movie);
    }

    public void showWatchlist() {
        System.out.println("\nYour Watchlist:");
        for (Movie movie : watchlist) {
            System.out.println("- " + movie.getTitle());
        }
    }
}
