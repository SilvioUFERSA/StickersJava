import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        
// connect API
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json"; //url secundary
        URI adressUri = URI.create(url);
        
        // beased in documentation

        HttpClient client = HttpClient.newHttpClient(); //static method from httpclient 
        HttpRequest request = HttpRequest.newBuilder(adressUri)
            .GET()
            .build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        
        //System.out.println(response.body())
        String apiBody = response.body();

// data parse
        Parser parser = new Parser();
        List<Map<String, String>> moviesList = parser.parseJason(apiBody); 

// data exibition        
        for (Map<String,String> map : moviesList) {
            System.out.println(map.get("title"));
            System.out.println(map.get("image"));
            System.out.println(map.get("imDbRating"));
            System.out.println();
        }
    }
}