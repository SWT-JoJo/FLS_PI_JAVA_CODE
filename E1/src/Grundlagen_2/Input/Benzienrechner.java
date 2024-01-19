package Grundlagen_2.Input;
import java.util.Scanner;

public class Benzienrechner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bitte geben sie den Kilometerstand beim letzen Tanken ein als Ganzzahl : "); 
        int tankkilometerstand = scanner.nextInt();

        System.out.print("Bitte geben sie den aktuellen Kilometerstand  als Ganzzahl ein: "); 
        int aktuellerkilometerstand = scanner.nextInt();

        System.out.print("Bitte geben sie die Menge des getankten Benzines in Liter als Ganzzahl ein: "); 
        scanner.nextInt();


        int gefahrenekilometer = (aktuellerkilometerstand - tankkilometerstand);
        


        // Ausgeben der Ergebnisse 
        System.out.println("Gefahrene Kilomenter: " + gefahrenekilometer + "KM");
        // System.out.println("Benzinberbrauch " + benzinverbrauch + "L");

        scanner.close();
        
        
    }
}
