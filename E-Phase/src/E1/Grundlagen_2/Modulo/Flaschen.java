package E1.Grundlagen_2.Modulo;
import java.util.Scanner;
public class Flaschen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Bitte geben sie die Anzahl an Flaschen an: ");
        int flaschen = scan.nextInt();
        
        System.out.print("Bitte geben sie die Anzahl der Flaschen pro Kasten ein: ");
        int kastenplatz = scan.nextInt();

        System.out.println("Übrige Flaschen: " + (flaschen % kastenplatz));
        scan.close();
    }
}
