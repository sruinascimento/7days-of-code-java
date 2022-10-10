package br.com.rmovies.model;

import java.util.List;

public interface JsonParser {
    public List<? extends Content> parse();
}
