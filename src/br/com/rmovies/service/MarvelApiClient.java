package br.com.rmovies.service;

import br.com.rmovies.model.APIClient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MarvelApiClient implements APIClient {
    private String apiKey;
    private String timeStamp;
    private String hash;

    public MarvelApiClient(String apiKey, String timeStamp, String hash) {
        this.apiKey = apiKey;
        this.timeStamp = timeStamp;
        this.hash = hash;
    }

    @Override
    public String getBody( ) {
        try {
            var uri = URI.create("https://gateway.marvel.com/v1/public/series?ts="+this.timeStamp+"&apikey="+this.apiKey+"&hash="+this.hash);
            var client = HttpClient.newHttpClient();
            var request = HttpRequest.newBuilder(uri).GET().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
