package E2.EVA_Methoden;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Annunitaet {
    int zinssatz;
    int tilgungssatz;
    double restkapital;
    double anfangskapital;
    double zinsen;
    double tilgung;
    double annunitaet;
    int jahr = 0;
    int kredit;

    double summeZinsen = 0;
    double summeTilgung = 0;
    double summeAnnunitaet = 0;

    boolean runProgramm = true;
    public static void main(String[] args) {
        Annunitaet annunitaet = new Annunitaet();
        while (annunitaet.runProgramm) {
            annunitaet.titel();
            annunitaet.eingabe();
        }
        //ausgabe wird in der verarbeitung aufgerufen
    }

    void  titel(){
        System.out.println("*******************************************************************");
        System.out.println("*                            Annunität                            *");
        System.out.println("*******************************************************************");
        System.out.println();
    }
    void eingabe(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Geben sie den Kreditbetrag ein: ");
        kredit = scan.nextInt();
        System.out.print("Geben sie den Zinssatz ein (%): ");
        zinssatz = scan.nextInt();
        System.out.print("Geben sie den Anfänglichen Tilgungssatz ein (%): ");
        tilgungssatz = scan.nextInt();

        verarbeitung();
    }

    void verarbeitung(){
        anfangskapital = kredit;
        while (anfangskapital > 0){
            zinsen = anfangskapital * (zinssatz/100.0);

            //Annunität NUR im 1. Jahr berrechnen
            if(jahr == 0){
                annunitaet = (anfangskapital * (tilgungssatz/100.0)) + zinsen;
            }

            tilgung = (annunitaet - zinsen);
            restkapital = anfangskapital - tilgung;

            //LetzesJahr wenn das anfangskapital kleiner als die annunität ist
            if (anfangskapital <= annunitaet) {
                tilgung = anfangskapital;
                annunitaet = tilgung + zinsen;
                restkapital = 0;
            }

            jahr ++;
            summeTilgung += tilgung;
            summeZinsen += zinsen;
            summeAnnunitaet += annunitaet;

            ausgabe();
            anfangskapital = restkapital;
        }
    }

    void ausgabe() {
        Scanner scan = new Scanner(System.in);
        DecimalFormat df_euroFormat = new DecimalFormat("#,##0.00 Euro");
        DecimalFormat df_prozentFormat = new DecimalFormat("#0.0%");
        if(jahr == 1){

            System.out.println("Kreditbetrag: " + df_euroFormat.format(kredit));
            System.out.println("Zinssatz: " + df_prozentFormat.format(zinssatz));
            System.out.println();

            System.out.println("Jahr\t\t|\t\tAnfangskapital\t\t|\t\tZinsen\t\t|\t\tTilgung\t\t|\t\tAnnunität\t\t|\t\tRestkapital");
        }

        System.out.println(jahr+"\t\t|\t\t"+df_euroFormat.format(anfangskapital)+"\t\t|\t\t"+df_euroFormat.format(zinsen)+"\t\t|\t\t "+df_euroFormat.format(tilgung)+"\t\t|\t\t"+df_euroFormat.format(annunitaet)+"\t\t|\t\t "+df_euroFormat.format(restkapital));


        if(restkapital == 0){
            System.out.println("Summe Zinsen: " + df_euroFormat.format(summeZinsen) + " (= "  + df_prozentFormat.format(summeZinsen/kredit) +" vom ursprünglichen Kreditbetrag)");
            System.out.println("Summe Tilgung: " + df_euroFormat.format(summeTilgung));
            System.out.println("Summe Annunitaet: " + df_euroFormat.format(summeAnnunitaet));
            System.out.println();

            System.out.print("Neue Berrechnung durchführen? (Y/N)");
            String input = scan.next();
            if(input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("Yes")){
                System.out.println("Loading...\n\n");
                runProgramm = true;
            }
            else{
                runProgramm = false;
                System.out.println("GoodBye :)");
            }


        }
    }
}