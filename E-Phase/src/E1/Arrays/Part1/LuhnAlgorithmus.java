package E1.Arrays.Part1;

import java.util.Scanner;

public class LuhnAlgorithmus {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] cardNumber = new int[15];
        int prüfnummer;

        System.out.println("Geben sie ihre Kartenummer ein");
        char[] input = (scan.nextLine().toCharArray());

        int buffercounter = 0;
        for(int i = 0; i < input.length; i++){
            if(Character.isDigit(input[i])){
                cardNumber[buffercounter] = ((int) input[i]);

                System.out.print(cardNumber[buffercounter]);
                buffercounter ++;
            }

        }

    }
    }