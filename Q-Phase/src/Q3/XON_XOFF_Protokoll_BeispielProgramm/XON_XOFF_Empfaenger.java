package Q3.XON_XOFF_Protokoll_BeispielProgramm;

import serialio.Serial;

import java.io.IOException;
import java.util.Scanner;

//Code by Linus Busch
public class XON_XOFF_Empfaenger {
    private final int XON = 0x11; // DC1
    private final int XOFF = 0x13; // DC3
    private final int ETB = 0x17; // End of Transmission Block
    private byte[] puffer;
    private int groessePufferspeicher;
    private Serial com;

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        //Schönheit
        System.out.println("******************************");
        System.out.println("*     XON-XOFF-Empfänger     *");
        System.out.println("******************************\n");

        System.out.print("Geben sie die COM-Port-Nummer ein: ");
        int portNR = scan.nextInt();


        XON_XOFF_Empfaenger Drucker = new XON_XOFF_Empfaenger(portNR);

        // Prüfen ob Port sich öffnen lässt
        if (!Drucker.oeffnePort()){
            System.exit(0);
        }

        Drucker.empfangeTextUndDrucke();
        Drucker.schliessePort();

    }

    public XON_XOFF_Empfaenger(int portNR) throws IOException {
        // Initialisiere die serielle Schnittstelle
        com = new Serial("COM" +portNR , 9600, 8, 1, 0);

        //Puffer mit Größe n initialisieren
        groessePufferspeicher = 3; // Beispielgröße, anpassen nach Bedarf
        puffer = new byte[groessePufferspeicher];

        // Werte im Puffer auf -1 setzen (leerer Zustand)
        for (int i = 0; i < puffer.length; i++) {
            puffer[i] = -1;
        }



    }

    public boolean oeffnePort(){
        try {
            com.open();
            System.out.println("\nSysteminfo: COM-Port wurde jetzt geöffnet.");

            // XON senden
            com.write(XON);
            System.out.println("Systeminfo: XON wurde gesendet.");
            return true;
        } catch (IOException e) {
            System.out.println("Fehler: Fehler beim Öffnen der Schnittstelle!");
            return false;
        }
    }

    public void empfangeTextUndDrucke() throws IOException {
        try {
            boolean ende = false;

            while (com.dataAvailable() >= 0 && !ende) {

                if (istPufferVoll()) {
                    com.write(XOFF);
                    System.out.println("Systeminfo: XOFF wurde gesendet - Puffer ist voll.\n");
                    druckePufferLeer();
                    com.write(XON);
                    System.out.println("Systeminfo: XON wurde gesendet\n");
                } else {
                    int data = com.read();
                    if (data == ETB) {
                        druckePufferLeer();
                        com.write(XOFF);
                        ende = true;
                    } else {
                        // Füge das empfangene Zeichen in den Puffer ein
                        for (int i = 0; i < puffer.length; i++) {
                            if (puffer[i] == -1) { // Finde die erste freie Position
                                puffer[i] = (byte) data;
                                break;
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Systeminfo: Es ist ein Fehler beim Empfangen / Drucken aufgetreten!");
        }
    }

    private boolean istPufferVoll(){
        for (byte b : puffer) {
            if (b == -1) {
                return false; // Mindestens ein Platz im Puffer ist frei
            }
        }
        return true; // Kein Platz im Puffer ist frei
    }

    private void druckePufferLeer(){

        System.out.print("Systeminfo - Druck: ");
        // Drucke den Inhalt des Puffers
        for (int i = 0; i < puffer.length; i++) {

            if(puffer[i] != -1){
                System.out.print((char) puffer[i]);
            }

            try {
                Thread.sleep(500); // Warte 0,5 Sekunden zwischen jedem Zeichen
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            puffer[i] = -1; // Setze die Position im Puffer zurück auf -1 (leer)
            if (i == puffer.length - 1) {
                System.out.println(); // Neue Zeile nach dem Drucken des Puffers
            }
        }

        System.out.println();                                                           //Schönheit
        System.out.println("Systeminfo: Puffer geleert");
    }

    //Dies ist die Methode für das Beenden der Verbindung
    public void schliessePort(){
        try {
            com.close();
            System.out.println("Systeminfo: COM-Port wurde jetzt geschlossen.");
        } catch (IOException e) {
            System.out.println("Fehler: Fehler beim Schließen der Schnittstelle!");
        }
    }
}
