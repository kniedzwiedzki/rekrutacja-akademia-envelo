package pl.envelo.akademia.pkp.rekrutacja.zadanie2.quote;

import pl.envelo.akademia.pkp.rekrutacja.zadanie2.quote.exception.MemorizedQuotesFullException;

public class MemoryQuoteStorage implements QuoteStorage {
    @Override
    public void store(Quote quote) throws MemorizedQuotesFullException {

    }

    @Override
    public boolean contains(Quote quote) {
        return false;
    }
}
