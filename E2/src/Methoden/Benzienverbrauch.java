package Methoden;

import java.util.Scanner;

public class Benzienverbrauch {
    int current_km;
    int last_km;
    int filledTankFuel;
    double avgfuelusage;
    int distance;
    
    public static void main(String[] args) {
        Benzienverbrauch bv = new Benzienverbrauch();

        bv.input();
        bv.processing();
        bv.output();
    }
    
    void input(){
        //Header
        System.out.println("*******************************************************************");
        System.out.println("                    Berrechnung Benzienverbrauch                   ");
        System.out.println("*******************************************************************");
        System.out.println();

        Scanner scan = new Scanner(System.in);
        System.out.println("Eingabe: ");
        
        System.out.print("Geben sie den Kilometerstand beim letzen Tanken ein: ");
        last_km = scan.nextInt();
        System.out.print("Geben sie den aktuellen Kilometerstand ein: ");
        current_km = scan.nextInt();
        System.out.print("Geben sie die Menge der getankten Liter Benzin ein: ");
        filledTankFuel = scan.nextInt();
    }
    void processing(){
        distance = current_km - last_km;
        avgfuelusage=  (double) filledTankFuel / (distance / 100);

        avgfuelusage = ((int) ((avgfuelusage ) * 100))/100.0;
    }
    
    void output(){
        System.out.println("Auswertung");
        System.out.println("Der durchschnittliche Benzienverbrauch betraegt " + avgfuelusage  + "L  pro 100km, wenn sie " + distance + "km gefahren sind und " + filledTankFuel + "L getankt haben.");

    }
}

