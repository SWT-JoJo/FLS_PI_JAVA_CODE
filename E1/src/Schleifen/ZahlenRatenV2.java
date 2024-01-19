package Schleifen;

import java.util.Scanner;

public class ZahlenRatenV2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Variablen Deklarieren
        int obergrenze ;
        int versuche = 1;
        int zahl;
        int userZahl = -1;

        //Spiel starten
        System.out.print("Bitte geben sie die Obergrenze ein: ");
        obergrenze = scan.nextInt();

        zahl = (int) (Math.random() * obergrenze);

        while (userZahl != zahl){
            System.out.print("Versuch: " + versuche + " Ihr Tipp: ");
            userZahl = scan.nextInt();

            if(userZahl < zahl){
                System.out.println("Tipp: Meine Zahl ist größer");
            } else if (userZahl > zahl){
                System.out.println("Tipp: Meine Zahl ist kleiner");
            }

            versuche ++;
            }

        System.out.println("Sie haben gewonnen und  " + versuche + " versuche gebraucht");
    }

}
