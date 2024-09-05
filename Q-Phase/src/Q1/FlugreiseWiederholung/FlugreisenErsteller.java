package Q1.FlugreiseWiederholung;

import java.util.Scanner;

public class FlugreisenErsteller {

    public static void main(String[] args) {

        Flugreise flug1 = new Flugreise(50,"Lufthansa", "A350-900","LH538" );

        flug1.datenausgabe();


        System.out.println("\n");
        System.out.println("Buchen sitz 4");
        System.out.println("Status ihere Buchung: " + flug1.sitzplatzreservierung(4));
        System.out.println();
        System.out.println("Buchen sitz 50");
        System.out.println("Status ihere Buchung: " + flug1.sitzplatzreservierung(50));
        System.out.println();
        System.out.println("Buchen sitz 4");
        System.out.println("Status ihere Buchung: " + flug1.sitzplatzreservierung(4));
        System.out.println();
        System.out.println("Buchen sitz 1");
        System.out.println("Status ihere Buchung: " + flug1.sitzplatzreservierung(1));
        System.out.println("\n");


        Flugreise flug2 = new Flugreise(500,"Delta", "B777-8","D458" );
        flug2.datenausgabe();
    }

}
