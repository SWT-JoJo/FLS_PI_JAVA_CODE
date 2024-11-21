package Q1.Vererbung.Schule;

import java.util.Scanner;

public class Berufsschule extends  Schule {
    private String beruf;
    private char berufsabschluss, ausbildungsverhaeltnis;
    private int schulabschluss;

    public void setBerufDaten() {
        setStamm();


        Scanner scan = new Scanner(System.in);
        System.out.print("Geben sie den Beruf ein: ");
        beruf = scan.next();


        //Einlesen von berufsabschluss → Besteht bereits eine abgeschlossene Ausbildung? Mögliche Werte: j oder n
        char temp;
        do {
            System.out.print("Besteht berreits eine Abgeschlossene Ausbildung (J/N): ");
            temp = scan.next().toLowerCase().charAt(0);
            if (temp != 'j' && temp != 'n') {
                System.out.println("Ungültige Eingabe");
            }

        } while (temp != 'j' && temp != 'n');
        berufsabschluss = temp; //final festlegen

        // EInlesen von ausbildungsverhältnis → Besitzt der Schüler ein Ausbildungsverhältnis? Mögliche Werte: j oder n
        do {
            System.out.print(" Besitzt der Schüler ein Ausbildungsverhältnis (J/N): ");
            temp = scan.next().toLowerCase().charAt(0);
            if (temp != 'j' && temp != 'n') {
                System.out.println("Ungültige Eingabe");
            }

        } while (temp != 'j' && temp != 'n');
        ausbildungsverhaeltnis = temp; //final festlegen


        //Einlesen von schulabschluss → Schulabschluss einer allgemeinen Schule?
        int temp2;
        System.out.println("Wählen sie den höhsten erreichten Schulabschluss aus: ");
        System.out.println("1: einfacher Hauptschulabschluss");
        System.out.println("2: Hauptschulabschluss");
        System.out.println("3: Mittlerer Reife/Realschule");
        System.out.println("4: Abitur");
        System.out.println("5: Fachgebundene Hochschulreife");
        System.out.println("6: Fachhochschulreife");
        do {
            System.out.print("Ihr Abschluss: ");
            temp2 = scan.nextInt();
            if (temp2 < 1 || temp2 > 6) {
                System.out.println("Ungütige Eingabe");
            }
        } while (temp2 < 1 || temp2 > 6);

        System.out.println("Ihre Daten wurden erfasst, Vielen Dank :)\n\n");


    }

    public String volljaehrigkeitPruefen() {
        if (alterBestimmen() >= 18) {
            return "Volljährig";
        } else {
            return ("Nicht Volljährig");
        }
    }

    public String schulpflichtPruefen() {
        String temp;

        if (berufsabschluss == 'j') {
            return "Berufsschulberechtigt";
        } else if (alterBestimmen() >= 21) {
            return "Berufsschulberechtigt";
        } else switch (schulabschluss) {
            case 1, 2:
                temp = "Berufsschulberechtigt";

            case 3:
                if (ausbildungsverhaeltnis == 'j') {
                    temp = "Berufsschulberechtigt";
                } else {
                    temp = "Berufsschulbefreit";
                }
                break;

            default:
                temp = "Berufsschulberechtigt";
                break;
        }
        return temp;
    }

    public void datenAusgeben() {
        super.datenAusgeben();
        System.out.println("Beruf: \t\t\t" + beruf);
        System.out.println(volljaehrigkeitPruefen());
        System.out.println(schulpflichtPruefen());

    }

}
