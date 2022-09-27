import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.rmovies.model.JsonParser;
import br.com.rmovies.service.RequestMovieJsonService;

public class Main {
    public static void main(String[] args) throws IOException {

            String json = RequestMovieJsonService.getBodyHtml();
            var jsonParser = new JsonParser();
            var moviesJson = jsonParser.parse(json);
            List<String> titles = new ArrayList<>();
            List<String> urlsImages = new ArrayList<>();

            for (Map<String, String> movie: moviesJson) {
                titles.add(movie.get("title"));
                urlsImages.add(movie.get("image"));

            }

            titles.forEach(System.out::println);
            urlsImages.forEach(System.out::println);


    }
}