package Methoden;

import java.util.Scanner;

public class BußgeldKatalog {

    //Ort

    int ortNumber;

    //Geschwindigkeit
    int geschwndigkeit;
    final int TOLERANZ = 3;
    int hoehstgeschwindigkeit;
    int überschreitung;
    //Strafen
    String bussgeld;
    String strafpunkte;
    String fahrverbot;
    //Kataloge
    String[][] katalogImOrt = {
            {"15 Euro Bußgeld", "0 Strafpunkte", "kein Fahrverbot"},   // bis 10
            {"25 Euro Bußgeld", "0 Strafpunkte", "kein Fahrverbot"},   // 10 -15
            {"35 Euro Bußgeld", "0 Strafpunkte", "kein Fahrverbot"},   //15 - 20
            {"80 Euro Bußgeld", "1 Strafpunkte", "kein Fahrverbot"},   //20 - 25
            {"100 Euro Bußgeld", "1 Strafpunkte", "kein Fahrverbot"},   //25 - 30
            {"160 Euro Bußgeld", "2 Strafpunkte", "1 Monat Fahrverbot"},   // 30 - 40
            {"200 Euro Bußgeld", "2 Strafpunkte", "1 Monat Fahrverbot"},   //40 - 50
            {"280 Euro Bußgeld", "2 Strafpunkte", "2 Monate Fahrverbot"},   //50 - 60
            {"480 Euro Bußgeld", "2 Strafpunkte", "3 Monate Fahrverbot"},   //60 - 70
            {"680 Euro Bußgeld", "2 Strafpunkte", "3 Monate Fahrverbot"},   //70+
    };
    String[][] katlogAusserOrts = {
            {"10 Euro Bußgeld", "0 Strafpunkte", "kein Fahrverbot"},   // bis 10
            {"20 Euro Bußgeld", "0 Strafpunkte", "kein Fahrverbot"},   // 10 -15
            {"30 Euro Bußgeld", "0 Strafpunkte", "kein Fahrverbot"},   //15 - 20
            {"70 Euro Bußgeld", "1 Strafpunkte", "kein Fahrverbot"},   //20 - 25
            {"80 Euro Bußgeld", "1 Strafpunkte", "kein Fahrverbot"},   //25 - 30
            {"120 Euro Bußgeld", "1 Strafpunkte", "kein Fahrverbot"},   // 30 - 40
            {"160 Euro Bußgeld", "2 Strafpunkte", "1 Monat Fahrverbot"},   //40 - 50
            {"240 Euro Bußgeld", "2 Strafpunkte", "1 Monate Fahrverbot"},   //50 - 60
            {"440 Euro Bußgeld", "2 Strafpunkte", "2 Monate Fahrverbot"},   //60 - 70
            {"600 Euro Bußgeld", "2 Strafpunkte", "3 Monate Fahrverbot"},   //70+
    };


    public static void main(String[] args) {
        BußgeldKatalog bußgeldKatalog = new BußgeldKatalog();
        bußgeldKatalog.titel();
        bußgeldKatalog.eingabe();
        bußgeldKatalog.verarbeitung();
        bußgeldKatalog.ausgabe();
    }

    void titel() {
        System.out.println("*******************************************************************");
        System.out.println("***                        Bußgeld Katalog                      ***");
        System.out.println("*******************************************************************");
        System.out.println();
    }

    void eingabe() {
        System.out.println("Ausgabe");
        System.out.println("*******");
        System.out.println();
        Scanner scan = new Scanner(System.in);

        System.out.println("Geben sie an wo sie die Geschwindigkeitsüberschreitung begangen haben: ");
        System.out.println("[1]: innerhalb einer Ortschaft:+");
        System.out.println("[2]: außerhalb einer Ortschaft (Landstraße, Autobahn,..) ");
        System.out.print("Geben sie bitte die passende Kennzahl ein: ");
        ortNumber = scan.nextInt();
        System.out.print("Geben sie die maximal zugelassene Geschwindigkeit an (km/h): ");
        hoehstgeschwindigkeit = scan.nextInt();
        System.out.println("Was war ihre geschwindigkeit (km/h): ");
        geschwndigkeit = scan.nextInt();

    }

