import java.util.*;

public class RecommendationSystem {
    private List<Movie> movies;

    public RecommendationSystem() {
        movies = new ArrayList<>();

        // Sci-Fi
        movies.add(new Movie("Inception", "Sci-Fi"));
        movies.add(new Movie("The Matrix", "Sci-Fi"));
        movies.add(new Movie("Interstellar", "Sci-Fi"));
        movies.add(new Movie("Avatar", "Sci-Fi"));
        movies.add(new Movie("Dune", "Sci-Fi"));

        // Crime
        movies.add(new Movie("The Godfather", "Crime"));
        movies.add(new Movie("The Dark Knight", "Crime"));
        movies.add(new Movie("Sherlock Holmes", "Crime"));

        // Action
        movies.add(new Movie("John Wick", "Action"));
        movies.add(new Movie("Avengers", "Action"));
        movies.add(new Movie("Mad Max: Fury Road", "Action"));
        movies.add(new Movie("Gladiator", "Action"));
        movies.add(new Movie("Taken", "Action"));

        // Romance
        movies.add(new Movie("Titanic", "Romance"));
        movies.add(new Movie("The Notebook", "Romance"));
        movies.add(new Movie("La La Land", "Romance"));
        movies.add(new Movie("Me Before You", "Romance"));

        // Animation
        movies.add(new Movie("Frozen", "Animation"));
        movies.add(new Movie("Coco", "Animation"));
        movies.add(new Movie("Inside Out", "Animation"));
        movies.add(new Movie("Moana", "Animation"));
        movies.add(new Movie("Zootopia", "Animation"));

        // Comedy
        movies.add(new Movie("Home Alone", "Comedy"));
        movies.add(new Movie("The Mask", "Comedy"));
        movies.add(new Movie("Jumanji", "Comedy"));
        movies.add(new Movie("Ted", "Comedy"));
        movies.add(new Movie("The Intern", "Comedy"));

        // Drama
        movies.add(new Movie("Joker", "Drama"));
        movies.add(new Movie("The Pursuit of Happyness", "Drama"));
        movies.add(new Movie("Forrest Gump", "Drama"));

        // Horror
        movies.add(new Movie("A Quiet Place", "Horror"));
        movies.add(new Movie("The Conjuring", "Horror"));
        movies.add(new Movie("Annabelle", "Horror"));
        movies.add(new Movie("IT", "Horror"));
    }

    // Display all movies grouped by genre
    public void showMoviesByCategory() {
        Map<String, List<String>> categorized = new HashMap<>();
        for (Movie m : movies) {
            categorized.putIfAbsent(m.getGenre(), new ArrayList<>());
            categorized.get(m.getGenre()).add(m.getTitle());
        }

        System.out.println("\nMovies by Category:");
        for (String genre : categorized.keySet()) {
            System.out.println("- " + genre + ": " + String.join(", ", categorized.get(genre)));
        }
    }

    // Recommend movies based on user's favorite genres and ratings
    public void recommendMovies(List<String> favoriteGenres) {
        System.out.println("\nAI-Based Recommendations:");
        boolean found = false;

        for (Movie m : movies) {
            for (String favGenre : favoriteGenres) {
                if (m.getGenre().equalsIgnoreCase(favGenre.trim()) && m.getRating() >= 3.5) {
                    System.out.println("- " + m.getTitle() + " [" + m.getGenre() + "]");
                    found = true;
                    break;
                }
            }
        }

        if (!found) {
            System.out.println("No strong matches found. Try rating some movies first!");
        }
    }

    // Find a movie by title
    public Movie findMovie(String title) {
        for (Movie m : movies) {
            if (m.getTitle().equalsIgnoreCase(title.trim())) {
                return m;
            }
        }
        return null;
    }

    // Show all movies with rating and review
    public void showAllMovies() {
        for (Movie m : movies) {
            System.out.println("- " + m);
        }
    }
}
