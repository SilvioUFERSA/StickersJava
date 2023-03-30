import java.io.InputStream;
import java.net.URI;
import java.net.URL;
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
        StickerGenerate stickers = new StickerGenerate();        
        for (Map<String,String> map : moviesList) {
            
            String urlImage = map.get("image");
            String title = map.get("title");

            InputStream inputStream = new URL(urlImage).openStream();
            String fileName = title.replace(":", "-")  + ".png";

            stickers.newSticker(inputStream, fileName);
        }
    
    }
}