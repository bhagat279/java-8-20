package java_8_20.movie_type;


import java.util.*;
import java.util.stream.Collectors;

class Movie {
    private String movieName;
    private String genre;

    public Movie(String movieName, String genre) {
        this.movieName = movieName;
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieName='" + movieName + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}

class User {
    private int userId;

    public User(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                '}';
    }
}

class WatchedMovie {
    private User user;
    private Movie movie;

    public WatchedMovie(User user, Movie movie) {
        this.user = user;
        this.movie = movie;
    }

    public User getUser() {
        return user;
    }

    public Movie getMovie() {
        return movie;
    }

    @Override
    public String toString() {
        return "WatchedMovie{" +
                "user=" + user +
                ", movie=" + movie +
                '}';
    }
}

public class MovieGenreAnalysis {
    public static void main(String[] args) {

        User user1 = new User(1);
        User user2 = new User(2);
        User user3 = new User(3);

        Movie movie1 = new Movie("Gadar", "Action");
        Movie movie2 = new Movie("Bhagam Bhag", "Comedy");
        Movie movie3 = new Movie("Ghatak", "Comedy");
        Movie movie4 = new Movie("Sholay", "Drama");
        Movie movie5 = new Movie("Robot", "Action");
        Movie movie6 = new Movie("Welcome", "Comedy");

        WatchedMovie watchedMovie1 = new WatchedMovie(user1, movie1);
        WatchedMovie watchedMovie2 = new WatchedMovie(user1, movie2);
        WatchedMovie watchedMovie3 = new WatchedMovie(user1, movie3);
        WatchedMovie watchedMovie4 = new WatchedMovie(user2, movie4);
        WatchedMovie watchedMovie5 = new WatchedMovie(user2, movie5);
        WatchedMovie watchedMovie6 = new WatchedMovie(user2, movie1);
        WatchedMovie watchedMovie7 = new WatchedMovie(user3, movie3);
        WatchedMovie watchedMovie8 = new WatchedMovie(user3, movie6);


        List<WatchedMovie> watchedMoviesList = Arrays.asList(
                watchedMovie1, watchedMovie2, watchedMovie3,
                watchedMovie4, watchedMovie5, watchedMovie6,
                watchedMovie7, watchedMovie8
        );

     Map<Integer,Map<String, Long>> genreById=  watchedMoviesList.stream().collect(Collectors.groupingBy(
               watchedMovie -> watchedMovie.getUser().getUserId(),
               Collectors.groupingBy(
                       watchedMovie -> watchedMovie.getMovie().getGenre(),
                       Collectors.counting()
               )
       ));

     genreById.forEach((userId,genreCount)->{
         Map.Entry<String, Long> mostWatchMovie = genreCount.entrySet().stream().max(Comparator.comparing(e -> e.getValue())).get();

         System.out.println(userId+":"+mostWatchMovie.getKey());

     });

    }
}
// Write a program that finds the most frequent Genre of movies watched by each user and prints the result as a tuple (userId, genre).