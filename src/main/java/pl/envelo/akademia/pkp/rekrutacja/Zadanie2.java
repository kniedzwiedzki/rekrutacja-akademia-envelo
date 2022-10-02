package pl.envelo.akademia.pkp.rekrutacja;

import java.util.HashSet;
import java.util.Set;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Zadanie2 {

    private final RestTemplate restTemplate = new RestTemplate();
    private final Set<String> zapamietaneCytaty = new HashSet<>();

    Cytat pobierzCytat() {
        final ResponseEntity<Cytat> odpowiedz = restTemplate.getForEntity("https://api.kanye.rest/", Cytat.class);
        if (odpowiedz.getStatusCode().is2xxSuccessful() && odpowiedz.hasBody()) {
            if (zapamietaneCytaty.contains(odpowiedz.getBody().getCytat())){
                return pobierzCytat();
            }
            return odpowiedz.getBody();
        }
        return null;
    }
}
