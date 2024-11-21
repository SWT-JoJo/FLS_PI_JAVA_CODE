package Q1.ArrayListen.SchuleErweiterung;

import java.util.ArrayList;
import java.util.Scanner;

public class Verwaltung {
    private final ArrayList<Klasse> meineKlassen = new ArrayList<>();
    public static void main(String[] args) {
        Verwaltung vw = new Verwaltung();
        vw.eingabe();
    }

    public  void eingabe() {
        Scanner scan = new Scanner(System.in);
        boolean neueKlasseAnlegen = false;
        System.out.println("***********************************");
        System.out.println("*           Verwaltung            *");
        System.out.println("***********************************");
        System.out.println();

        //Auswahlmenue
        int selection = 0;
        System.out.println("Bitte wählen sie aus \n 1: neue Klasse erstellen \n 2: Klassenliste ausgeben\n 0: Programm beeden ");
        do {
            System.out.print("Auswahl: ");
            selection = scan.nextInt();

            if(selection < 0 || selection > 2 ){
                System.out.println("Ungültige eingabe;");
            }
        } while (selection < 0 || selection > 2 );

        switch (selection){
            case 0:
                System.exit(0);

            case 1:
                neueKlasseAnlegen = true;
                break;

            case 2:
                System.out.println();
                System.out.println("Bitte wählen sie die Klasse aus, für die sie die Klassenliste haben möchten:");
                for (Klasse k : meineKlassen){
                    System.out.println((meineKlassen.indexOf(k) + 1 )+". " + k.getName() + " - " + k.getMeinTutor().getName() + " (" + k.getMeinTutor().getKuerzel()+")");
                }
                int klassenSelection = 0;
                do {
                    System.out.print("Auswahl: ");
                    klassenSelection = scan.nextInt();
                    if (klassenSelection <= 0 || klassenSelection > meineKlassen.size()){
                        System.out.println("Ungültige eingabe\n");
                    }
                } while (klassenSelection <= 0 || klassenSelection > meineKlassen.size());

                ausgabe(meineKlassen.get(klassenSelection -1));
        }

        System.out.println("\n");
        while (neueKlasseAnlegen) {
            automatischeEingabe();
            /*System.out.println("Neue Klasse erstellen");
            System.out.print("Geben sie den Klassennamen ein: ");
            Klasse tempKlasse = new Klasse(scan.next());
            System.out.println("Klasse erfolgreich erstellt\n");


            System.out.print("Geben sie nun den Namen des Tutors ein: ");
            String newTutorName = scan.next();
            System.out.print("Geben sie nun das Kürzel des Tutors ein: ");
            String newTutorKuerzel = scan.next();
            tempKlasse.setMeinTutor(new Lehrer());
            tempKlasse.getMeinTutor().setName(newTutorName);
            tempKlasse.getMeinTutor().setKuerzel(newTutorKuerzel);
            System.out.println("Tutor erfolgreich zugewiesen");
            System.out.println();

            System.out.print("Geben sie nun an, wie viele Schüler sie der Klasse hinzufügen wollen: ");
            int addStudents = scan.nextInt();
            for (int i = 0; i < addStudents; i++) {
                System.out.print("Geben sie den Namen des Schuelers ein: ");
                tempKlasse.neueSchueler(scan.next());
                System.out.println("\n");
            }
            meineKlassen.add(tempKlasse);
            System.out.println("Alle Schueler erfolgreich hinzugefügt");
            System.out.println();
            System.out.println();

             */
            neueKlasseAnlegen = false;
        }
       eingabe();
    }

    public  void ausgabe(Klasse klasse) {
        Scanner scan = new Scanner(System.in);
        System.out.println();
        System.out.println("Welche Liste wollen sie\n 1: vollständig\n 2: nur Namen:");
        int temp;
        do {
            System.out.print("Auswahl: ");
            temp = scan.nextInt();
            if(temp < 1 || temp > 2){
                System.out.println("Ungültige Auswahl");
            }
        } while (temp < 1 || temp > 2);

        System.out.println("***********************************");
        System.out.println("*          Klassenliste           *");
        System.out.println("***********************************");
        System.out.println();

        System.out.println("Klassenbezeichnung: " + klasse.getName());
        System.out.println("Tutor: " + klasse.getMeinTutor().getName() + " (" + klasse.getMeinTutor().getKuerzel()+")");
        System.out.println();
        if(temp == 1){
            System.out.println("Alle Schüler der Klasse "+ klasse.getName() + " mit ihren Kursen:" );
            System.out.println(klasse.AusgabeSchuelerMitKurs());
        } else {
            System.out.println("Alle Schüler der Klasse " + klasse.getName() + " :");
            klasse.Schuelerausgabe();
        }
    }

    public void automatischeEingabe(){
        Klasse meineKlasse = new Klasse("BG12-DV-" + (meineKlassen.size()+1));
        meineKlasse.setMeinTutor(new Lehrer());
        meineKlasse.getMeinTutor().setKuerzel("DAUM");
        meineKlasse.getMeinTutor().setName("Daum");

        meineKlasse.neueSchueler("Max Muster");
        meineKlasse.neueSchueler("Friedrich List");
        meineKlasse.neueSchueler("Tim Tester");
        meineKlasse.neueSchueler("Birgit Beispiel");


        for(Schueler temp: meineKlasse.getMeineSchueler()){
            temp.neuenKursHinzufuegen("LK PI: Objektorientierte Softwareentwickelung", 6);
        }


        meineKlasse.getMeineSchueler().get(0).neuenKursHinzufuegen("GK IT: Betriebssysteme", 3);
        meineKlasse.getMeineSchueler().get(0).neuenKursHinzufuegen("GK Englisch: The Challenge of Individualism", 3);
        meineKlasse.getMeineSchueler().get(1).neuenKursHinzufuegen("GK Sport: Fussball", 2);
        meineKlasse.getMeineSchueler().get(1).neuenKursHinzufuegen("GK Englisch: The Challenge of Individualism", 3);
        meineKlasse.getMeineSchueler().get(2).neuenKursHinzufuegen("GK IT: Betriebssysteme", 3);
        meineKlassen.add(meineKlasse);
    }
}