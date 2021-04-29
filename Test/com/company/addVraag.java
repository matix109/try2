package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class getExamen{

    @Test
    void getExamenTest() {
        try {
            Examen enn = new Examen("Frans", 5);
            Examen Expected = enn;
            Examen Actual = Examen.getExamen("Frans");
            assertSame(Expected, Actual);
        } catch (ExamenNotFoundException e) {
            System.out.println(e);
        }
    }
}
    class addVraagTest {
        @Test
        void addVraag(){
            Examen enn = new Examen("Frans", 5);
            int Expected = 1;
            enn.addVraag("test","test",1);
            int Actual=  enn.getVragenLijst().size();
            assertEquals(Expected,Actual);
        }

    }

