package E2.Methoden;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Mehrwertsteuer {

    public static void main(String[] args) {
        Mehrwertsteuer ms = new Mehrwertsteuer();
        ms.input();
    }

    public void input(){
        double betrag;
        Scanner scan = new Scanner(System.in);

        //Auswahl ob Brutto oder Netto
        int netoBruttoSelection;
        do {
            System.out.print("Auswahl Netto- oder Bruttobetrag (1: Nettobetrag 2: Brutto): ");
            netoBruttoSelection = scan.nextInt();

            if(netoBruttoSelection < 1 || netoBruttoSelection > 2){
                System.out.println("INVALID INPUT");
            }

        }while (netoBruttoSelection < 1 || netoBruttoSelection > 2);

        //Eingabe des Betrages
        if(netoBruttoSelection == 1){ //Nettobetrag ausgewählt
            System.out.print("Eingabe Nettobetrag: ");
        } else if (netoBruttoSelection == 2) { //Bruttobetrag ausgewählt
            System.out.print("Eingabe Bruttobetrag: ");
        }
        betrag = scan.nextDouble();

        //Auswahl der MwSt.
        int mwstSelection;
        do {
            System.out.print("Auswahl MwST-Statz (1: ermaessgt (=7%) 2: nicht ermaessigt (=19%)): ");
            mwstSelection= scan.nextInt();

            if( mwstSelection< 1 || mwstSelection > 2){
                System.out.println("INVALID INPUT");
            }

        }while (mwstSelection < 1 || mwstSelection > 2);


        // Berrechnung des Brutto/Netto wertes und der MwSt
        double mwst;
        double betragzwo;

        if(netoBruttoSelection == 1){ //Netto (Brutto wird berrechnet)
            mwst = berechneMwStvomNettoBetrag(betrag, mwstSelection);
            betragzwo = berechneBruttoBetragvomNettoBetrag(betrag, mwstSelection);
        } else { //Brutto (Netto wird berrechnet)
            mwst = berechneMwStvomBruttoBetrag(betrag, mwstSelection);
            betragzwo = berechneNettoBetragvomBruttoBetrag(betrag, mwstSelection);
        }

        output(mwst, betragzwo, netoBruttoSelection);

    }

    public void output(double mwst, double betragZwo, int nettoBruttoSelection){
        DecimalFormat df_money = new DecimalFormat("#,###,###,##0.## EUR");

        if(nettoBruttoSelection == 1){
            System.out.println("MwSt: " + df_money.format(mwst));
            System.out.println("Bruttobetrag: " + df_money.format(betragZwo));
        }
        else {
            System.out.println("MwSt: " + df_money.format(mwst));
            System.out.println("Nettobetrag: " + df_money.format(betragZwo));
        }
    }

    public double berechneMwStvomNettoBetrag(double nb, int mwsatzKennziffer){  // nb = nettobetrag
        double ergebniss;
        if(mwsatzKennziffer == 1)
        {
            ergebniss = nb * 0.07;
        }
        else{
            ergebniss = nb * 0.19;
        }

        return  ergebniss;
    }

    double berechneMwStvomBruttoBetrag(double bb, int mwsatzKennziffer){ // bb= bruttobetrag
        double ergebniss;
        if(mwsatzKennziffer == 1)
        {
            ergebniss = (bb * 0.07) / 1.07;
        }
        else{
            ergebniss = (bb * 0.19) / 1.19;
        }

        return  ergebniss;
    }

    double berechneNettoBetragvomBruttoBetrag(double bb, int mwsatzKennziffer){ //bb = bruttobetrag
        double ergebniss;

        if(mwsatzKennziffer == 1)
        {
            ergebniss = bb *  0.93; //0 - 1,07
        }
        else{
            ergebniss = bb * 0.81; //1 - 0,19
        }

        return  ergebniss;
    }

    double berechneBruttoBetragvomNettoBetrag(double nb, int mwsatzKennziffer){ //nb = nettobetrag
        double ergebniss;
        if(mwsatzKennziffer == 1)
        {
            ergebniss = nb  * 1.07;
        }
        else{
            ergebniss = nb * 1.19;
        }

        return  ergebniss;
    }



}