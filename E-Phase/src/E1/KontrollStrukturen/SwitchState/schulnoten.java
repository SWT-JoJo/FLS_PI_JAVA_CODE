package E1.KontrollStrukturen.SwitchState;

import java.util.Scanner;

public class schulnoten {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int note; 

        System.out.print("Bitte geben sie ihre Note ein (1-6): ");
        note = scan.nextInt();

        switch (note) {
            case 6:
                System.out.println("Durchgefallen");
                break;
            case 5:
                System.out.println("Mangelhaft");
                break;
            case 4:
                System.out.println("Ausreichend");      
                break;
            case 3:
                System.out.println("Befriedigend");
                break;
            case 2:
                System.out.println("Gut");
                break;
            case 1:  
                System.out.println("Sehr gut");
                break;
            default: 
                System.out.println("ERROR: EINGABE FALSCH ERROR CODE: ID10T");
                break;
             }   
             
            scan.close(); 
        
    }
}



