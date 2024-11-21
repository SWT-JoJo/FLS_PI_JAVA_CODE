package Q1.Vererbung.Schule;
import  java.time.*;

import java.util.Scanner;

public class Schule {
    protected String name , vorname;
    protected int gebJahr;


    public void setStamm(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Geben sie die Schülerdaten ein ");
        System.out.print("Name: ");
        name = scan.next();
        System.out.print("Vorname: ");
        vorname = scan.next();
        System.out.print("GeburtsJahr: ");
        gebJahr = scan.nextInt();

    }

    public int alterBestimmen(){
        return Year.now().getValue() - gebJahr;
    }

    public void datenAusgeben(){
        System.out.println("----| Schüler-Daten |----");
        System.out.println("Name: \t\t\t" + name);
        System.out.println("Vorame: \t\t" + vorname);
        System.out.println("Geburtsjahr: \t" + gebJahr);
    }

}