package pl.envelo.akademia.pkp.rekrutacja;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cytat {

    @JsonProperty(value = "quote")
    private String cytat;

    public String getCytat() {
        return cytat;
    }

    public void setCytat(String cytat) {
        this.cytat = cytat;
    }
}