    void verarbeitung() {
        überschreitung = geschwndigkeit - TOLERANZ - hoehstgeschwindigkeit;
        //Auswahl des passenden Kataloges
        if (überschreitung <= 0) {
            System.out.println("Eingabe");
            System.out.println("*******");
            System.out.println("Sie haben keinen Verstoß begangen :)");
            System.exit(0);
        }
        switch (ortNumber) {
            case 1: //1 = Im Ort
                if (überschreitung >= 70) {
                    bussgeld = katalogImOrt[9][0];
                    strafpunkte = katalogImOrt[9][1];
                    fahrverbot = katalogImOrt[9][2];
                } else if (überschreitung >= 60) {
                    bussgeld = katalogImOrt[8][0];
                    strafpunkte = katalogImOrt[8][1];
                    fahrverbot = katalogImOrt[8][2];
                } else if (überschreitung >= 50) {
                    bussgeld = katalogImOrt[7][0];
                    strafpunkte = katalogImOrt[7][1];
                    fahrverbot = katalogImOrt[7][2];
                } else if (überschreitung >= 40) {
                    bussgeld = katalogImOrt[6][0];
                    strafpunkte = katalogImOrt[6][1];
                    fahrverbot = katalogImOrt[6][2];
                } else if (überschreitung >= 30) {
                    bussgeld = katalogImOrt[5][0];
                    strafpunkte = katalogImOrt[5][1];
                    fahrverbot = katalogImOrt[5][2];
                } else if (überschreitung >= 25) {
                    bussgeld = katalogImOrt[4][0];
                    strafpunkte = katalogImOrt[4][1];
                    fahrverbot = katalogImOrt[4][2];
                } else if (überschreitung >= 20) {
                    bussgeld = katalogImOrt[3][0];
                    strafpunkte = katalogImOrt[3][1];
                    fahrverbot = katalogImOrt[3][2];
                } else if (überschreitung >= 15) {
                    bussgeld = katalogImOrt[2][0];
                    strafpunkte = katalogImOrt[2][1];
                    fahrverbot = katalogImOrt[2][2];
                } else if (überschreitung >= 10) {
                    bussgeld = katalogImOrt[1][0];
                    strafpunkte = katalogImOrt[1][1];
                    fahrverbot = katalogImOrt[1][2];
                } else {
                    bussgeld = katalogImOrt[0][0];
                    strafpunkte = katalogImOrt[0][1];
                    fahrverbot = katalogImOrt[0][2];
                }

                break;
            case 2: //2 = Landstraßen, Autobahnen, etc
                if (überschreitung >= 70) {
                    bussgeld = katlogAusserOrts[9][0];
                    strafpunkte = katlogAusserOrts[9][1];
                    fahrverbot = katlogAusserOrts[9][2];
                } else if (überschreitung >= 60) {
                    bussgeld = katlogAusserOrts[8][0];
                    strafpunkte = katlogAusserOrts[8][1];
                    fahrverbot = katlogAusserOrts[8][2];
                } else if (überschreitung >= 50) {
                    bussgeld = katlogAusserOrts[7][0];
                    strafpunkte = katlogAusserOrts[7][1];
                    fahrverbot = katlogAusserOrts[7][2];
                } else if (überschreitung >= 40) {
                    bussgeld = katlogAusserOrts[6][0];
                    strafpunkte = katlogAusserOrts[6][1];
                    fahrverbot = katlogAusserOrts[6][2];
                } else if (überschreitung >= 30) {
                    bussgeld = katlogAusserOrts[5][0];
                    strafpunkte = katlogAusserOrts[5][1];
                    fahrverbot = katlogAusserOrts[5][2];
                } else if (überschreitung >= 25) {
                    bussgeld = katlogAusserOrts[4][0];
                    strafpunkte = katlogAusserOrts[4][1];
                    fahrverbot = katlogAusserOrts[4][2];
                } else if (überschreitung >= 20) {
                    bussgeld = katlogAusserOrts[3][0];
                    strafpunkte = katlogAusserOrts[3][1];
                    fahrverbot = katlogAusserOrts[3][2];
                } else if (überschreitung >= 15) {
                    bussgeld = katlogAusserOrts[2][0];
                    strafpunkte = katlogAusserOrts[2][1];
                    fahrverbot = katlogAusserOrts[2][2];
                } else if (überschreitung >= 10) {
                    bussgeld = katlogAusserOrts[1][0];
                    strafpunkte = katlogAusserOrts[1][1];
                    fahrverbot = katlogAusserOrts[1][2];
                } else {
                    bussgeld = katlogAusserOrts[0][0];
                    strafpunkte = katlogAusserOrts[0][1];
                    fahrverbot = katlogAusserOrts[0][2];
                }
                break;
            default:
                System.out.println("ERROR: UNGÜLTIGE ORTS AUSWAHL !!!!");
                System.out.println("Stellen sie sicher, dass sie die richtige zahl eingeben haben, die eingabe wird nun neugestartet");
                eingabe();
                break;
    }
    }


    void ausgabe() {
        System.out.println("Ausgabe");
        System.out.println("*******");
        System.out.println("Sie haben die Geschwindigkeit mit Berücksichtigung der Toleranz von " + TOLERANZ + "km/h um " + überschreitung + "km/h überschritten. Sie erhalten folgende Strafen: \n");
        System.out.println("Bußgeld: " + bussgeld);
        System.out.println("Strafpunkte: " + strafpunkte);
        System.out.println("Fahrverbot: " + fahrverbot);
        System.out.println("Halten sie sich das nächste mal an die Geschwindigkeit, ist günstiger :)");
    }

}