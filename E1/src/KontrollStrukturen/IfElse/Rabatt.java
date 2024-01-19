package KontrollStrukturen.IfElse;

import java.util.Scanner;

public class Rabatt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int anzahl;
        double preis;
        System.out.println("Bitte geben die die Anzahl ein");
        anzahl = scan.nextInt();
        preis = (anzahl * 8.5);

        if(anzahl >= 500){
            preis = preis * 0.7;
        }
        else if(anzahl >= 200){
            preis = preis * 0.85;
        }
        else if(anzahl >= 100){
            preis = preis * 0.82;
        }

        else{ 
            preis = preis * 1;
        }
        
        System.out.println(" Sie Zahlen: " + preis + "  bei einer Menge von " + anzahl);
        scan.close();
    }
}
