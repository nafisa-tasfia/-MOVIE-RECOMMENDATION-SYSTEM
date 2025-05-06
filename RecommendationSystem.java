import java.util.*;

public class RecommendationSystem {
    private List<Movie> movies;

    public RecommendationSystem() {
        movies = new ArrayList<>();
        movies.add(new Movie("Inception", "Sci-Fi"));
        movies.add(new Movie("The Godfather", "Crime"));
        movies.add(new Movie("Frozen", "Animation"));
        movies.add(new Movie("Avengers", "Action"));
        movies.add(new Movie("Coco", "Animation"));
    }

    public void showAllMovies() {
        System.out.println("\nAvailable Movies:");
        for (Movie m : movies) {
            System.out.println("- " + m);
        }
    }

    public void recommendMovies(String genre) {
        System.out.println("\nRecommended Movies in Genre: " + genre);
        boolean found = false;
        for (Movie m : movies) {
            if (m.getGenre().equalsIgnoreCase(genre)) {
                System.out.println("- " + m.getTitle());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No recommendations found.");
        }
    }

    public Movie findMovie(String title) {
        for (Movie m : movies) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                return m;
            }
        }
        return null;
    }
}
