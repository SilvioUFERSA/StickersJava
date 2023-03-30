import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class IMDBContentExtractor implements ContentExtractor {
    
    public List<ContentApi> contentExtractor (String json){
        
        //Extract essencial data
        Parser parser = new Parser();
        List<Map<String, String>> jsonList = parser.parseJason(json);
    
        List<ContentApi> contents = new ArrayList<>();
    
        // fill new list
        for (Map<String, String> jsonAttributs : jsonList) {
            String title = jsonAttributs.get("title");
            String urlImage = jsonAttributs.get("image");

            ContentApi content = new ContentApi(title, urlImage); 
            
            contents.add(content);
        }

        return contents;
    }

}
