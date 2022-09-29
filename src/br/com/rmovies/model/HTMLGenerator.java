package br.com.rmovies.model;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class HTMLGenerator {

    private Writer writer;

    public HTMLGenerator(Writer writer) {
        this.writer = writer;
    }

    public void generate(List<Movie> movies) throws IOException {
        writer.write(getBeginHtml());
        movies.forEach((movie) -> {
            try {
                writer.write(String.format(this.getDivTemplate(), movie.getTitle(), movie.getUrlImage(), movie.getTitle(), movie.getRating(), movie.getYear()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        writer.write(this.getEndHTML());

    }

    public void closeWriter() throws IOException {
        if (this.writer == null) return;
            this.writer.close();
    }

    private String getBeginHtml() {
        String beginHTML = """
               <!DOCTYPE html> 
               <html>
                """ + this.getHead() + """
                <body style="background-color: #8D8E8F;">
                    <h1 style="text-align: center;"> R Movies </h1>
                """;

        return beginHTML;
    }

    private String getHead() {
        String head =
                """
                <head>
                    <meta charset=\"utf-8\">
                    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">
                    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\" 
                        + "integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">					
                </head>
                """;

        return head;
    }

    private String getDivTemplate() {
        String divTemplate =
                """
                <div class=\"card text-white bg-dark mb-3\" style=\"max-width: 18rem; display: inline-block; margin: 0 20px; vertical-align: middle\">
                    <h4 class=\"card-header\">%s</h4>
                    <div class=\"card-body\">
                        <img class=\"card-img\" src=\"%s\" alt=\"%s\">
                        <p class=\"card-text mt-2\">Nota: %s - Ano: %s</p>
                    </div>
                </div>
                """;
        return divTemplate;
    }

    private String getEndHTML() {
        String endHTML = """
                </body>
                </html>
                """;
        return endHTML;
    }
}
