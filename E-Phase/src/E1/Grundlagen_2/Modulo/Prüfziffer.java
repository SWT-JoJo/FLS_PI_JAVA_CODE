package E1.Grundlagen_2.Modulo;

import java.util.Scanner;

public class Prüfziffer {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int ziffer1, ziffer2, ziffer3, ziffer4; //Deklaration der ziffern  1 - 4


        //Initialisierung durch abfrage der einzelnen Ziffern

        System.out.print("Bitte geben sie die erst ziffer ein: "); 
        ziffer1 = scan.nextInt();

         System.out.print("Bitte geben sie die zweite ziffer ein: "); 
        ziffer2 = scan.nextInt();

        System.out.print("Bitte geben sie die dritte ziffer ein: "); 
        ziffer3 = scan.nextInt();

        System.out.print("Bitte geben sie die vierte ziffer ein: "); 
        ziffer4 = scan.nextInt();

        int summe = (ziffer1 + ziffer2 + ziffer3 + ziffer4); // Ausrechen der Summe

        System.out.println("Prüfziffer: " + (summe % 3)); // Ausgabe und berechnung des Restes/ der Prüfziffer

        scan.close();

    }
}
