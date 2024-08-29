package E1.Grundlagen_2.Input;
import java.util.Scanner;

/**
 * BruttoNettoRechner
 */
public class BruttoNettoRechner {

    public static void main(String[] args){

        // Input abfrage
        Scanner input = new Scanner(System.in);
        System.out.print("Bitte geben sie ihr Brutto Gehalt ein: ");
        double brutto = input.nextDouble();
        
    
        // Berrechnen

        double lohnsteuer = (brutto * 0.14);
        double pflegeversicherung = (brutto * 0.01275);
        double solidaritätszuschlag = (lohnsteuer * 0.055);
        double kirchensteuer = (lohnsteuer * 0.09);
        double rentenversicherung = (brutto * 0.0935);
        double arbeitlosenversicherung = (brutto * 0.03);
        double krankenversicherung = (brutto * 0.073);
        double netto = (brutto - lohnsteuer - pflegeversicherung - solidaritätszuschlag - kirchensteuer - rentenversicherung - arbeitlosenversicherung - krankenversicherung);

        // Ausgeben der Ergebnisse
        System.out.println( "\n " +"Ergebnisse");
        System.out.println("--------------------------------------");
        System.out.println("Lohnsteuer " + lohnsteuer);
        System.out.println("Pflegeversicherung " + pflegeversicherung);
        System.out.println("Solidaritätszuschlag " + solidaritätszuschlag);
        System.out.println("Kirchensteuer " + kirchensteuer);
        System.out.println("Rente " + rentenversicherung);
        System.out.println("Arbeitslosenversicherung " + arbeitlosenversicherung);
        System.out.println("Krankenversicherung " + krankenversicherung);
        System.out.println("Netto: " + netto);
        
        input.close();
    }
}