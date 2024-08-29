package E2.EVA_Methoden;

import java.util.Scanner;

public class EVA_Demo {
    /*
    EVA-Prinzip:
    E - Eingabe
    V - Verarbeitung
    A - Ausgabe
    */

    //Variablen
    String name;
    String begruessung;


    public static void main(String[] args) {
        //Objekt von Eva-demo erstellen
        EVA_Demo ed = new EVA_Demo();
        // Methodenaufrufen
        ed.eingeben();
        ed.verarbeitung();
        ed.ausgabe();
    }


    public void eingeben(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your name: ");
        name = scan.next();
    }

    public void verarbeitung(){
        begruessung = "Good morning " + name;
    }

    public void ausgabe(){
        System.out.println(begruessung);
    }
}