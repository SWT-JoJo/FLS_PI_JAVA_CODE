package E1.KontrollStrukturen.SwitchState;

import java.util.Scanner;

public class tanken {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double preis = 0;
        System.out.println("N = Normal \n S = Super \n D  Diesel");
        System.out.print("Welchen Treibstoff wollen sie tanken: ");
        char treibstroffsorte  = scan.nextLine().charAt(0);

        System.out.print("Wie viele Liter: ");
        int liter = scan.nextInt();

        switch (treibstroffsorte) {
            case 'N':
                preis =  ((int)((1.9 * liter) * 100))/100.0;
                break;
            case 'S':
                preis =  ((int)((1.99 * liter) * 100))/100.0;
                break;
            case 'D':
                preis =  ((int)((2.05 * liter) * 100))/100.0;
                break;            
            default:
                System.out.println("Error: konnt nicht berechnet werden ");
                System.exit(0);
                
                break;
        }

        System.out.println("Der zu Zahlende Betrag ist: " + preis + " Euro");

        scan.close();
    }
}


