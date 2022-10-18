package pl.envelo.akademia.pkp.rekrutacja.zadanie2.quote;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

public class Quote {

    @JsonProperty(value = "quote")
    private String quote;

    public Quote() {
    }
    public Quote(String quote) {
        this.quote = quote;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Quote quote1 = (Quote) o;

        return Objects.equals(quote, quote1.quote);
    }

    @Override
    public int hashCode() {
        return quote != null ? quote.hashCode() : 0;
    }
}
