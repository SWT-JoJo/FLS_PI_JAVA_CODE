package Q1.Rekursion;

import java.util.Scanner;

public class GGT {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Bitte geben sie die erste Zahl ein: ");
        int zahl1 = scan.nextInt();
        System.out.print("Bitte geben sie die zweite Zahl ein: ");
        int zahl2 = scan.nextInt();

        System.out.println("\nDer groeßte Gemeinsamme Teiler ist (schleife): " + ggt1(zahl1, zahl2));
        System.out.println("\nDer groeßte Gemeinsamme Teiler ist (rekursion): " + ggt2(zahl1, zahl2));
    }

    //Iteration (Schleife)
    public static int ggt1(int zahl1, int zahl2){
        int rest;
        while (zahl2 != 0){
            rest = zahl1 % zahl2;
            zahl1 = zahl2;
            zahl2 = rest;
        }

        return zahl1;
    }

    //rekursion
    public static int ggt2(int zahl1, int zahl2){
        if(zahl2 == 0){
            return zahl1;
        }
        return ggt2(zahl2,zahl1 % zahl2);

    }
}
