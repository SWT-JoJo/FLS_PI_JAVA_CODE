package Schleifen;

import java.util.Scanner;

public class Potenzen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Basis: ");
        int basis = scan.nextInt();
        System.out.print("Potenz: ");
        int potenz = scan.nextInt();

        int ergebniss = basis;
        for(int i = 1; i < potenz; i++){
            ergebniss = ergebniss * basis;
        }

        System.out.println("Ergebniss: " + ergebniss);
    }
}
