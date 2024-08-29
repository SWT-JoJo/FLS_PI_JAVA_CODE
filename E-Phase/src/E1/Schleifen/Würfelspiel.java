package Schleifen;

import java.util.Scanner;

public class Würfelspiel {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int anzahl;
        System.out.print("geben sie an wie oft sie würfenl wollen: ");
        anzahl =  scan.nextInt();

        for(int i = 0; i < anzahl; i++){
            int würfel = (int) (Math.random() * 6 + 1);

            System.out.println("Sie haben eine " + würfel + " gewürfelt");

            if(würfel == 6){
                System.out.println("Sie haben gewonnen");
                break;
            }
            else {
                System.out.println("Niete");
            }
        }

    }
}
