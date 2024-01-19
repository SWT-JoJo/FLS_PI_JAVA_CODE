package Arrays.Part2;

import java.util.Scanner;

public class BäumchenWechselDichPart1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Zahl1: ");
        int zahl1 = scanner.nextInt();
        System.out.print("Zahl2: ");
        int zahl2 = scanner.nextInt();

        int buffer = zahl2;

        zahl2 = zahl1;
        zahl1 = buffer;

        System.out.println("Zahl1: " + zahl1);
        System.out.println("Zahl2: " + zahl2);

    }
}
