package E1.Arrays.Part2;

import java.util.Arrays;
import java.util.Scanner;

public class Lotto {
    public static void main(String[] args) {
        //IMPORTANT VARIABLE CREATION SECTION
        Scanner scanner = new Scanner(System.in);
        int[] tipps = new int[6];
        int[] lottoNumbers = new int[6];

        //Generating Lottonumbers
        for (int i = 0; i < lottoNumbers.length; i++) {
            int genNumber = (int) (Math.random() * 48 + 1);
            for (int k = 0; k < lottoNumbers.length; k++) {
                while (genNumber == lottoNumbers[k]) {
                    genNumber = (int) (Math.random() * 48 + 1);
                    k = 0;
                }
            }
            lottoNumbers[i] = genNumber;

            //System.out.println(lottoNumbers[i]);
        }
        //UserInput
        System.out.println("Tipps abgeben (zahle zwischen 1 und 49 wählen):");
        for (int i = 0; i < tipps.length; i++) {
            System.out.print("Zahl " + (i + 1) + ": ");
            int inputNumber = scanner.nextInt();

            while (inputNumber < 1 || inputNumber > 49) {
                System.out.println("!! UNGÜLTIGE EINGABE !!");
                System.out.print("Zahl " + (i + 1) + ": ");
                inputNumber = scanner.nextInt();
            }

            for (int k = 0; k < tipps.length; k++) {
                while (inputNumber == tipps[k]) {
                    System.out.println("!! UNGÜLTIGE EINGABE !!");
                    System.out.print("Zahl " + (i + 1) + ": ");
                    inputNumber = scanner.nextInt();
                    k = 0;
                }
            }

            tipps[i] = inputNumber;
        }


        //Checking how many are right
        int rightCounter = 0;

        for (int i = 0; i < lottoNumbers.length; i++) {
            for(int k = 0; k < tipps.length; k++ ){
                if(tipps[k] == lottoNumbers[i]){
                    rightCounter ++;
                }
            }
        }

        //Sorting the Arrays
        Arrays.sort(lottoNumbers);
        Arrays.sort(tipps);

        String formatter = "\t";
        //Output of the End result
        System.out.println("Dein Tipp: ");
        for (int i = 0; i < tipps.length; i++) {
            System.out.print(tipps[i] + formatter);
        }
        System.out.println();

        System.out.println("Lottonumern: ");
        for (int i = 0; i < lottoNumbers.length; i++) {
            System.out.print(lottoNumbers[i] + formatter);
        }

        System.out.println("\n Richtig: " + rightCounter);

        if(rightCounter == lottoNumbers.length){
            System.out.println("JAAAAACKPOOOOOT ALLES RICHTIG");
            System.out.println("SIE GEWINNEN 10 MILLIONEN EUROOOOOOOOOOOOOO");
            System.out.println("JUUUUUUUUUHUUUUUUUUUUHUUUUUUUUHUUUUUUUUHUUUUUUUUUUHUUUUUUuUUHUUUUUUUHUUUUU");
        }
        else if(rightCounter == 0){
            System.out.println("Schade sie habe leider komplett verloren");
        }
    }

}