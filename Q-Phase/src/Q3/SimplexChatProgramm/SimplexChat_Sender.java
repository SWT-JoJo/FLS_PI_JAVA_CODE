package Q3.SimplexChatProgramm;


import serialio.Serial;

import java.io.IOException;
import java.util.Scanner;

public class SimplexChat_Sender {

    //Festlegen der Steuerzeichen
    private final int ETX = 0x03;
    private final int ACK = 0x06;

    /*
    ------------------------------------------------------------------------------------------------------------------
    Infos:

        Blockierende Schleife, z.B. beim Warten auf DTR
        while (!connection.isDTR())

         Auf Empfängerseite macht der Einsatz von dataAvailable() Sinn, wenn der Empfänger auf Daten wartet

         Auf Empfängerseite wird beim Einlesen von Strings auf ein /n gewartet!! Bitte beim senden berücksichtigen!


    Hier folgt der Code :)
    ------------------------------------------------------------------------------------------------------------------
    */



    String Sysin = "Systeminfo:\t\t";

    public static void main(String[] args) throws IOException, InterruptedException {
        new SimplexChat_Sender();   //Annonymes Objekt, welches nur dazu dient den Konstruktor auszuführen
    }



    // Hier ist der tolle Konstruktor, dieser führt auch 90% des Codes aus
    public SimplexChat_Sender() throws IOException, RuntimeException, InterruptedException {


        //Schönheit
        System.out.println("*****************************");
        System.out.println("*   Simplex Chat Programm   *");
        System.out.println("*****************************\n");

        //Erstellen der Verbindung (Serial Objekt)
        Scanner scan = new Scanner(System.in);

        System.out.print("Geben sie vor dem Programmstart den COM Port ein (z.B. COM3): ");
        String port = scan.next().toUpperCase();
        Serial serial = new Serial(port, 9600, 8, 1,0);


        System.out.println("Programm Startet....\n\n\n");

        //Errichten der Verbindung
        System.out.println(Sysin + "Ich bin der Sender\n");

        serial.open();                                                            //Öffnen der Verbindung [LEEEETS GOOOOOO]
        System.out.println(Sysin + "Port wurde geöffnet.\n");

        Thread.sleep(50);

        //Warten bis der Empfänger berreit ist
        System.out.println(Sysin + "Warten auf Betriebsbereitschaft des Empfängers(DSR)!");
        while (!serial.isDSR());                                                //Blockierende Schleife
        System.out.println(Sysin + "Empfänger Betriebsbereit!\n");

        Thread.sleep(50);       //Kurze Pause :)

        //Warten auf die Empfangsberreitschaft des Empfängers
        System.out.println(Sysin + "Warten auf Empfangsbereitschaft des Empfängers(CTS)!");
        while (!serial.isCTS());                                            //Blockierende Schleife
        System.out.println(Sysin + "Empfänger Empfangsbereit!\n");

        Thread.sleep(50);       //Kurse Pause :)

        senden(serial);                // Aufrufen der Methode um beide

        Thread.sleep(50);

        verbindungBeenden(serial);

        System.exit(0);
    }

    public void senden(Serial serial) throws IOException, InterruptedException {
        Scanner scan = new Scanner(System.in);

        //Senden von ACK zum Start der Verbindung
        System.out.println(Sysin + "Sende ACK!");
        serial.write(ACK);
        System.out.println(Sysin+"ACK gesendet!\n");

        //Abfrage der Benutzereingabe
        System.out.println("Nachricht für den Empfänger eingeben und mit dem Wort \"Over\" abschließen:\n");

        String input = "";      //Temporäre Variable für den Input, standartmäßig leer
        while(!input.equalsIgnoreCase("over")){
            input = scan.nextLine();
            serial.write(input + "\n");
            Thread.sleep(50);       //Kurze Pause, bevor neue Daten eingegeben werden können
        }

        System.out.println("\n");

        //Beenden der Übertragung mit ETX
        System.out.println(Sysin + "Sende ETX!");
        serial.write(ETX);
        System.out.println(Sysin + "ETX gesendet!\n");

    }

    //Methode zum beenden der Verbindung, in dem serial geschlossen wird (serial.close();)
    public void verbindungBeenden(Serial serial) throws IOException {
        serial.close();
        System.out.println(Sysin + "Verbindung wurde beendet!\n");

    }
}
//Wilkommen am Ende des Codes :)