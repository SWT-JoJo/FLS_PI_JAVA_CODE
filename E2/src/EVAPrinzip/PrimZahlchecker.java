package EVAPrinzip;

import java.util.Scanner;

public class PrimZahlchecker {
    int number;
    String output = "";
    public static void main(String[] args) {
        PrimZahlchecker pz = new PrimZahlchecker();
        pz.eingabe();
        pz.verarbeitung();
        pz.ausgabe();
    }

    void eingabe(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Geben sie ihre Zahl ein: ");
        number = scan.nextInt();
    }

    void verarbeitung(){
        if(number%2 ==0){
            output+= "\t" + number +" ist eine gerade Zahl \n";
        }
        else {
            output+= "\t" + number +" ist eine ungerade Zahl \n";
        }

        boolean isPrimeNumber =true;
        for(int i = 2; i<number;i++){
            if(number%i == 0){
                isPrimeNumber = false;
                break;
            }
        }

        if(isPrimeNumber){
            output+= "\t" + number +" ist eine Primzahl";
        }
        else {
            output+= "\t" + number +" ist keine Primzahl";
        }
    }

    void ausgabe(){
        System.out.println(output);
    }
}

