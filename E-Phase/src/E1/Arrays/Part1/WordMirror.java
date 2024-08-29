package E1.Arrays.Part1;

import java.util.Scanner;

public class WordMirror{

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Geben sie das Wort ein: ");
        char[] word = scan.nextLine().toCharArray();

        for(int i = (word.length - 1); i >= 0; i--){
            System.out.print(word[i]);
        }
    }
}
