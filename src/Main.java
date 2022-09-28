import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.rmovies.model.Movie;
import br.com.rmovies.service.JsonParserMovieService;
import br.com.rmovies.service.RequestMovieJsonService;

public class Main {
    public static void main(String[] args) throws IOException {

            String json = RequestMovieJsonService.getBodyHtml();

            String[] moviesArray = JsonParserMovieService.parseJsonMovies(json);

            List<String> titles = JsonParserMovieService.parseTitles(moviesArray);
            List<String> urlsImages = JsonParserMovieService.parseUrlImages(moviesArray);
            List<String> ratings = JsonParserMovieService.parseRatings(moviesArray);
            List<String> years = JsonParserMovieService.parseYears(moviesArray);

            List<Movie> movies = new ArrayList<>();

            for (int i = 0; i < titles.size(); i++) {
                    movies.add(new Movie(titles.get(i), urlsImages.get(i), ratings.get(i), years.get(i)));
            }


            movies.forEach(System.out::println);



//            titles.forEach(System.out::println);
//            urlsImages.forEach(System.out::println);
//            ratings.forEach(System.out::println);
//            years.forEach(System.out::println);

    }
}