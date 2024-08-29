package E1.Arrays.Part2;

import java.util.Scanner;

public class BäumchenWechselDichPart2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] zahlen = new int[2];

        System.out.print("Zahl1: ");
        zahlen[0] = scanner.nextInt();
        System.out.print("Zahl2: ");
        zahlen[1]= scanner.nextInt();

        int buffer = zahlen[1];

        zahlen[1] = zahlen[0];
        zahlen[0] = buffer;

        System.out.println("Zahl1: " + zahlen[0]);
        System.out.println("Zahl2: " + zahlen[1]);
    }
}
