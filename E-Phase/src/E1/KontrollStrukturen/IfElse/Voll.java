package E1.KontrollStrukturen.IfElse;

import java.util.Scanner;

public class Voll {
    public static void main(String[] args) {
        int age; 
        Scanner scan = new Scanner(System.in);

        System.out.print("Bitte geben sie ihr Alter ein: ");
        age = scan.nextInt();

        if(age >= 18){
            System.out.println("Sie sind volljährig ");
        }
        else if(age < 18){
            System.out.println("Sie sind minderjährig");
        }
        else{
            System.out.println("Keine gültige eingabe");
        }

        scan.close();
    }
}
