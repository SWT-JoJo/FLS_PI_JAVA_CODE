package E1.KontrollStrukturen.IfElse;

import java.util.Scanner;

public class Moduulo {
    public static void main(String[] args) {
        int divisor = 0;
        int dividend = 0; 
        int usereingabe;
        Scanner scan = new Scanner(System.in);

        System.out.print("Geben sie einen dividenden ein: ");
        dividend = scan.nextInt();
        System.out.print("Geben sie einen divisor ein: ");
        divisor = scan.nextInt();

        int lösung = dividend % divisor;

        System.out.print("Berrechne den Restwert aus " + dividend +  " % " + divisor +  ": ");
        usereingabe = scan.nextInt();

        if(usereingabe == lösung){
            System.out.println("WHOOOHOOOOOOO DAS IST KORREKT :)");
        }
        else{
            System.out.println("Falsch, die richtige lösung war: " + lösung);
        }
        scan.close();
    }
}
