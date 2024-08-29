package Schleifen;

import java.util.Scanner;

public class HalberTannenbaumGENERATOR {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int spalten = 1;
        System.out.print("WIE VIELE LUSTIGE ZEILEN SOLL IHR TANNENBAUM HABEN: ");
        int zeilen = scan.nextInt();

        //Generator
        for(int i = 0; i < zeilen; i++){
            for(int j = 0; j < spalten; j++) {
                System.out.print("X");
            }
            spalten ++;
            System.out.print("\n");
        }

        //Baumstamm Ausgabe weil Tannenbaum :)
        System.out.println("| \n" +
                           "| \n" +
                           "| \n" +
                           "| \n");
    }
}
