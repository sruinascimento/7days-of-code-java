package br.com.rmovies.model;


public class Movie implements Content, Comparable<Movie> {
    private String title;
    private String urlImage;
    private String rating;
    private String year;

    public Movie(String title, String urlImage, String rating, String year) {
        this.title = title;
        this.urlImage = urlImage;
        this.rating = rating;
        this.year = year;
    }
    @Override
    public String getTitle() {
        return title;
    }
    @Override
    public String getUrlImage() {
        return urlImage;
    }
    @Override
    public String getRating() {
        return rating;
    }
    @Override
    public String getYear() {
        return year;
    }

    @Override
    public String type() {
        return "Movie";
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", urlImage='" + urlImage + '\'' +
                ", rating=" + rating +
                ", year='" + year + '\'' +
                '}';
    }

    @Override
    public int compareTo(Movie movie) {
        return this.title.compareTo(movie.getTitle());
    }
}
