package Q2.Kryptographie;

import java.util.Scanner;

public class Ceeser {
    

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input;
        int key;

        System.out.println("Geben sie einen Text oder Word ein den sei Verschlüsseln wollen: ");
        input = scan.nextLine().toUpperCase();
        System.out.print("Geben sie den Key wert an: ");
        key = scan.nextInt();

        System.out.println("Der Verschluesselte Text ist hier: ");
        System.out.println(verlusselnCaeser(input, key));

    }

    public static String verlusselnCaeser(String text, int key){
      String verschluesselterText = "";

      return verschluesselterText;
    };
}
