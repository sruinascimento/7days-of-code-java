package br.com.rmovies.model;

public class Serie implements Content, Comparable<Serie>{

    private String title;
    private String urlImage;
    private String rating;
    private String year;

    public Serie(String title, String urlImage, String rating, String year) {
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
        return "Serie";
    }

    @Override
    public String toString() {
        return "Serie{" +
                "title='" + title + '\'' +
                ", urlImage='" + urlImage + '\'' +
                ", rating='" + rating + '\'' +
                ", year='" + year + '\'' +
                '}';
    }

    @Override
    public int compareTo(Serie serie) {
        return Integer.compare(Integer.valueOf(serie.getYear()), Integer.valueOf(this.year));
    }
}
