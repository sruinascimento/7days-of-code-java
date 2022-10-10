package br.com.rmovies.service;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class SearchApiKeyService {
    public static String getApiKey(String apiKey) throws IOException {
        Properties props =  new Properties();
        props.load(new FileReader("confs.properties"));
        return props.getProperty(apiKey);
    }
}
