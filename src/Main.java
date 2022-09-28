import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import br.com.rmovies.service.JsonParserMovieService;
import br.com.rmovies.service.RequestMovieJsonService;

public class Main {
    public static void main(String[] args) throws IOException {

            String json = RequestMovieJsonService.getBodyHtml();

            String[] moviesArray = JsonParserMovieService.parseJsonMovies(json);

//        Arrays.asList(moviesArray).stream()
//                        .forEach(System.out::println);
            List<String> titles = JsonParserMovieService.parseTitles(moviesArray);
            List<String> urlsImages = JsonParserMovieService.parseUrlImages(moviesArray);
            List<String> ratings = JsonParserMovieService.parseRatings(moviesArray);
            List<String> years = JsonParserMovieService.parseYears(moviesArray);



            titles.forEach(System.out::println);
            urlsImages.forEach(System.out::println);
            ratings.forEach(System.out::println);
            years.forEach(System.out::println);

    }
}