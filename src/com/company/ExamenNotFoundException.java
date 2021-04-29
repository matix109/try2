package com.company;

public class ExamenNotFoundException extends Exception{

    public ExamenNotFoundException(String Examennaam) {
        super("Examen niet gevonden: " + Examennaam);
    }
}
