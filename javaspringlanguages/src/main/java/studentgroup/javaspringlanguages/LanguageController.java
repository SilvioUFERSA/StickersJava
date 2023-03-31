package studentgroup.javaspringlanguages;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LanguageController {

    @Autowired
    private LanguageRepository repository;
    
    @GetMapping(value = "/languages")
    public List<Language> getLanguages (){
        List<Language> languages = repository.findAll();
        return languages;
    }

    @PostMapping (value ="/languages")
    public Language postLanguage (@RequestBody Language language){
        Language saveLanguage = repository.save(language);
        return saveLanguage;
    }

    @GetMapping(value="/favorit-language")
    public String favoritLanguage(){
        return "My favorit language: Java, by far.";
    }

}
