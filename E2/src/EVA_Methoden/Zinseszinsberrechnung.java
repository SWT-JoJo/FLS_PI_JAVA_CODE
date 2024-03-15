package EVA_Methoden;

import java.util.Scanner;

public class Zinseszinsberrechnung {
    double kapital;
    int jahre;
    double zinssatz;
    double zinsen = 0;

    double startkapital;


    int simsalabim = 1;

    public static void main(String[] args) {
        Zinseszinsberrechnung zinsen = new Zinseszinsberrechnung();
        while (zinsen.simsalabim == 1) {
            zinsen.eingabe();
            zinsen.verarbeitung();
            zinsen.ausgabe();
            zinsen.rerun();
        }
    }

    void titel() {
        System.out.println("*******************************************************************");
        System.out.println("*                             Sparplan                            *");
        System.out.println("*******************************************************************");
        System.out.println();
    }

    void eingabe() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Bitte geben sie Ihr Kapital ein: ");
        kapital = scan.nextDouble();
        System.out.print("Bitte geben sie den Zinssatz: ");
        zinssatz = scan.nextDouble();
        System.out.print("Bitte geben sie die Anlage dauer (in Jahren) ein: ");
        jahre = scan.nextInt();

        //NICHT WICHTIG !!!!!!
        System.out.println();
        System.out.println();
        System.out.println();

    }

    void verarbeitung() {
        startkapital = kapital;
        double temp;
        for (int i = 0; i < jahre; i++) {
            temp = (kapital * zinssatz / 100);
            kapital += temp;
            zinsen += temp;
        }

        //Runden von allem
        kapital = ((int) ((kapital + 0.005) * 100)) / 100.0;
        zinsen = ((int) ((zinsen + 0.005) * 100)) / 100.0;
    }

    void ausgabe() {
        System.out.println("Startkapital: " + startkapital + " EUR");
        System.out.println("Zinssatz: " + zinssatz + "%");
        System.out.println("Analgedauer: " + jahre + " Jahre");
        System.out.println("Zinsen: " + zinsen + " EUR");
        System.out.println("Endkapital: " + kapital + " EUR");
    }

    void rerun() {

        Scanner scan = new Scanner(System.in);
        System.out.println();
        System.out.println();
        System.out.print("Wollen sie eine weitere berrechnung durchführen (Y/N): ");
        char input = scan.next().charAt(0);
        if (input == 'y' || input == 'Y') {
            simsalabim = 1;
        } else if (input == 'n' || input == 'N') {
            System.out.println("GOOD BYE");
            simsalabim = 0;
        } else {
            System.out.println("INVALID INPUT: TRY AGAIN");
            rerun();
        }

    }
}
