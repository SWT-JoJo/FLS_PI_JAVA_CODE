package Q1.Vererbung.VierEck;

import java.util.Scanner;

public class VierEckRechner {
    public static void main(String[] args) {
        VierEckRechner VER = new VierEckRechner();
        VER.menu();
    }

    private  void menu(){
        Scanner scan = new Scanner(System.in);
        int temp;

        System.out.println("Wilkommen zum Viereckrechner");
        System.out.println("----------------------------");
        do {
        System.out.println("Bitte wählen sie aus,welch Form sie berrechnen wollen:");
        System.out.println("1: Quadrat");
        System.out.println("2: Rechteck");
        System.out.println("3: Parralelogram");
        System.out.print("Ihre Wahl: ");
        temp = scan.nextInt();
    }while (temp <= 0 || temp > 3);

        System.out.println("Rechner läd....\n");

        switch (temp){
            case 1:
                quadrat();
                break;

            case 2:
                rechteck();
                break;
            case 3:
                parralelogramm();
                break;
        }


        System.out.println("Weiter Berrechnung durchführen (Y/N)");
        char selection = scan.next().charAt(0);
        if(selection == 'y' || selection == 'Y'){
            System.out.println("Rechner läd neu... \n\n");
            menu();
        }
        else{
            System.exit(0);
        }
    }


    private void quadrat(){
        Scanner scan = new Scanner(System.in);
        double a;


        System.out.println("Quadtrat" );
        System.out.print("Geben sie die seitenlänge für das Quadrat ein: ");
        a = scan.nextDouble();
        Quadrat q1 = new Quadrat(a);
        System.out.println("\nBerrechnungen laufen...\n");
        System.out.println("Flaeche:\t\t" + q1.flaechenberrechnung());
        System.out.println("Umfang:\t\t" + q1.umfangberrechnung());
        System.out.println("Diagonale:\t\t" + q1.diagronaleBerrechnen());
        System.out.println("-----------------------------------------");

    }

    private void rechteck(){
        Scanner scan = new Scanner(System.in);

        double a;
        double b;

        System.out.println("Rechteck" );
        System.out.println("Geben sie die maße für das Rechteck ein: ");
        System.out.print("a: ");
        a = scan.nextDouble();
        System.out.print("b: ");
        b = scan.nextDouble();
        Rechteck r1 = new Rechteck(a, b);
        System.out.println("\nBerrechnungen laufen...\n");
        System.out.println("Flaeche:\t\t" + r1.flaechenberrechnung());
        System.out.println("Umfang:\t\t" + r1.umfangberrechnung());
        System.out.println("Diagonale:\t\t" + r1.diagronaleBerrechnen());
        System.out.println("-----------------------------------------");

    }

    private void parralelogramm(){
        Scanner scan = new Scanner(System.in);
        double a;
        double b;
        double winkel;

        System.out.println("Parralelogramm" );
        System.out.println("Geben sie die Werte für das Paralelogram ein: ");
        System.out.print("a: ");
        a = scan.nextDouble();
        System.out.print("b: ");
        b = scan.nextDouble();
        System.out.print("Winkel: ");
        winkel = scan.nextDouble();
        Parralelogramm p1 = new Parralelogramm(a, b, winkel);
        System.out.println("\nBerrechnungen laufen...\n");
        System.out.println("Flaeche:\t\t" + p1.flaecheBerrechnen());
        System.out.println("Umfang:\t\t" + p1.umfangberrechnung());
        System.out.println("Diagonale e:\t\t" + p1.diagonaleEberrechnen());
        System.out.println("Diagonale f:\t\t" + p1.diagonalefberrechnen());
        System.out.println("-----------------------------------------");

    }
}
