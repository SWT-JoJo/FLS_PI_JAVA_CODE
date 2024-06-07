package OOP.BMI;

import java.util.Scanner;

public class BMIBerrechnen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("*******************************************************************");
        System.out.println("                            BMI-Rechner                            ");
        System.out.println("*******************************************************************");
        System.out.println();

        System.out.print("Geben sie ihren Namen ein: ");
        String name = scan.next();
        System.out.print("Geben sie ihre Geschlecht ein (w = weiblich, m = männlich): ");
        char geschlecht = scan.next().charAt(0);
        System.out.print("Geben sie ihre Groeße ein (cm): ");
        double groesse = (scan.nextDouble() / 100);
        System.out.print("Geben sie ihr Gewicht ein (kg): ");
        double gewicht = scan.nextDouble();
;

        System.out.println("\n");

        Patient patient1 = new Patient(name,geschlecht, gewicht, groesse);
        patient1.ausgeben();
    }
}
