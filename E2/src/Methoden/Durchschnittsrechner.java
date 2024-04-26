package Methoden;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Durchschnittsrechner {
    public static void main(String[] args) {
        Durchschnittsrechner durchschnittsrechner = new Durchschnittsrechner();
        System.out.println("*****************************************************************");
        System.out.println("*                     DurchschnittsRechner                      *");
        System.out.println("*****************************************************************");
        System.out.println();

        durchschnittsrechner.eingabe();
    }
    public void eingabe(){
        Scanner scan = new Scanner(System.in);
        DecimalFormat df_numbers = new DecimalFormat("#,###,##0.##");

        System.out.print("Geben sie an wie viele Zahlen sie eingeben wollen: ");
        int anzahl = scan.nextInt();
        int[] numbers = new int[anzahl];

        for(int i = 0; i < numbers.length; i++){
            System.out.print("Bitte geben sie die " + (i+1) +". zahl ein: ");
            numbers[i] = scan.nextInt();
        }

        double durchschnitt = durchschnitt(numbers);
        System.out.println("Der Durschschnitt beträgt: " + df_numbers.format(durchschnitt));
    }



    public double durchschnitt(int[] zahlen ){
        double summe = 0;
        for(int i = 0; i < zahlen.length; i++){
            summe += zahlen[i];
        }

        return (summe / zahlen.length);

    }
}
