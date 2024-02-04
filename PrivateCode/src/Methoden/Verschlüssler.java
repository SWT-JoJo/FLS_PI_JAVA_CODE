package Methoden;

import java.util.Scanner;

public class Verschlüssler {
    int choose;

    //Text
    String inputText;
    char[] inputText_Splitted;
    int[] splittedText_Ascii;
    String[] outputText;

    //Formel-Zahlen
    int a = 5;
    int b = 10;
    int c = 12;
    int d = 6;

    public static void main(String[] args) {
        Verschlüssler vs = new Verschlüssler();
        vs.input();
        vs.processing();
        vs.output();
    }

    void input() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the Text you want to encrypt or decrypt: ");
        inputText = scan.nextLine();
        System.out.print("Select: \n encrypt: 1 \n decrypt: 2 \n Your Choice: ");
        choose = scan.nextInt();
    }

    void processing() {
        inputText_Splitted = inputText.toCharArray();
        splittedText_Ascii = new int[inputText.length()];
        for (int i = 0; i < inputText_Splitted.length; i++) {
            splittedText_Ascii[i] = (int) inputText_Splitted[i];
            //System.out.print(splittedText_Ascii[i] + " ");
        }

        switch (choose) {
            case 1:
                System.out.println("Encrypting...");
                encrypt();
                break;

            case 2:
                System.out.println("Decrypting...");
                decrypt();
                break;
            default:
                System.out.println("No valid choice, you have to enter your complete text again");
                input();
                break;
        }

        outputText = new String[splittedText_Ascii.length];
        for (int i = 0; i < outputText.length; i++) {
            outputText[i] = String.valueOf((char) splittedText_Ascii[i]);
        }
    }


    void output() {
        System.out.println("Your new Text: \n ");
        for (int i = 0; i < outputText.length; i++) {
            System.out.print(outputText[i]);
        }
    }

    void decrypt() {
        for (int i = 0; i < splittedText_Ascii.length; i++) {
            if (splittedText_Ascii[i] == 32) {
                //Do noting
            } else {
                splittedText_Ascii[i] += b;
                splittedText_Ascii[i] -= a;
                splittedText_Ascii[i] *= d;
                splittedText_Ascii[i] /= c;


            }
        }
    }

    void encrypt() {
        for (int i = 0; i < splittedText_Ascii.length; i++) {
            if (splittedText_Ascii[i] == 32) {
                //Do noting
            } else {
                splittedText_Ascii[i] *= c;
                splittedText_Ascii[i] /= d;
                splittedText_Ascii[i] += a;
                splittedText_Ascii[i] -= b;
            }
        }
    }
}
