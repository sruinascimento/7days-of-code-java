package br.com.rmovies.service;

public class MovieExtractorService {

    public static String[] extractMovie(String json) {
        int firstIndex = json.indexOf("[");
        int lastIndex = json.indexOf("]");

        String moviesObjectsJson = json.substring(firstIndex+1, lastIndex);
        moviesObjectsJson = moviesObjectsJson.replace("{", "");

        String[] movies = moviesObjectsJson.split("},");

        return movies;
    }
}
