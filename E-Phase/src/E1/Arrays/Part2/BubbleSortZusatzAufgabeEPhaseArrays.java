package E1.Arrays.Part2;

import java.util.Scanner;

public class BubbleSortZusatzAufgabeEPhaseArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] bubble;
        System.out.print("Wie lange soll der Array sein: ");
        int inputLength = scan.nextInt();
        bubble = new int[inputLength];

        System.out.println("Geben sie irgendwelche Zahlen ein: ");
        for(int i = 0; i < bubble.length; i++){
            System.out.print("Zahl " + (i+1) + ": ");
            bubble[i] = scan.nextInt();
        }

        //Sortieren
        for(int n = bubble.length; n > 1; n--){
            for(int j = 0; j < (n -1);){
                if(bubble[j] > bubble[j +1]){
                    int buffer = bubble[j];
                    bubble[j] = bubble[j +1];
                    bubble[j + 1] = buffer;
                }
                j++;
            }
        }

        System.out.println("Array sorted: ");
        for(int i:bubble ){
            System.out.print(i + " ");
        }
    }
}
