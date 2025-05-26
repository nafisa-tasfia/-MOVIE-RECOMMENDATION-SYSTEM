import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RecommendationSystem system = new RecommendationSystem();
        User user = null;

        // Profile Creation
        System.out.println("Welcome! Please create your profile first.");
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.print("Enter your age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter your favorite genres (comma-separated): ");
        String genreInput = sc.nextLine();
        List<String> genres = Arrays.asList(genreInput.split("\\s*,\\s*"));
        user = new User(name, age, genres);
        System.out.println("Profile created successfully!");

        // Show categories
        system.showMoviesByCategory();

        int choice;
        do {
            System.out.println("\n--- Movie Recommendation System ---");
            System.out.println("1. View All Movies");
            System.out.println("2. Get AI-Based Recommendations");
            System.out.println("3. Rate and Review a Movie");
            System.out.println("4. Add Movie to Watchlist");
            System.out.println("5. View Watchlist");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    system.showAllMovies();
                    break;
                case 2:
                    system.recommendMovies(user.getFavoriteGenres());
                    break;
                case 3:
                    System.out.print("Enter movie title to rate: ");
                    String rateTitle = sc.nextLine();
                    Movie movieToRate = system.findMovie(rateTitle);
                    if (movieToRate != null) {
                        System.out.print("Enter rating (0.0 to 5.0): ");
                        double rating = sc.nextDouble();
                        sc.nextLine();
                        System.out.print("Enter your review: ");
                        String review = sc.nextLine();
                        movieToRate.setRating(rating);
                        movieToRate.setReview(review);
                        System.out.println("Thanks! Review added.");
                    } else {
                        System.out.println("Movie not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter movie title to add to watchlist: ");
                    String watchTitle = sc.nextLine();
                    Movie movieToAdd = system.findMovie(watchTitle);
                    if (movieToAdd != null) {
                        user.addToWatchlist(movieToAdd);
                        System.out.println("Movie added to watchlist.");
                    } else {
                        System.out.println("Movie not found.");
                    }
                    break;
                case 5:
                    user.showWatchlist();
                    break;
                case 0:
                    System.out.println("Goodbye, " + user.getName() + "!");
                    break;
                default:
                    System.out.println("Invalid option.");
            }

        } while (choice != 0);

        sc.close();
    }
}
