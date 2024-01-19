package Grundlagen_2.Input;

import java.util.Scanner;
public class Taschenrechner {
    public static void main(String [] args){
        //Bespielcode aus der PDF
        Scanner berta = new Scanner(System.in); // wird einmal pro Klasse benötigt
        System.out.print("Geben Sie eine ganze Zahl ein: ");
        int zahl1 = berta.nextInt();
        System.out.print("Geben Sie eine zweite ganze Zahl ein: ");
        int zahl2 = berta.nextInt();
        System.out.println("Die erste eingegebene Zahl war: "+ zahl1);
        System.out.println("Die zweite eingegebene Zahl war: "+ zahl2 + "\n"); 

        //Scanner schießen
        berta.close();

        //Berrechen und in neuen Variablen speichern
        int addiert = (zahl1 + zahl2);
        int subrahiert = (zahl1 - zahl2);
        double divison = (double) (zahl1 / zahl2);
        int multiplikation = (zahl1  * zahl2);

        //Ausgabe der Ergebnisse
        System.out.println("Die zahlen addiert: " + addiert + "\n");
        System.out.println("Die zahlen subtraiert: " + subrahiert+ "\n)");
        System.out.println("Die zahlen dividiert: " + divison + "\n");
        System.out.println("Die zahlen multipiziert: " + multiplikation + "\n");
    }
}
