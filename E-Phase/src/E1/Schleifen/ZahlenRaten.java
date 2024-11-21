package E1.Schleifen;

import java.util.Scanner;

public class ZahlenRaten {
    public  static  void  main(String[] args){
        Scanner scan = new Scanner(System.in);

        boolean richtig = false;
        int zahl = (int) (Math.random() * 10 + 1);
        int counter = 0;

        while (!richtig){
            System.out.print("An welche zahl denke ich? : ");
            int userInput = scan.nextInt();
            counter++;

            if(userInput == zahl){
                System.out.println("Richtig");
                richtig = true;
            }else{
                System.out.println("Falsch, noch ein mal");
            }



        }
        System.out.println("Versuche: " + counter);
    }
}
