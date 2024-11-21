package Methoden;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TeilbarkeitV2 {
    public static void main(String[] args) {
        TeilbarkeitV2 tl2 = new TeilbarkeitV2();
        tl2.input();

    }

    public void input(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Geben sie ihre Zahlen ein: ");
        System.out.print("Zahl 1: ");
        int num1 = scan.nextInt();
        System.out.print("Zahl 2: ");
        int num2 = scan.nextInt();
        output(num1, num2);
    }

    public  void output(int num1, int num2){
        if(teilbar(num1, num2)){
            System.out.println(num1 + " und " + num2 + " sind glatt teilbar");
        }
        else {
            System.out.println(num1 + " und " + num2 + " sind nicht glatt teilbar");
        }


        System.out.println(num1 + " ist durch folgende Zahlen teilbar: ");
        int[] teilbareZahlen = teilbareZahlen(num1);
        for (int i = 0; i< teilbareZahlen.length; i++){
            System.out.print(teilbareZahlen[i] + "\t");
        }
    }

    public  boolean teilbar(int num1, int num2){
        boolean teilbar = (num1 % num2) == 0;

        return teilbar;
    }

    public int[] teilbareZahlen(int num1){
        int[] zahlen = new int[0];

        int counter = 0;
        for(int i = 1; i <= num1; i++){
            if((num1 % i) == 0 ){
                int[] temp = Arrays.copyOf(zahlen, zahlen.length +1);
                zahlen = temp;
                zahlen[counter] = i;
                counter ++;
            }
        }


        return  zahlen;
    }
}
