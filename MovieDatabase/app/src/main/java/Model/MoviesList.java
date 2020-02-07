package Model;

public class MoviesList {
    private String movieTitle;
    private String movieTheater;
    private String theaterAddress;

    public MoviesList(String movieTitle, String movieTheater, String theaterAddress) {
        this.movieTitle = movieTitle;
        this.movieTheater = movieTheater;
        this.theaterAddress = theaterAddress;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieTheater() {
        return movieTheater;
    }

    public void setMovieTheater(String movieTheater) {
        this.movieTheater = movieTheater;
    }

    public String getTheaterAddress() {
        return theaterAddress;
    }

    public void setTheaterAddress(String theaterAddress) {
        this.theaterAddress = theaterAddress;
    }
}
