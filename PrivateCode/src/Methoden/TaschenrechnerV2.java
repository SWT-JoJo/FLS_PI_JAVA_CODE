package Methoden;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.InputMismatchException; 

public class TaschenrechnerV2 {
    public static void main(String[] args) {
        TaschenrechnerV2 tr = new TaschenrechnerV2();
        tr.menu();
    }

    public void menu() {
        Scanner scan = new Scanner(System.in);

        boolean running = true;
        while (running) {

            double zahl1 = 0;
            double zahl2 = 0;
            int anzRechenOperationen = 6;
            double solution = 0;
            int selection = 0;
            boolean nullDivision = false;
            DecimalFormat df_number = new DecimalFormat("#,###,###,##0.##");

            boolean resetMenu = true;
            while (resetMenu) {

                System.out.println("Bitte geben sie die Zahlen ein");

                //Zahl 1 eingabe mit Fehler überprüfung, dass auch wirklich eine Zahl eingegeben wird
                boolean validNum1 = false;
                while (!validNum1) {
                    try {
                        System.out.print("Zahl1 (a): ");
                        zahl1 = scan.nextDouble();
                        validNum1 = true;
                    } catch (InputMismatchException e) {
                        System.out.println("ERROR: ONLY NUMBERS ALLOWED");
                        scan.next();
                    }
                }

                //Zahl 2 eingabe mit Fehler überprüfung, dass auch wirklich eine Zahl eingegeben wird
                boolean validNum2 = false;
                while (!validNum2) {
                    try {
                        System.out.print("Zahl2 (n): ");
                        zahl2 = scan.nextDouble();
                        validNum2 = true;
                    } catch (InputMismatchException e) {
                        System.out.println("ERROR: ONLY NUMBERS ALLOWED");
                        scan.next();
                    }
                }
                //Auwahl der Rechenoperation
                System.out.println("\nBitte wählen sie aus: \n\t0: Reset input\n\t1: Plus(+)\n\t2: Minus(-)\n\t3: Mal(*)\n\t4: Geteilt (/)\n\t5: Potenz (^)\n\t6: Wurzel (√)");
                do {
                    try {
                        System.out.print("Ihr Rechenoperator: ");
                        selection = scan.nextInt();
                    } catch (InputMismatchException e) {
                        selection = -1;
                        scan.next();
                    }

                    if (selection < 0 || selection > anzRechenOperationen) {
                        System.out.println("ERROR: INVALID INPUT TRY AGAIN ");
                    }

                } while (selection < 0 || selection > anzRechenOperationen);

                if(selection != 0){
                    resetMenu = false;
                }
            }

            if (selection == 1) {
                solution = plus(zahl1, zahl2);
            } else if (selection == 2) {
                solution = minus(zahl1, zahl2);
            } else if (selection == 3) {
                solution = multiply(zahl1, zahl2);
            } else if(selection == 4){
                if (zahl2 == 0) {
                    nullDivision = true;
                    System.out.println("ERROR: Teilen durch null nicht möglich");
                } else {
                    solution = divide(zahl1, zahl2);
                }
            }
            else if(selection == 5){
                solution = pow(zahl1, zahl2);
            } else if (selection == 6) {
                solution = root(zahl1, zahl2);
            }

            if (!nullDivision) {
                System.out.println("Ihr Ergebniss: " + df_number.format(solution) + "\n");
            }


            //Frage zur wiederholten Berrechnung
            String newRunSelection;
            do {
                System.out.println("Neue Berrechnung (Y/N): ");
                newRunSelection = scan.next();
                if (newRunSelection.equalsIgnoreCase("Y")) {
                    System.out.println("RELOADING... \n\n");
                } else if (newRunSelection.equalsIgnoreCase("N")) {
                    System.out.println("GOOD BYE :)");
                    running = false;
                } else {
                    System.out.println("Ungültige Eingabe");
                }
            } while (!newRunSelection.equalsIgnoreCase("Y") && !newRunSelection.equalsIgnoreCase("N"));


        }
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

    public double pow(double a, double n ){
        return Math.pow(a,n);
    }
    public double root(double a, double n){
        return Math.pow(a, 1.0/n);
    }

}
