package Q1.SortierAlgorythmen;

import java.text.*;
import java.util.*;
/**
 * L�sung: Vergleich Sortierverfahren
 */

public class VerwaltungSortieralgorithmen {

    private int[] zufallsZahl;
    private int anzahlWiederholungen;
    private double mittelwertMillisekunden;
    private int auswahl;
    private int auswahlAusgangszahlen;

    //SortierObjekte


    public VerwaltungSortieralgorithmen(){

        Scanner sc = new Scanner(System.in);

        System.out.println("\n\n\tWelches Sortierverfahren moechten Sie verwenden?");
        System.out.print("\t(1: BubbleSort, 2:SelectionSort, 3: InsertionSort, 4: QuickSort): ");
        auswahl = sc.nextInt();
        System.out.print("\n\tWie viele Zahlen moechten Sie sortieren: ");
        int anzahl = sc.nextInt();
        System.out.print("\n\tWie oft soll die Sortierung f�r die Zeitmessung wiederholt werden: ");
        anzahlWiederholungen = sc.nextInt();

        System.out.println("\n\tWie sollen die Ausgangszahlen generiert werden?");
        System.out.print("\t(1: worst case BubbleSort/InsertionSort, 2: worst case SelectionSort/QuickSort, 3: Zufallszahlen): ");
        auswahlAusgangszahlen = sc.nextInt();

        System.out.println();
        zufallsZahl= new int[anzahl];
    }
    // Anfang Methoden

    private void generiereZufallsZahlen(int auswahl){

        if (auswahl == 1) {      //10,9,8,7,6,5,4,3,2,1,
            //Worst Case BubbleSort und InsertionSort
            for(int i=0;i< zufallsZahl.length;i++){
                zufallsZahl[zufallsZahl.length-i-1] = (i+1);
            }

        }
        else if (auswahl == 2) { //2,3,4,5,6,7,8,9,10,1
            //Worst Case SelectionSort und Quicksort
            for(int i=0;i< zufallsZahl.length-1;i++){
                zufallsZahl[i] = (i+2);
            }
            zufallsZahl[zufallsZahl.length-1] = 1;
        }
        else if (auswahl == 3) {

            final int UNTERGRENZE=1;
            final int OBERGRENZE=zufallsZahl.length;

            for(int i=0;i<zufallsZahl.length;i++){

                int temp = (int) ((OBERGRENZE-UNTERGRENZE+1)*Math.random()+UNTERGRENZE);

                for(int j=0;j<i;j++){
                    while (zufallsZahl[j]==temp){
                        temp = (int) ((OBERGRENZE-UNTERGRENZE+1)*Math.random()+UNTERGRENZE);
                        j=0;
                    }
                }
                zufallsZahl[i] = temp;
            }
        }



    }
    private void sortierungMitZeitTest(){
        DecimalFormat df = new DecimalFormat("#,##0.00");
        DecimalFormat df1 = new DecimalFormat("#,##0");
        int anzahlSchleifendurchlauefe = 0;
        int anzahlTauschvorgaenge = 0;
        System.out.println("\n\n\n\tSortierung ist gestartet! ");

        long anfang = Calendar.getInstance().getTimeInMillis();
        //Date anfang = new Date(System.currentTimeMillis());
        // anfang = cal.get(Calendar.MILLISECOND) ;

        switch (auswahl) {
            case 1:
                //Bubble Sort
                BubbleSort bs = new BubbleSort();
                zufallsZahl = bs.bubbleSort(zufallsZahl);
                anzahlTauschvorgaenge = bs.getAnzahlTauschvorgaenge();
                anzahlSchleifendurchlauefe = bs.getAnzahlSchleifendurchlaeufe();
                break;
            case 2 :
                //SelectionSort
                zufallsZahl = SelectionSort.selectionSort(zufallsZahl);
                anzahlTauschvorgaenge = SelectionSort.getAnzTauschdurchgaenge();
                anzahlSchleifendurchlauefe = SelectionSort.getAnzSchleifendurchlauefe();
                break;
            case 3 :
                //InsertioSort
                InsertionSort iSort = new InsertionSort();
                zufallsZahl= iSort.insertionsort(zufallsZahl);
                anzahlSchleifendurchlauefe = iSort.getAnzahlSchleifendurchlaeufe();

                //Ausgabe der Tauschvorg�nge macht wenig Sinn
                break;
            case 4 :
                //QuickSort
                QuickSort QS = new QuickSort();
                zufallsZahl = QS.quickSort(zufallsZahl, 0, zufallsZahl.length -1);

                break;
            default:

        }

        long ende = Calendar.getInstance().getTimeInMillis();

        long milliSekunden = (ende - anfang);
        System.out.println("\tSortierung ist beendet!\n");
        mittelwertMillisekunden += milliSekunden;
        System.out.println("\tZeitdauer des Sortiervorganges: " + df.format(((double) milliSekunden)/1000) + " Sekunden (" + df.format(((double) milliSekunden)/60000) + " Minuten)");
        System.out.println("\tZeitdauer des Sortiervorganges in Millisekunden: " + df1.format(milliSekunden));
        System.out.println("\tAnzahl Schleifendurchl�ufe bei der Sortierung: " + df1.format(anzahlSchleifendurchlauefe));
        System.out.println("\tAnzahl Tauschvorgaenge bei der Sortierung: " + df1.format(anzahlTauschvorgaenge));

    }

