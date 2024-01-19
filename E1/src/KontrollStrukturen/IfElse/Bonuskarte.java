package KontrollStrukturen.IfElse;

import java.util.Scanner;

public class Bonuskarte {
    public static void main(String[] args) {
        int umsatz; 
        int bonus;
        String kartentyp = " ";

        Scanner scan = new Scanner(System.in);

        System.out.print("Bitte geben sie ihren Umsatz ein als GANZZAHL");
        umsatz = scan.nextInt();

        if(umsatz >= 1000) {
            bonus = 5;
            kartentyp = "VIP-Karte";
        }
        else if(umsatz >= 500 && umsatz < 1000){
            bonus = 3;
        }
        else{
            bonus = 2;
            kartentyp = "Standard Karte ";
        }

        System.out.println("Sie erhalten die " + kartentyp + " mit einem Bonus von " + bonus + "%");
        scan.close();
    }
}
