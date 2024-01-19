package Schleifen;

import java.util.Scanner;

public class Abschreibung {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Geben sie den Anschaffungswert ein: ");
        int anschaffungswert = scan.nextInt();

        System.out.print("Geben sie die Nutzungsdauer in Jahren ein: ");
        int nutzungsdauer = scan.nextInt();

        int restwert;
        int abschreibung = anschaffungswert / nutzungsdauer;
        System.out.println("|\tJahr\t|\tStart\t|\tAbschreibung\t|\tRestwert\t|");

        for (int i = 1; i <= nutzungsdauer; i++){
            restwert = anschaffungswert - abschreibung;

            if(restwert <= 99){
                System.out.println("|\t" + (i) + "\t\t|\t" + anschaffungswert + "\t|\t" + abschreibung + "\t\t\t|\t" + restwert + "\t\t\t|");
            } else {
                System.out.println("|\t" + i + "\t\t|\t" + anschaffungswert + "\t|\t" + abschreibung + "\t\t\t|\t" + restwert + "\t\t|");
            }
            anschaffungswert = restwert;

        }
    }
}
