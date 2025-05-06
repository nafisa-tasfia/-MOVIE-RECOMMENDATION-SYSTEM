import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.print("Enter your favorite genre: ");
        String genre = sc.nextLine();

        User user = new User(name, genre);
        RecommendationSystem system = new RecommendationSystem();

        int choice;
        do {
            System.out.println("\n--- Movie Recommendation System ---");
            System.out.println("1. View All Movies");
            System.out.println("2. Get Recommendations");
            System.out.println("3. Rate and Review a Movie");
            System.out.println("4. Add Movie to Watchlist");
            System.out.println("5. View Watchlist");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    system.showAllMovies();
                    break;
                case 2:
                    system.recommendMovies(user.getFavoriteGenre());
                    break;
                case 3:
                    System.out.print("Enter movie title to rate: ");
                    String rateTitle = sc.nextLine();
                    Movie movieToRate = system.findMovie(rateTitle);
                    if (movieToRate != null) {
                        System.out.print("Enter rating (0.0 to 5.0): ");
                        double rating = sc.nextDouble();
                        sc.nextLine(); // clear buffer
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
                    System.out.println("Invalid option. Try again.");
            }
        } while (choice != 0);

        sc.close();
    }
}
