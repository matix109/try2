package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    private ArrayList<Examen> slaagt;
    private ArrayList<Examen> zakt;
    private String naamStudent;
    private Integer studentNummer;
    private static ArrayList<Student> studentenLijst = new ArrayList<>();

    public Student(String naamStudent, Integer studentNummer) {
        this.slaagt = new ArrayList<Examen>();
        this.zakt = new ArrayList<Examen>();
        this.naamStudent = naamStudent;
        this.studentNummer = studentNummer;
        boolean a = true;

        for (int i = 0; i < studentenLijst.size(); i++) {
            if (studentenLijst.get(i).getStudentNummer().equals(studentNummer)) {
                a = false;
            }
        }
        if (a) {
            studentenLijst.add(this);
        }
    }

    public String getName() {
        return naamStudent;
    }

    public Integer getStudentNummer() {
        return studentNummer;
    }

    public static void printStudentLijst() {
        System.out.println();
        for (int i = 0; i < studentenLijst.size(); i++) {
            System.out.println(studentenLijst.get(i).getName());
            System.out.println(studentenLijst.get(i).getStudentNummer());
            System.out.println();
        }
    }

    public static void removeStudentFromLijst(Integer studentNummer) throws StudentNotFoundException {
        boolean a = true;
        for (int i = 0; i < studentenLijst.size(); i++) {
            if (studentenLijst.get(i).getStudentNummer().equals(studentNummer)) {
                studentenLijst.remove(i);
                a = false;
            }
        }
        if(a) {
            throw new StudentNotFoundException(studentNummer.toString());
        }
        }

    public void printGeslaagdeExamens() {
        for (int i = 0; i < slaagt.size(); i++) {
            System.out.println(slaagt.get(i).getNaam());
        }
    }

    public void addGeslaagd(Examen examen) {
        slaagt.add(examen);
    }

    public void addGezakt(Examen examen) {
        zakt.add(examen);
    }

    public static ArrayList<Student> getStudentenLijst() {
        ArrayList<Student> ret = studentenLijst;
        return ret;
    }

    public ArrayList<Examen> getSlaagt() {
        ArrayList<Examen> ret = slaagt;
        return ret;
    }

    public ArrayList<Examen> getZakt() {
        ArrayList<Examen> ret = zakt;
        return ret;

    }
    public boolean checkIfGemaakt(Examen x){
    for (int a = 0; a < this.getSlaagt().size(); a++) {

        if(this.getSlaagt().get(a).equals(x)){
return true;
}
        }
        for (int i = 0; i < this.getZakt().size(); i++){
            if(this.getZakt().get(i).equals(x)){
                return true;
            }
            }
    return false;
    }

    public static boolean checkDubbel(Integer studentNummer) {
        for (int i = 0; i < studentenLijst.size(); i++) {
            if (studentenLijst.get(i).getStudentNummer().equals(studentNummer)) {
                return true;
            }
        }
        return false;
    }

    public static Student getStudent(Integer studentNummer) throws StudentNotFoundException {
        for (int i = 0; i < studentenLijst.size(); i++) {
            if (studentenLijst.get(i).getStudentNummer().equals(studentNummer)) {
                return studentenLijst.get(i);
            }
        }
        throw new StudentNotFoundException(studentNummer.toString());
    }
    public static void isStudentGeslaagd(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Geef het studentnummer: ");
        int studentNummer3 = scanner.nextInt();

        try {
            Student target = Student.getStudent(studentNummer3);


            if (target != null) {
                boolean n = true;
                scanner.nextLine();
                System.out.print("Geef de naam van het examen: ");
                String examenNaam = scanner.nextLine();

                for (int a = 0; a < target.getSlaagt().size(); a++) {

                    if (target.getSlaagt().get(a).getNaam().equalsIgnoreCase(examenNaam)) {
                        System.out.print(Student.getStudent(studentNummer3).getName() + " is voor " + examenNaam + " geslaagd! ");
                        n = false;
                    }
                }
                for (int i = 0; i < target.getZakt().size(); i++) {
                    if (target.getZakt().get(i).getNaam().equalsIgnoreCase(examenNaam)) {
                        System.out.print(Student.getStudent(studentNummer3).getName() + " is voor " + examenNaam + " gezakt. ");
                        n = false;
                    }

                }
                if (n) {
                    System.out.print(Student.getStudent(studentNummer3).getName() + " heeft " + examenNaam + " nog niet gemaakt. ");
                }
            }
        } catch (StudentNotFoundException e) {
            System.out.println(e);
        }
    }
}
