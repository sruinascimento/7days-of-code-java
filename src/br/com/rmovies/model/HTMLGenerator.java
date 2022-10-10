package br.com.rmovies.model;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class HTMLGenerator {

    private Writer writer;

    public HTMLGenerator(Writer writer) {
        this.writer = writer;
    }

    public void generate(List<? extends Content> movies) throws IOException {
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
                <body style="background-color: #8D8E8F; font-family: 'Poppins'">
                <header style="display:flex; justify-content: center; gap: 20px; background-color:black; color: red; margin-bottom: 20px; padding: 10px 0;">
                    <i style="font-size: 48px;" class="fa-solid fa-film"></i>
                    <h1 style="text-align: center; font-family: 'Anton'; font-size: 40px; font-weight: bold; color: white;"> R Movies </h1>
                </header>
                """;

        return beginHTML;
    }

    private String getHead() {
        String head =
                """
                        <head>
                            <meta charset=\"utf-8\">
                            <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">
                            <link rel="preconnect" href="https://fonts.googleapis.com">
                            <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
                            <link href="https://fonts.googleapis.com/css2?family=Anton&display=swap" rel="stylesheet">
                            <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\" 
                                + "integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">		
                            <script src="https://kit.fontawesome.com/34289682d8.js" crossorigin="anonymous"></script>		
                            <link href="https://fonts.googleapis.com/css2?family=Righteous&display=swap" rel="stylesheet">	
                            <link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
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
