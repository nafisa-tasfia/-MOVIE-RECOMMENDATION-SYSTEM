import java.util.*;

public class User {
    private String name;
    private String favoriteGenre;
    private List<Movie> watchlist;

    public User(String name, String favoriteGenre) {
        this.name = name;
        this.favoriteGenre = favoriteGenre;
        this.watchlist = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getFavoriteGenre() {
        return favoriteGenre;
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
