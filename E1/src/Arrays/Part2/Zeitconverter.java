package Arrays.Part2;

import java.util.Scanner;

public class Zeitconverter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int hour = 0;
        int minutes = 0;
        int seconds = 0;

        System.out.print("Pls enter the seconds you want to convert: ");
        seconds = scan.nextInt();

        //Converting....
        minutes = seconds / 60;
        seconds = seconds % 60;

        hour = minutes / 60;
        minutes = minutes % 60;

        //finaloutput
        System.out.println("Your converted time is:");
        System.out.println(hour + ":" + minutes + ":" + seconds);
    }
}
