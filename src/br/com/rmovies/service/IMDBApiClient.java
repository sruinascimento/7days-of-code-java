package br.com.rmovies.service;

import br.com.rmovies.model.APIClient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class IMDBApiClient implements APIClient {
    private String apiKey;

    public IMDBApiClient(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public String getBody( ) {
        try {
            var uri = URI.create("https://imdb-api.com/en/API/Top250Movies/"+this.apiKey);
            var client = HttpClient.newHttpClient();
            var request = HttpRequest.newBuilder(uri).GET().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
