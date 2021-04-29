package com.company;

import java.util.Scanner;

public class Menu {
    public static int printKeuzes() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Menu");
        System.out.println("1) Lijst met examens");
        System.out.println("2) Lijst met studenten");
        System.out.println("3) Nieuwe student inschrijven");
        System.out.println("4) Student verwijderen");
        System.out.println("5) Examen afnemen");
        System.out.println("6) Is student geslaagd voor test?");
        System.out.println("7) Welke examens heeft student gehaald?");
        System.out.println("8) Welke student heeft de meeste examens gehaald?");
        System.out.println("0) Exit");
        System.out.print("Uw keuze: ");
        int choice = scanner.nextInt();
        return choice;
    }

    public static void printMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice = printKeuzes();
        switch (choice) {
            case 0:
                return;
            case 1:
                System.out.println("Lijst met examens");
                System.out.println(Examen.getExamenlijst());
                break;
            case 2:
                System.out.println("Lijst met studenten");
                Student.printStudentLijst();
                break;
            case 3:
                System.out.print("Geef je  naam: ");
                String student = scanner.next();

                boolean oke = false;

                while (oke == false) {

                    System.out.print("Geef je studentnummer: ");
                    int studentNummer = scanner.nextInt();

                    boolean a = Student.checkDubbel(studentNummer);

                    if (a == false && String.valueOf(studentNummer).length() == 8) {
                        new Student(student, studentNummer);
                        System.out.println("Student succesvol aangemaakt");
                        oke = true;
                    }
                    else {
                        System.out.println("Studentnummer is te kort/lang OF het studentnummer bestaat al");
                    }
                }
                break;
            case 4:
                try{
                System.out.print("Geef het studentnummer: ");
                int studentNummer2 = scanner.nextInt();
                String uitvoer = Student.getStudent(studentNummer2).getName()+" is uit de lijst verwijderd.";
                    Student.removeStudentFromLijst(studentNummer2);
                    System.out.println(uitvoer);
                }
                catch (StudentNotFoundException e) {
                    System.out.println(e);
                }

                break;
            case 5:
                Examen.examenAfnemen();
                break;
            case 6:
                Student.isStudentGeslaagd();
                break;
            case 7:
                System.out.print("Geef het studentnummer: ");
                int studentNummer4 = scanner.nextInt();
                try {
                    Student target2 = Student.getStudent(studentNummer4);
                    System.out.println("Dit zijn de geslaagde examens van " + target2.getName());
                    target2.printGeslaagdeExamens();
                } catch (StudentNotFoundException e) {
                    System.out.println(e);
                }
                break;
            case 8:
                int grootsteLijst = 0;
                for (int i = 0; i < Student.getStudentenLijst().size(); i++) {
                    if (Student.getStudentenLijst().get(i).getSlaagt().size() > grootsteLijst) {
                        grootsteLijst = Student.getStudentenLijst().get(i).getSlaagt().size();
                    }
                }
                for (int i = 0; i < Student.getStudentenLijst().size(); i++) {
                    if (Student.getStudentenLijst().get(i).getSlaagt().size() == grootsteLijst) {
                        System.out.println(Student.getStudentenLijst().get(i).getName() + " heeft de meeste examens gehaald met "+ Student.getStudentenLijst().get(i).getSlaagt().size()+" examens.");
                    }
                }
                break;
            default:
                System.out.println("Kies cijfer 1 t/m 8");
        }
    }

}
