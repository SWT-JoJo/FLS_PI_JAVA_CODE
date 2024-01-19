package Arrays.Part2;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayInput {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] zahlen;


        System.out.print("Wie lange soll der Array sein: ");
        int inputLength = scan.nextInt();

        zahlen = new int[inputLength];

        System.out.println("Geben sie nun irgendwelche Zahlen ein: ");
        for(int i = 0; i < zahlen.length; i++){
            System.out.print("Zahl " + (i+1) + ": ");
            zahlen[i] = scan.nextInt();
        }
        System.out.println("Zahlenausgabe;");
        for(int i = 0; i < zahlen.length; i++){
            System.out.print(zahlen[i]);
            if(i < (zahlen.length -1)){
                System.out.print("\t-\t");
            }

        }
    }
}
