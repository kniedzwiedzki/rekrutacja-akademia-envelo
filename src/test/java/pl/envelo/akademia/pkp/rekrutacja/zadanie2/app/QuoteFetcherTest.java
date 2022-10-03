package pl.envelo.akademia.pkp.rekrutacja.zadanie2.app;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import pl.envelo.akademia.pkp.rekrutacja.zadanie2.quote.Quote;
import pl.envelo.akademia.pkp.rekrutacja.zadanie2.quote.QuoteFetcher;

/**
 * Unit tests for quote fetcher.
 */
public class QuoteFetcherTest {

    QuoteFetcher quoteFetcher = new QuoteFetcher();

    @Test
    public void testFetchQuote() throws Exception {
        final Quote newQuote = quoteFetcher.fetchQuote();
        assertNotNull(newQuote);
        assertNotNull(newQuote.getQuote());
        System.out.println("quote: " + newQuote.getQuote());
    }


}
