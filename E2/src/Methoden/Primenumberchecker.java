package Methoden;

import java.util.Scanner;

public class Primenumberchecker {
    int number;
    boolean isprimzahl;

    public static void main(String[] args) {
        Primenumberchecker primch = new Primenumberchecker();
        primch.input();
        primch.processing();
        primch.output();

    }
    void input(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number you want to check: ");
        number = scan.nextInt();
    }

    void processing() {
        int temp = 0;
        for (int i = 2; i <= number / 2; i++) {
            if (number % i != 0) {
                temp++;

            }
        }
        if (temp == 0 && number > 1) {
            isprimzahl = true;
        } else {
            isprimzahl = false;
        }
    }

    void output(){
        System.out.println(number + " is a Prime number is: " + isprimzahl);
    }
}
