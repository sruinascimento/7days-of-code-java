import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import br.com.rmovies.model.HTMLGenerator;
import br.com.rmovies.model.Movie;
import br.com.rmovies.service.JsonParserMovieService;
import br.com.rmovies.service.IMDBApiClient;

public class Main {
    public static void main(String[] args) throws IOException {
            Properties props =  new Properties();
            props.load(new FileReader("confs.properties"));
            final String API_KEY =  props.getProperty("API_KEY");

            String json = IMDBApiClient.getBodyHtml(API_KEY);

            String[] moviesArray = JsonParserMovieService.parseJsonMovies(json);

            List<String> titles = JsonParserMovieService.parseTitles(moviesArray);
            List<String> urlsImages = JsonParserMovieService.parseUrlImages(moviesArray);
            List<String> ratings = JsonParserMovieService.parseRatings(moviesArray);
            List<String> years = JsonParserMovieService.parseYears(moviesArray);

            List<Movie> movies = new ArrayList<>();

            for (int i = 0; i < titles.size(); i++) {
                    movies.add(new Movie(titles.get(i), urlsImages.get(i), ratings.get(i), years.get(i)));
            }


            HTMLGenerator htmlGenerator = new HTMLGenerator(new PrintWriter("index.html"));
            htmlGenerator.generate(movies);
            htmlGenerator.closeWriter();
//            movies.forEach(System.out::println);



//            titles.forEach(System.out::println);
//            urlsImages.forEach(System.out::println);
//            ratings.forEach(System.out::println);
//            years.forEach(System.out::println);

    }
}