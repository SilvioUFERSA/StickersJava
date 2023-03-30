import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;


public class ClientRequestHttp {
    
        private final String url;
    
        public ClientRequestHttp(String url) {
            this.url = url;
        }

        public String request() {
            try {
                URI adressUri = URI.create(this.url);

                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder(adressUri)
                    .GET()
                    .build();
                HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
                
                String apiBody = response.body();
    
                return apiBody;
                
            } catch (IOException | InterruptedException exception) {
                throw new RuntimeException(exception);
            }
        }
    
        public String getUrl() {
            return url;
        }
    
}

