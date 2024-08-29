package E1.KontrollStrukturen.SwitchState;

import java.util.Scanner;

public class Temp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double umgerechneteTemp = 0;

        System.out.println("Wollen sie Fahrenheit in Celsius oder umgekehrt umrechnen, geben sie den Starteinheit an:  ");
        String starteinheit = scan.next();

        System.out.println("Geben sie nun die Umzurechnende Temperatur ein: ");
        double eingabeTemp = scan.nextInt();

        switch (starteinheit) {
            case "Fahrenheit":
                umgerechneteTemp = (eingabeTemp - 32) * 5/9;
                break;
            case "Celsius":
                umgerechneteTemp = (eingabeTemp * 1.8 + 32);
                break;
            default:
            System.out.println("Falsche eingabe erneut versuchen");
            main(args);
                break;
        }

        //Runden
        umgerechneteTemp = ((int)((umgerechneteTemp * 100)) / 100.0);

        System.out.println("Ergebniss: " + umgerechneteTemp);

        scan.close();
    }
}
