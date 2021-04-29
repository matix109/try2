package com.company;

public class StudentNotFoundException extends Exception {

    public StudentNotFoundException(String StudentNummer) {
        super("Studentnummer niet gevonden: " + StudentNummer);
    }

}
