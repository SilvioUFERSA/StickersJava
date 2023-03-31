import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        String url = "http://localhost:8080/languages";
        ClientRequestHttp http = new ClientRequestHttp(url);

        String apiBody = http.request();

        ContentExtractor extractor = new LanguagesContentExtractor();
        List<ContentApi> contents = extractor.contentExtractor(apiBody);

// data exibition
        StickerGenerate stickers = new StickerGenerate();        
         
        for (int i = 0; i < contents.size() ; i++) {
            ContentApi content = contents.get(i);
        
            InputStream inputStream = new URL(content.getUrlImage()).openStream();
            String fileName =  content.getTitle() + ".png";
        
            stickers.newSticker(inputStream, fileName);
        }
    
    }
}