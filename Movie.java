public class Movie {
    private String title;
    private String genre;
    private double rating;
    private String review;

    public Movie(String title, String genre) {
        this.title = title;
        this.genre = genre;
        this.rating = 0.0;
        this.review = "";
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return title + " [" + genre + "] - Rating: " + rating + ", Review: " + review;
    }
}
