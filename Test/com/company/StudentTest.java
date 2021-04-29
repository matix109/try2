package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class getStudentTest{
    @Test
    void getStudent(){
        try{
            Student jan = new Student("Jan",12345678);
            Student expected = jan;
            Student Actual = Student.getStudent(12345678);
            assertEquals(expected,Actual);
        }
        catch (StudentNotFoundException e) {
            System.out.println(e);
        }
    }
}

class StudentTest {
        Student jan = new Student("Jan",12345678);

    @Test
    void removeStudentFromLijstTest(){
        try{
         int Expected = 0;
         Student.removeStudentFromLijst(12345678);
         int Actual = Student.getStudentenLijst().size();
         assertEquals(Expected,Actual);
        }
        catch (StudentNotFoundException e) {
            System.out.println(e);
        }
    }
    @Test
    void addGeslaagdTest(){
        Examen enn = new Examen("Frans", 5);
        int Expected = 1;
        jan.addGeslaagd(enn);
        int Actual = jan.getSlaagt().size();
        assertEquals(Expected,Actual);
    }
    @Test
    void addGezaktTest(){
        Examen enn = new Examen("Frans", 5);
        int Expected = 1;
        jan.addGezakt(enn);
        int Actual = jan.getZakt().size();
        assertEquals(Expected,Actual);
    }
    @Test
    void checkIfGemaakt(){
        Examen enn = new Examen("Frans", 5);
        boolean Expected = jan.checkIfGemaakt(enn);
        assertFalse(Expected);
    }
    @Test
    void checkDubbel(){
        boolean Expected = Student.checkDubbel(12345678);
        assertTrue(Expected);
    }


}
