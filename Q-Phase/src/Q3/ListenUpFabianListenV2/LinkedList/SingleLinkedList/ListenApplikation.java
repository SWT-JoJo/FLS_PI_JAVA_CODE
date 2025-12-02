package Q3.ListenUpFabianListenV2.LinkedList.SingleLinkedList;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class ListenApplikation {
    private ADListe adliste;

    ListenApplikation(ADListe adliste) {
        this.adliste = adliste;

        menue();
    }

    public static void main(String[] args){
        Knoten standartKnoten = new Knoten("MusterDaten");
        new ListenApplikation(new ADListe(standartKnoten));
    }

    public void menue(){
        Scanner scan = new Scanner(System.in);
        String daten;

        while (true) {
            System.out.println("************************");
            System.out.println("      Auswahlmenue      ");
            System.out.println("************************");

            System.out.println("Programmende\t\t\t\t\t\t\t ---> 0");
            System.out.println("Knoten vorne Einfuegen\t\t\t\t\t ---> 1");
            System.out.println("Knoten Hinten einfuegen\t\t\t\t\t ---> 2");
            System.out.println("Liste anzeigen (vorne -> hinten)\t\t ---> 3");
            System.out.println("Daten suchen (vorne -> hinten)\t\t\t ---> 4");
            System.out.println("\n");

            System.out.print("Ihre Auswahl: ");
            int selection;
            try {
                selection = scan.nextInt();
            } catch (Exception e) {
                selection = -1;
            }

            scan.nextLine();

            switch (selection) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    System.out.println("Geben sie die Daten ein: ");
                    daten = scan.nextLine();
                    adliste.neuenKnotenHinzufuegenVorne(daten);
                    break;
                case 2:
                    System.out.println("Geben sie die Daten ein: ");
                    daten = scan.nextLine();
                    adliste.neuenKnotenHinzufuegenHinten(daten);
                    break;
                case 3:
                    adliste.auslesenAllerKnotenVonVorne();
                    break;
                case 4:
                    System.out.println("Geben sie die zu suchenden Daten ein: ");
                    daten = scan.nextLine();
                    Knoten k =  adliste.sucheDatenVonVorne(daten);
                    if(k == null){
                        System.out.println("Kein Knoten mit den Daten gefunden :(");
                    }
                    else  {
                        System.out.println("Konten mit den  Daten Gefunden :)");
                    }
                    break;

                default:
                    System.err.println("\nIhre Kompetenz scheint leider nicht hoch genug zu sein eine Zahl aus dem Menue einzugeben, ich empfehle es ihnen dieses Programm mit der ZAHL 0 zu beenden oder die Anweisungen\n richtig zu lesen. \n Mit freundlichen Grüßen \n Ihre Systemadmin :)");
                    break;
            }

            System.out.println("\n\n");
        }
    }
}
