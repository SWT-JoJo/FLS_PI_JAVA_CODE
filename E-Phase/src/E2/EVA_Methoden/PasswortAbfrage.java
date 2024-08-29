package E2.EVA_Methoden;

import java.util.Scanner;

public class PasswortAbfrage {

    final String PASSWORT = "FLSWiesbaden24!?";
    int trys = 3;
    String userInput;
    public static void main(String[] args) {
        PasswortAbfrage pa = new PasswortAbfrage();
        pa.titel();
        pa.eingabe();
        pa.verarbeitung();
        pa.ausgabe();
    }
    void titel(){
        System.out.println("*******************************************************************");
        System.out.println("*                              Login                              *");
        System.out.println("*******************************************************************");
        System.out.println();
    }
    void eingabe(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Geben sie ihr Passwort ein: ");
        userInput = scan.next();

    }

    void verarbeitung(){
        while (!userInput.equals(PASSWORT) && trys > 0){
            System.out.println("Dieses Passwort ist FALSCH, bitte versuchen sie es erneut");
            System.out.println("Versuche verbleibend: " + trys + "\n\n");
            trys --;
            eingabe();
        }
    }

    void ausgabe(){
        System.out.println("\n");
        if(trys <= 0){
            System.out.println("Sie haben zu viele versuche gebraucht. Ihr konto ist nun gesperrt.\n" +
                    "Bitte Wenden sie sich an den KundenSupport unter: 061411761848617");
        }
        else {
            System.out.println("Wilkommen zurück");
        }
    }
}
