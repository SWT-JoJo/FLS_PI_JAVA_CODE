package Methoden;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Taschenrechner {
    boolean running = true;
    double solution = 0;
    double zahl1;
    double zahl2;
    public static void main(String[] args) {
        Taschenrechner tr = new Taschenrechner();
        while (tr.running)
            tr.mainMenu();
    }

    public void mainMenu(){
        int anzRechenOperationen = 4;
        DecimalFormat df_number = new DecimalFormat("#,###,###,###,##0.##");

        int selection ;

        Scanner scan = new Scanner(System.in);
        System.out.println("Bitte geben sie die Zahlen ein");
        System.out.print("Zahl1: ");
         zahl1  = scan.nextDouble();
        System.out.print("Zahl2: ");
         zahl2  = scan.nextDouble();
        System.out.println("Bitte wählen sie aus:\n\t1: plus(+)\n\t2: minus(-)\n\t3: mal(*)\n\t4: geteilt (/)");
        do{
            System.out.print("Ihr Rechenoperator: ");
            selection = scan.nextInt();
            if(selection < 0 || selection > anzRechenOperationen){
                System.out.println("ERROR: INVALID INPUT TRY AGAIN ");
            }
        }while(selection <= 0 || selection > anzRechenOperationen);


        //
        if(selection == 1) {
            plus();
        } else if (selection == 2) {
            solution = minus();
        } else if (selection == 3) {
            multiply(zahl1, zahl2);
        } else {
            solution = divide(zahl1, zahl2);
        }

        System.out.println("Ihr Ergebniss: "+df_number.format(solution)+"\n\n");
            String newRunSelection;
        //Frage zur wiederholten Berrechnung
        do {
            System.out.println("Neue Berrechnung (Y/N): ");
             newRunSelection = scan.next();
            if (newRunSelection.equalsIgnoreCase("Y")) {
                running = true;
                System.out.println("RELOADING... \n\n");
            } else if (newRunSelection.equalsIgnoreCase("N")) {
                running = false;
                System.out.println("GOOD BYE :)");
            }
            else {
                System.out.println("Ungültige Eingabe");
            }
        }while (!newRunSelection.equalsIgnoreCase("Y") && !newRunSelection.equalsIgnoreCase("N"));


    }

    //Ohne Rückgabe und Parametern
    public void plus(){
        solution = zahl1 + zahl2;
    }

    //mit Rückgabe, ohne Parametern
    public double minus(){
        return (zahl1 - zahl2);
    }

    //ohne Rückgabe, mit Parametern
    public void multiply(double a, double b){
        solution = (a * b);
    }

    //Rückgabe und Übergabe
    public double divide(double a, double b){
        return  (a / b);
    }
}

// bei minus wurde nicht mit den parametern gerechnet
