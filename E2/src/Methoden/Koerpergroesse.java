package Methoden;

import java.util.Scanner;

public class Koerpergroesse {

    String[] geschlechter = {"maennlich" , "weiblich"};
    String usergeschlecht;
    double oberschenkel;
    int alter;
    double schaetzungGroesse;

    public static void main(String[] args) {
     Koerpergroesse koerpergroesse = new Koerpergroesse();
     koerpergroesse.eingabe();
     koerpergroesse.verarbeitung();
     koerpergroesse.ausgabe();
    }

    void eingabe(){
        Scanner scan = new Scanner(System.in);
        System.out.println("*******************************************************************");
        System.out.println("*                      Koerpergroessen Rechner                    *");
        System.out.println("*******************************************************************");
        System.out.println();

        System.out.print("Wie lang ist ihr Oberschenkel: ");
        oberschenkel = scan.nextDouble();
        System.out.print("Wie alt sind sie: ");
        alter = scan.nextInt();
        System.out.println("Geschlecht:" + geschlechter[0]  +"(1)"  + "oder "+  geschlechter[1] + "(2):  ");
        usergeschlecht = geschlechter[scan.nextInt() -1];
    }

    void verarbeitung(){
        int temp = alter - 30;

        if(usergeschlecht.equalsIgnoreCase(geschlechter[0])){
            schaetzungGroesse = oberschenkel  * 2.238 +  0.69089;

        }
        else if(usergeschlecht.equalsIgnoreCase(geschlechter[1])){
            schaetzungGroesse = oberschenkel  * 2 +  0.61417;
        }
        for(int i = 0; i < temp; i++){
            schaetzungGroesse = schaetzungGroesse - 0.0006;
        }

        schaetzungGroesse = ((int) (schaetzungGroesse * 100)) / 100.0;
    }

    void ausgabe(){
        System.out.println("Sie sind " + alter + " Jahre alt " + usergeschlecht + " und haben eine Oberschenkellänge von " + oberschenkel +"m");
        System.out.println("Sie sind schätzungsweise " + schaetzungGroesse + " m groess");
    }
}
