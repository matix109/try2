package com.company;
import java.util.ArrayList;
import java.util.Scanner;


class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        Examen enn = new Examen("Frans", 5);
        enn.addVraag("Zeg ja","ja",5);
        enn.addVraag("Zeg nee","Nee",3);
        int verder = 1;
        while(verder != 0) {
            Menu.printMenu();
            System.out.println("Wilt u verder?");
            System.out.println("1) Ja");
            System.out.println("0) Stoppen");
            verder = scanner.nextInt();
            }
    }
}