    //nur f�r die Ausgabe der Ursprungszahlenfolge
    private void ausgabeUnsortiert(){
        System.out.println("********************************************************************************");
        System.out.println("\n\tUnsortierte Ausgabe: " );
        System.out.println("\tHinweis: Aus Platzgr�nden werden max. die ersten 100 Zahlen angezeigt!\n");
        for ( int i = 0 ;i< zufallsZahl.length  ;i++  ) {
            if (i < 100) {
                System.out.print(zufallsZahl[i] + ", ");
            }
        }
    }

    private void ausgabeSortiert(){
        System.out.println("\n\tSortierte Ausgabe: ");
        System.out.println("\tHinweis: Aus Platzgr�nden werden max. die ersten 100 Zahlen angezeigt!\n");
        for ( int i = 0 ;i< zufallsZahl.length  ;i++  ) {
            if (i < 100){
                System.out.print(zufallsZahl[i] + ", ");
            }
        }
        System.out.println("\n\n" );
    }

    public void ausgabeZeitmessung(){
        DecimalFormat df = new DecimalFormat("#,##0.00");
        DecimalFormat df1 = new DecimalFormat("#,##0");
        double durchschnittlicheZeit =  mittelwertMillisekunden/anzahlWiederholungen;
        durchschnittlicheZeit = durchschnittlicheZeit;  //Sekundenberechnung
        System.out.println("********************************************************************************");
        System.out.println("\n\tAuswertung:");
        System.out.println("\n\tDurchschnittliche Sortierzeit: " + df.format(durchschnittlicheZeit/1000) + " Sekunden (" + df.format(durchschnittlicheZeit/60000) + " Minuten) bei " + anzahlWiederholungen + " Durchlaeufen!");
        System.out.println("\tZeitdauer des Sortiervorganges in Millisekunden: " + df1.format(durchschnittlicheZeit));

    }

    public static void main (String[] args) {
        VerwaltungSortieralgorithmen vsv = new VerwaltungSortieralgorithmen();

        for (int i=0;i < vsv.anzahlWiederholungen;i++ ) {
            vsv.generiereZufallsZahlen(vsv.auswahlAusgangszahlen);
            vsv.ausgabeUnsortiert();
            vsv.sortierungMitZeitTest();
            vsv.ausgabeSortiert();
        }
        vsv.ausgabeZeitmessung();
        System.out.println();
        System.out.println();
    }
}


