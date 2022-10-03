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
    private static final String API_URL = System.getProperty("kanyeApiUrl", "https://api.kanye.rest/");
    private static final Integer MEMORIZED_QUOTE_THRESHOLD = Integer.parseInt(System.getProperty(
        "memorizedQuoteThreshold",
        "1000"
    ));

    private final RestTemplate restTemplate = new RestTemplate();
    private final Set<String> memorizedQuotes = new HashSet<>();

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
            if (quoteWasDisplayed(response)) {
                return fetchQuote(numberOfChecks + 1);
            }
            if (memorizedQuotes.size() <= MEMORIZED_QUOTE_THRESHOLD) {
                memorizedQuotes.add(response.getBody().getQuote());
                return response.getBody();
            } else {
                throw new MemorizedQuotesFullException();
            }
        }
        throw new QuoteServerException();
    }

    private boolean isResponseSuccessful(ResponseEntity<Quote> response) {
        return response.getStatusCode().is2xxSuccessful() && response.hasBody();
    }

    private boolean quoteWasDisplayed(ResponseEntity<Quote> response) {
        return memorizedQuotes.contains(response.getBody().getQuote());
    }
}
