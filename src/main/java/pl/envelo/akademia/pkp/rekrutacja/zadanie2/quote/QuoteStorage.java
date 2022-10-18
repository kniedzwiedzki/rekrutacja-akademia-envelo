package pl.envelo.akademia.pkp.rekrutacja.zadanie2.quote;

import pl.envelo.akademia.pkp.rekrutacja.zadanie2.quote.exception.MemorizedQuotesFullException;

public interface QuoteStorage {

    void store(Quote quote) throws MemorizedQuotesFullException;

   boolean contains(Quote quote);


}
