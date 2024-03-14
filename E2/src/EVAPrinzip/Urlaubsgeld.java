package EVAPrinzip;

import java.time.Year;
import java.util.Scanner;

public class Urlaubsgeld {

    int zulage1 = 10;
    int zulage2 = 75;
    int Fixum1 = 75;
    int Fixum2 = 25;


    int dienstjahre;
    String name;
    int geburtsjahr;
    final int AKUTELLESJAHR = Year.now().getValue();
    int alter;

    int auszahlung;

    public static void main(String[] args) {
        Urlaubsgeld urlaubsgeld = new Urlaubsgeld();

        urlaubsgeld.eingabe();
        urlaubsgeld.verarbeitung();
        urlaubsgeld.ausgabe();
    }
    void titel() {
        System.out.println("*******************************************************************");
        System.out.println("*                            Urlaubsgeld                          *");
        System.out.println("*******************************************************************");
        System.out.println();
    }
    void eingabe(){
        Scanner scan = new Scanner(System.in);
        titel();

        System.out.print("Geben sie den Namen ein: ");
        name = scan.nextLine();
        System.out.print("Geben sie die Anzahl der Dienstjahre von " + name + " ein: ");
        dienstjahre = scan.nextInt();
        System.out.print("Geben sie das Geburtsjahr (yyyy) von " + name + " ein: ");
        geburtsjahr  = scan.nextInt();
    }
    void verarbeitung(){
        //checking if year Input is valid
        if(String.valueOf(geburtsjahr).length() != 4){
            System.out.println("ERROR: INVALID YEAR INPUT");
            System.out.println("YOU HAVE TO DO YOU INPUT AGAIN :)");
            eingabe();
        }
        else {
            alter = AKUTELLESJAHR - geburtsjahr;
        }
        if(dienstjahre >= 5 && alter < 50){
            auszahlung = Fixum1 + zulage1 * dienstjahre;
        }
        else if (dienstjahre >= 5 && alter >= 50) {
            auszahlung = (Fixum1 + zulage1 * dienstjahre ) + zulage2;
        }
        else if (dienstjahre >= 2) {
            auszahlung =  Fixum2;
        }
        else{
            auszahlung = 0;
        }


    }
    void ausgabe(){
        System.out.println();
        System.out.println(name + " ist " + alter + " Jahre alt und erhielt " + auszahlung + " EURO Urlaubsgeld" );
    }
}

