package Grundlagen_2.Modulo;

import java.util.Scanner;

/**
 * osterformel
 */
public class osterformel {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Bitte geben sie das Jahr ein: ");

        int jahr = scan.nextInt();
        String monat = " März ";

        // Ganz komische Rechnung die ich nicht verstehe -_-
        int a = jahr % 4;
        int b = jahr % 7;
        int c = jahr % 19;
        int d = (19 * c + 24) %  30;
        int e = (2*a + 4*b + 6*d + 5) % 7;
        int f = (c+ 11 * d+ 22 * e)/451;
        
        int ostersonntag = 22+d+e-7*f;

        // Prüfung welcher Monat es ist und bei April den Tag neu berechnen

        if(ostersonntag > 31){
            ostersonntag = d+e-7* f-9;
            monat = " April ";
        }   


        System.out.println("Ostersonntag ist am: " + ostersonntag + monat + jahr);
        scan.close();
    }
}