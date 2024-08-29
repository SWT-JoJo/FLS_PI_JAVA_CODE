package E2.Methoden;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Teilbarkeit {

    public static void main(String[] args) {
        Teilbarkeit tk = new Teilbarkeit();
        tk.input();
    }

    void input(){
        System.out.println("*******************************************************************");
        System.out.println("*                           Teilbarkeit                           *");
        System.out.println("*******************************************************************");
        System.out.println();
        Scanner scan = new Scanner(System.in);

        System.out.println("Geben sie die Zahl ein: ");
        int zahl = scan.nextInt();
        System.out.println("Geben sie den Divisor ein: ");
        int divisor = scan.nextInt();

        boolean teilbar = teilbar(zahl, divisor);
        int[] teilbareZahlen = teilbarkeit(zahl);
        output(zahl, divisor, teilbar, teilbareZahlen);
    }

    public void output(int zahl, int divisor, boolean teilbar, int[] teilbareZahlen){
        DecimalFormat df_number = new DecimalFormat("#,###,###,##0.####");

        if(teilbar){
            System.out.println(zahl + " durch " + divisor + " teilen ist glatt möglich");
        } else{
            System.out.println(zahl + " durch " + divisor + " teilen ist glatt NICHT möglich");
            System.out.println("Rauskommen würde: " + df_number.format( (double) zahl / divisor));
        }

        System.out.println();
        System.out.println(zahl +" ist teilbar durch: ");
        for (int i = 0; i < teilbareZahlen.length; i++){
            if(teilbareZahlen[i] == 0){
                break;
            }
            System.out.print(teilbareZahlen[i] + "\t");
        }
    }
    public boolean teilbar(int zahl, int divisor){
        boolean teilbar;
        if(zahl % divisor == 0){
            teilbar =   true;
        }
        else {
            teilbar = false;
        }

        return teilbar;
    }

    public int[] teilbarkeit(int zahl){
        int[] zahlen = new int[zahl];
        int counter = 0;
        for(int i = 1; i <= zahl; i++){
            if(zahl % i == 0){
                zahlen[counter] = i;
                counter++;
            }
        }
        return zahlen;
    }

}
