package Q1.Rekursion;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Fakultaet {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Geben sie eine zahl ein: ");
        int a = scan.nextInt();

        System.out.println("\nErgebnisse\n---------------------");
        System.out.println("Methode: ");
        System.out.println(fakultaet(a));
        System.out.println("Schleife:");
        System.out.println(fakultaetSchleife(a));
    }

    public static long fakultaet (int n){
        if(n == 0){
            return 1;
        }

        return n * fakultaet(n - 1);
    }

    public static long fakultaetSchleife(int n){
      int temp = n;
        if(n == 0){
            return 0;
        }

        for(int i  = n-1; i > 0; i--){
            n = n*i;
        }
        return n;
    }
}
