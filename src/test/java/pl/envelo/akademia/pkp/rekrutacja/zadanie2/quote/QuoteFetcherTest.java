package pl.envelo.akademia.pkp.rekrutacja.zadanie2.quote;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.HashSet;
import java.util.Set;
import org.junit.Ignore;
import org.junit.Test;
import pl.envelo.akademia.pkp.rekrutacja.zadanie2.quote.MemoryQuoteStorage;
import pl.envelo.akademia.pkp.rekrutacja.zadanie2.quote.Quote;
import pl.envelo.akademia.pkp.rekrutacja.zadanie2.quote.QuoteFetcher;

/**
 * Unit tests for quote fetcher.
 */
public class QuoteFetcherTest {

    QuoteFetcher quoteFetcher = new QuoteFetcher(new MemoryQuoteStorage());

    @Test
    public void testFetchQuote() throws Exception {
        final Quote newQuote = quoteFetcher.fetchQuote();
        assertNotNull(newQuote);
        assertNotNull(newQuote.getQuote());
        System.out.println("quote: " + newQuote.getQuote());
    }

    @Test
    public void quoteFetcherShouldAlwaysReturnUniqueQuotes() throws Exception {

        Set<Quote> fetchedQuotes = new HashSet<>();
        for (int i = 0; i < 1000; i++) {
            final Quote quote = quoteFetcher.fetchQuote();
            assertFalse("Quote is not unique", fetchedQuotes.contains(quote));
            fetchedQuotes.add(quote);
        }

    }


}
