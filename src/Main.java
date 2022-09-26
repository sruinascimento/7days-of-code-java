import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws IOException {

        //Lendo
        Properties props =  new Properties();
        props.load(new FileReader("confs.properties"));
        final String API_KEY = props.getProperty("API_KEY");

        try {
            var uri = URI.create("https://imdb-api.com/en/API/Top250Movies/"+API_KEY);
            var client = HttpClient.newHttpClient();
            var request = HttpRequest.newBuilder(uri).GET().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println(response.body());
            System.out.println(response.body().length());

            System.out.println(response.body().getClass().getName());

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}