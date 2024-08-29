package E1.Arrays.Part1;

import java.util.Scanner;

public class SockenFinder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] socken = new String[7];
        socken[0] = "blau";
        socken[1] = "schwarz";
        socken[2] = "rot";
        socken[3] = "grau";
        socken[4] = "weiß";
        socken[5] = "grün";
        socken[6] = "pink";

        System.out.print("Geben sie den Wochentag ein als zahl von 1-7 ein: ");
        int inputTag = (scan.nextInt()) -1;


        System.out.println("Sie MÜSSEN die Socken in der Farbe: " + socken[inputTag] + " tragen :)");
    }
}
