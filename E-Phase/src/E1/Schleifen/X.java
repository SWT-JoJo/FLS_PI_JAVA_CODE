package Schleifen;

import java.util.Scanner;

public class X {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Wie viele Spalten wollen sie: ");
        int spalten = scan.nextInt();
        System.out.print("Wie viele zeilen: ");
        int zeilen = scan.nextInt();

        for(int i = 0; i < zeilen; i++){
            for(int j = 0; j < spalten; j++){
                System.out.print("X");
            }
            System.out.print("\n");
        }
    }
}
