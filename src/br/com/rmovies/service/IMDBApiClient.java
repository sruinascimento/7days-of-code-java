package br.com.rmovies.service;

import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

public class IMDBApiClient {

    public static String getBodyHtml(String apiKEY ) {
        try {

            final String API_KEY = getApiKey();

            var uri = URI.create("https://imdb-api.com/en/API/Top250Movies/"+API_KEY);
            var client = HttpClient.newHttpClient();
            var request = HttpRequest.newBuilder(uri).GET().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getApiKey() throws IOException {
        Properties props =  new Properties();
        props.load(new FileReader("confs.properties"));
        return props.getProperty("API_KEY");
    }
}
