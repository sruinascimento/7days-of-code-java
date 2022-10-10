package br.com.rmovies.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IMDBMovieJsonParser implements JsonParser {
    private String json;

    public IMDBMovieJsonParser(String json) {
        this.json = json;
    }

    public String[] parseJsonMovies() {
        Matcher matcher = Pattern.compile(".*\\[(.*)\\].*").matcher(this.json);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("no match in " + this.json);
        }

        String[]  moviesArray = matcher.group(1).split("\\},\\{");
        moviesArray[0] = moviesArray[0].substring(1);
        int last = moviesArray.length - 1;
        String lastString = moviesArray[last];
        moviesArray[last] = lastString.substring(0, lastString.length() - 1);
        return moviesArray;
    }

    private List<String> parseTitles(String[] moviesArray) {
        return parseAttribute(moviesArray, 3);
    }

    private List<String> parseUrlImages(String[] moviesArray) {
        return parseAttribute(moviesArray, 5);
    }

    private List<String> parseRatings(String[] moviesArray) {
        return parseAttribute(moviesArray, 7);
    }

    private List<String> parseYears(String[] moviesArray) {
        return parseAttribute(moviesArray, 4);
    }

    private List<String> parseAttribute(String[] moviesArray, int pos) {
        return Stream.of(moviesArray)
                .map(e -> e.split("\",\"")[pos])
                .map(e -> e.split(":\"")[1])
                .map(e -> e.replaceAll("\"", ""))
                .map(e -> e.replaceAll("(@+)(.*).jpg$", "$1.jpg"))
                .collect(Collectors.toList());
    }

    @Override
    public List<? extends Content> parse() {
        String[] moviesArray = this.parseJsonMovies();
        List<String> titles = this.parseTitles(moviesArray);
        List<String> urlsImages = this.parseUrlImages(moviesArray);
        List<String> ratings = this.parseRatings(moviesArray);
        List<String> years = this.parseYears(moviesArray);

        List<Movie> movies = new ArrayList<>();

        for (int i = 0; i < titles.size(); i++) {
            movies.add(new Movie(titles.get(i), urlsImages.get(i), ratings.get(i), years.get(i)));
        }
        return movies;
    }
}
