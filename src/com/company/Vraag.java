package com.company;

public class Vraag {
    private String vraag;
    private String antwoord;
    private int punten;

    public Vraag(String vraag, String antwoord,int punten) {
        this.vraag = vraag;
        this.antwoord = antwoord;
        this.punten = punten;
    }

    public String getAntwoord() {
        return antwoord;
    }

    public int getPunten() {
        return punten;
    }

    public String getVraag() {
        return vraag;
    }
}
