package Model;

import java.util.Date;

public class ListMovies {
    private String imageUrl;
    private int popularity;
    private String moviesTitle;
    private String originalLanguage;
    private String overView;


    public ListMovies(String imageUrl, int popularity, String moviesTitle, String originalLanguage, String overView) {
        this.imageUrl = imageUrl;
        this.popularity = popularity;
        this.moviesTitle = moviesTitle;
        this.originalLanguage = originalLanguage;
        this.overView = overView;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public String getMoviesTitle() {
        return moviesTitle;
    }

    public void setMoviesTitle(String moviesTitle) {
        this.moviesTitle = moviesTitle;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getOverView() {
        return overView;
    }

    public void setOverView(String overView) {
        this.overView = overView;
    }
}
