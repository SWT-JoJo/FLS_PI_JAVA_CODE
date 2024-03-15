package Methoden;

import java.text.DecimalFormat;
import java.util.Scanner;

public class TaschenrechnerV2 {
    boolean running = true;
    public static void main(String[] args) {
        TaschenrechnerV2 tr = new TaschenrechnerV2();
        while (tr.running) {
            tr.menu();
        }
    }

    public void menu(){
        int anzRechenOperationen = 4;
        DecimalFormat df_number = new DecimalFormat("#,###,###,###,##0.##");

        double solution = 0;
        int selection ;

        Scanner scan = new Scanner(System.in);
        System.out.println("Bitte geben sie die Zahlen ein");
        System.out.print("Zahl1: ");
        double zahl1  = scan.nextDouble();
        System.out.print("Zahl2: ");
        double zahl2  = scan.nextDouble();
        System.out.println("Bitte wählen sie aus: \n\t0: reset input\n\t1: plus(+)\n\t2: minus(-)\n\t3: mal(*)\n\t4: geteilt (/)");
        do{
            System.out.print("Ihr Rechenoperator: ");
            selection = scan.nextInt();
            if(selection < 0 || selection > anzRechenOperationen){
                System.out.println("ERROR: INVALID INPUT TRY AGAIN ");
            }
        }while(selection < 0 || selection > anzRechenOperationen);

        if(selection == 0) {
                    menu();
        } else if(selection == 1) {
                    solution = plus(zahl1, zahl2);
        } else if (selection == 2) {
                    solution = minus(zahl1, zahl2);
        } else if (selection == 3) {
                    solution = multiply(zahl1, zahl2);
        } else {
            solution = divide(zahl1, zahl2);
        }

        System.out.println("Ihr Ergebniss: "+df_number.format(solution)+"\n");

        //Frage zur wiederholten Berrechnung
        String newRunSelection;
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

    public double plus(double a, double b){
        return (a + b);
    }
    public double minus(double a, double b){
        return (a - b);
    }
    public double multiply(double a, double b){
        return (a * b);
    }
    public double divide(double a, double b){
        return (a / b);
    }
}
