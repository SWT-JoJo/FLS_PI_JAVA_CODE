package E1.KontrollStrukturen.IfElse;

import java.util.Scanner;

public class Bonus {
    public static void main(String[] args) {
        int age;
        int inCompany;

        int zulage;
        int bonus;
        String name; 
        
        Scanner scan = new Scanner(System.in);

        System.out.print("Bitte geben sie ihren nachnamen ein: ");
        name = scan.next();
        System.out.print("Wie alt sind sie: ");
        age = scan.nextInt();
        System.out.print("Wie lange arbeiten sie schon im Betrieb: ");
        inCompany = scan.nextInt();

        if(age > 35){
            zulage = 50;
        }
        else{
            zulage = 0;
        }
        if(inCompany >= 25){
            bonus = 500;
        }
        else{
            bonus = 0;
        }

        System.out.println("Herr/Frau " + name + " Sie erhalten einen Bonus von " + bonus + " Euro und eine zulage von " + zulage + " Euro");
        scan.close();
    }
}
