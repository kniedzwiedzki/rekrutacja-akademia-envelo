package pl.envelo.akademia.pkp.rekrutacja.zadanie2.quote;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Quote {

    @JsonProperty(value = "quote")
    private String quote;

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
}
