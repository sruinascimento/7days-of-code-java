package br.com.rmovies.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MarvelJsonParser implements JsonParser {
    private String json;

    public MarvelJsonParser(String json) {
        this.json = json;
    }

    private List<String> parseAtribute(String regex) {
        Matcher matcher = Pattern.compile(regex).matcher(this.json);
        if (!matcher.find()) {
            throw new IllegalArgumentException("no match in " + this.json);
        }

        List<String> atributes = new ArrayList<>();

        while (matcher.find()) {
            String atribute = matcher.group(1).replaceAll("\"", "");
            atributes.add(atribute);
        }

        return atributes;
    }

    private List<String> parseTitle() {
        String regex = "\\\"title\\\":\\\"([\\s\\w.()-]+)";
        return this.parseAtribute(regex);
    }

    private List<String> parseYear() {
        String regex = "\\\"startYear\\\":([\\d]+)";
        return this.parseAtribute(regex);
    }

    private List<String> parseRating() {
        String regex = "\\\"rating\\\":([\\\"\\d]+)";
        return this.parseAtribute(regex);
    }

    //Código duplicado por conta da duplicação de função, refatorar.
    private List<String> parseUrlImage() {
        String regex = "\\\"path\\\":\\\"([\\w://.]+)\\\",\\\"extension\\\":\\\"([\\w]+)\\\"";
        Matcher matcher = Pattern.compile(regex).matcher(this.json);
        if (!matcher.find()) {
            throw new IllegalArgumentException("no match in " + this.json);
        }

        List<String> atributes = new ArrayList<>();

        while (matcher.find()) {
        String atribute = matcher.group(1) + "." + matcher.group(2);
            atributes.add(atribute);
        }

        return atributes;
    }

    @Override
    public List<? extends Content> parse() {
        List<String> titles = this.parseTitle();
        List<String> years = this.parseYear();
        List<String> ratings = this.parseRating();
        List<String> images = this.parseUrlImage();

        List<Serie> series = new ArrayList<>();

        for (int i = 0; i < titles.size(); i++) {
            series.add( new Serie( titles.get(i), images.get(i), ratings.get(i),years.get(i) ) );
        }
        return series;
    }


}
