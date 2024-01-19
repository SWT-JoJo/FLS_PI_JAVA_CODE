package KontrollStrukturen.IfElse;

import java.util.Scanner;

public class Kleinstezahl {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int zahl1, zahl2, zahl3;

        System.out.print("Gib die erste zahl ein: ");
        zahl1 = scan.nextInt();
        System.out.print("Gib die zweite zahl ein: ");
        zahl2 = scan.nextInt();
        System.out.print("Gib die dritte zahl ein: ");
        zahl3 = scan.nextInt();

        if (zahl1 < zahl2 && zahl1 < zahl3){
            System.out.println("Die kleinste zahl: " + zahl1);
        }
        else if (zahl2 < zahl3 && zahl2 < zahl3){
            System.out.println("Die kleinste zahl: " + zahl2);
        }
        else if (zahl3 < zahl1 && zahl3 < zahl2){
            System.out.println("Die kleinste zahl: " + zahl3);
        }
        else{
            System.out.println("ALLE zahlen sind gleich groß ! \n Der Wert aller zahlen: " + zahl1);
        }
        scan.close();
    }
}
