package OOP.Formen;

import java.text.DecimalFormat;
import java.util.Scanner;

public class SteuerungFormen {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        DecimalFormat df_zahlen = new DecimalFormat("#,###,###,##0.00");

        double flaeche;
        double umfang;

        //Header
        System.out.println("*****************************************");
        System.out.println("*             FormenRechner             *");
        System.out.println("*****************************************");

        int zuBerrechnen;
        do{
            System.out.print("Was wollen sie berrechnen( 1: Rechteck, 2: Kreis): ");
            zuBerrechnen= scan.nextInt();
            if (zuBerrechnen < 1 || zuBerrechnen > 2) {
                System.out.println("ERROR: Falsche EINGABE");
            }
        }
        while (zuBerrechnen < 1 || zuBerrechnen > 2);

        System.out.println();

        if(zuBerrechnen == 1){
            Rechteck rechteck = new Rechteck();
            System.out.println("|-------------- Rechteck --------------|");

            System.out.print("Höhe: ");
            double height = scan.nextDouble();
            System.out.print("Breite: ");
            double width = scan.nextDouble();


            umfang = rechteck.umfang(height, width);
            flaeche = rechteck.flache(height,width);
        }
        else{
            Kreis kreis = new Kreis();
            System.out.println("|-------------- Keis --------------|");
            System.out.print("Radius: ");
            double radius = scan.nextDouble();

            flaeche = kreis.flaeche(radius);
            umfang = kreis.umfang(radius);

        }

        System.out.println();
        System.out.println("Flaeche:  " + df_zahlen.format(flaeche));
        System.out.println("Umfang:   " + df_zahlen.format(umfang));

    }
}
