import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

import br.com.rmovies.model.*;
import br.com.rmovies.service.GenerateHashMD5Service;
import br.com.rmovies.service.IMDBApiClient;
import br.com.rmovies.service.MarvelApiClient;
import br.com.rmovies.service.SearchApiKeyService;

public class Main {
    public static void main(String[] args) throws IOException {

        final String API_KEY = SearchApiKeyService.getApiKey("API_KEY_IMDB");

        String json = new IMDBApiClient(API_KEY).getBody();

        List<Movie> movies = (List<Movie>) new IMDBMovieJsonParser(json).parse();
//        Ordenando pelo nome usando a interface Comparable que foi implementada no Movie
//        Collections.sort(movies);
        //Ordenando pelo nome, ou seja, ordem lexicográfica
//        movies.sort(Comparator.comparing(Movie::getTitle));
        //Ordenando pelo ranking
//        movies.sort(Comparator.comparing(Movie::getRating));
        //Ordenando pelo ranking do maior para o menor
        movies.sort((Movie fisrtMovie, Movie secondMovie) -> Double.compare(Double.valueOf(secondMovie.getRating()), Double.valueOf(fisrtMovie.getRating())));
//        System.out.println(movies);
        HTMLGenerator htmlGenerator = new HTMLGenerator(new PrintWriter("index.html"));
        htmlGenerator.generate(movies);
        htmlGenerator.closeWriter();


// Consumindo a API da Marvel
//            String apiKeyMarvelPublic = SearchApiKeyService.getApiKey("API_KEY_MARVEL_PUBLIC");
//            String apiKeyMarvelPrivate = SearchApiKeyService.getApiKey("API_KEY_MARVEL_PRIVATE");
//            String timeStamp = "1";
//            String hash = GenerateHashMD5Service.getHashMd5(timeStamp+apiKeyMarvelPrivate+apiKeyMarvelPublic);
//            String jsonMarvel = new MarvelApiClient(apiKeyMarvelPublic, timeStamp, hash).getBody();
//            List<Serie> series = (List<Serie>) new MarvelJsonParser(jsonMarvel).parse();
//            series.forEach(System.out::println);
//            Collections.sort(series);
//            HTMLGenerator htmlGenerator = new HTMLGenerator(new PrintWriter("index.html"));
//            htmlGenerator.generate(series);
//            htmlGenerator.closeWriter();
    }
}