package KontrollStrukturen.IfElse;
import java.util.Scanner;

public class PinÜberprüfung {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int pin = 12345678;
        System.out.print("Bitte geben sie den 8 Stelligen Pin ein: ");
        int pinInput = scan.nextInt();

        // Pin überprüfung
        if(pinInput == pin){
            System.out.println("Das gerät wird zurückgesetzt");
        }
        else{
            System.out.println("FEHLER: DER PIN IST FALSCH");
        }
        scan.close();
    }
    
}
