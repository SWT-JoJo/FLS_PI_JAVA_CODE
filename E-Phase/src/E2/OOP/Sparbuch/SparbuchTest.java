package E2.OOP.Sparbuch;

import java.text.DecimalFormat;
import java.util.Scanner;

public class SparbuchTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Sparbuch sparbuch = new Sparbuch();
        DecimalFormat df_money = new DecimalFormat("#,###,###,###,###,##0.### EUR");

        double summeBuchungen = 0;
        int anzBuchungen = 0;

        System.out.println("*****************************************");
        System.out.println("*             OnlineBanking            *");
        System.out.println("*****************************************");
        System.out.println();

        System.out.println("Akuteller Firmen-Kontostand: " + df_money.format(sparbuch.getKontostand()));

        System.out.print("Bitte geben sie ihren Namen ein: ");
        sparbuch.setName(scan.next());

        boolean buchenDurchfuehren = true;
        while (buchenDurchfuehren){

            System.out.print("Geben sie den betrag zum Buchen ein (negative Beträg sind abbuchungen): ");
            double betrag = scan.nextDouble();

            System.out.println("\n");
            if(sparbuch.getKontostand() >= (betrag * -1)) {
                sparbuch.buchen(betrag);

                anzBuchungen ++;
                summeBuchungen += betrag;
                System.out.println("Status: Buchung erfolgreich ");
                System.out.println("Neuer Kontostand:" + df_money.format(sparbuch.getKontostand()));
                System.out.println("Buchung durchgeführt von: " + sparbuch.getName());
                System.out.println("Gebuchterbetrag: " + df_money.format(betrag));
            }
            else {
                System.out.println("Buchung fehlgeschlagen");
            }

            System.out.println("\n\nWollen sie eine weitere Buchung durchführen(Y/N)");
            char selection = scan.next().charAt(0);

            if(selection != 'y' && selection != 'Y' ) buchenDurchfuehren = false;
            System.out.println("\n --------------------------------------------------\n");
        }

        System.out.println("Summe der Buchungen: " + df_money.format(summeBuchungen));
        System.out.println("Anzahl der Buchungen: " + anzBuchungen);
        System.out.println("Zinsen: " + df_money.format(sparbuch.zinsenBerrechnen()));
        System.out.println("Auf wiedersehen " + sparbuch.getName());
        

    }
}
