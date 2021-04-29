package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Examen {
    private String naam;
    private Integer benodigdePunten;
    private ArrayList<Vraag> vragenLijst = new ArrayList<>();

    private static ArrayList<Examen> examenLijst = new ArrayList<>();

    public Examen(String naam, Integer BenodigdePunten) {
        this.naam = naam;
        this.benodigdePunten = BenodigdePunten;
        examenLijst.add(this);
    }

    public String getNaam() {
        return this.naam;
    }

    public static String getExamenlijst() {
        String result = "";
        for (Examen e : examenLijst) {
            result = result + "Examen: " + e.getNaam() + "\nBenodigde punten: " + e.getBenodigdePunten()+" punten";
        }
        return result;
    }

    public Integer getBenodigdePunten() {
        return this.benodigdePunten;
    }

    public ArrayList<Vraag> getVragenLijst() {
        return vragenLijst;
    }

    public void addVraag(String vraag, String antwoord, int punten) {
        vragenLijst.add(new Vraag(vraag, antwoord, punten));
    }

    public static Examen getExamen(String targetNaam) throws ExamenNotFoundException{
        Examen ret;
        for(int i = 0; i < examenLijst.size(); i++){
            if(examenLijst.get(i).getNaam().equals(targetNaam)){
                ret = examenLijst.get(i);
                return ret;
            }
        }
        throw new ExamenNotFoundException(targetNaam);
    }
    public static void examenAfnemen() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Geef het studentnummer: ");
            int studentNummer5 = scanner.nextInt();
            scanner.nextLine();
            int huidigePunten = 0;

            try {
                Student Studenttarget = Student.getStudent(studentNummer5);

                System.out.print("Voer naam van examen in: ");
                String examenNaam = scanner.nextLine();
                try {

                    Examen examenTarget = Examen.getExamen(examenNaam);
                    boolean gemaakt = Studenttarget.checkIfGemaakt(examenTarget);
                    if (gemaakt) {
                        System.out.println("Examen is al gemaakt!");
                        return;
                    }
                    if (examenTarget != null) {

                        for (int i = 0; i < examenTarget.getVragenLijst().size(); i++) {
                            System.out.println(examenTarget.getVragenLijst().get(i).getVraag());
                            System.out.println("Ja of nee?");
                            String antwoord = scanner.nextLine();
                            if (examenTarget.getVragenLijst().get(i).getAntwoord().equals(antwoord)) {
                                huidigePunten += examenTarget.getVragenLijst().get(i).getPunten();
                            }
                            else {
                                huidigePunten -= examenTarget.getVragenLijst().get(i).getPunten();
                            }
                        }


                        if (huidigePunten >= examenTarget.getBenodigdePunten()) {
                            Student.getStudent(studentNummer5).addGeslaagd(examenTarget);
                            System.out.println("Je bent geslaagd!");
                        } else {
                            Student.getStudent(studentNummer5).addGezakt(examenTarget);
                            System.out.println("Je bent gezakt.");
                        }
                    }
                } catch (ExamenNotFoundException e) {
                    System.out.println(e);
                }
            } catch (StudentNotFoundException e) {
                System.out.println(e);
            }
        }
    }

