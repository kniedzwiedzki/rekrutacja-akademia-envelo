package pl.envelo.akademia.pkp.rekrutacja.zadanie2.quote;

import java.util.HashSet;
import java.util.Set;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import pl.envelo.akademia.pkp.rekrutacja.zadanie2.quote.exception.MemorizedQuotesFullException;
import pl.envelo.akademia.pkp.rekrutacja.zadanie2.quote.exception.NewQuotesNotAvailableException;
import pl.envelo.akademia.pkp.rekrutacja.zadanie2.quote.exception.QuoteServerException;

public class QuoteFetcher {

    private static final int MAX_NEW_QUOTE_REPEATED_CHECKS = 200;
    //TODO: posprzątać

    private static final String API_URL = System.getProperty("kanyeApiUrl", "https://api.kanye.rest/");

    private final QuoteStorage quoteStorage;
    private final RestTemplate restTemplate = new RestTemplate();

    public QuoteFetcher(QuoteStorage quoteStorage) {
        this.quoteStorage = quoteStorage;
    }

    public Quote fetchQuote() throws NewQuotesNotAvailableException, MemorizedQuotesFullException,
        QuoteServerException {
        return fetchQuote(0);
    }

    Quote fetchQuote(int numberOfChecks) throws NewQuotesNotAvailableException, MemorizedQuotesFullException,
        QuoteServerException {
        if (numberOfChecks >= MAX_NEW_QUOTE_REPEATED_CHECKS) {
            throw new NewQuotesNotAvailableException();
        }

        final ResponseEntity<Quote> response = restTemplate.getForEntity(API_URL, Quote.class);

        if (isResponseSuccessful(response)) {

            if (quoteStorage.contains(response.getBody())) {
                return fetchQuote(numberOfChecks + 1);
            }

            quoteStorage.store(response.getBody());
            return response.getBody();

        }
        throw new QuoteServerException();
    }



    private boolean isResponseSuccessful(ResponseEntity<Quote> response) {
        return response.getStatusCode().is2xxSuccessful() && response.hasBody();
    }

}
