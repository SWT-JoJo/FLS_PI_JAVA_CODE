package OOP.Spritpreise;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Verbrauchsrechner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DecimalFormat df_runden = new DecimalFormat("#,###,###,###,###,###,###,##,##0.##");

        System.out.print("Geben sie die Strecke ein: ");
        double strecke = scan.nextDouble();
        System.out.print("Geben sie die Spritmenge ein: ");
        double menge = scan.nextDouble();
        System.out.print("Geben sie den Spritpreis ein: ");
        double preis = scan.nextDouble();


        System.out.println("\n----------------------------------------------------");


        Verbrauch verbrauch = new Verbrauch(strecke, menge, preis);

        System.out.println("Verbrauch pro 100km: " + df_runden.format(verbrauch.verbrauchPro100Km()));
        System.out.println("Kosten pro 100km: " + df_runden.format(verbrauch.kostenPro100Km()));
        System.out.println("Kosten pro 1km: " + df_runden.format(verbrauch.kostenPro1Km()));
        System.out.println("Strecke mit 1 liter: " + df_runden.format(verbrauch.streckeMit1Liter()));

    }
}
