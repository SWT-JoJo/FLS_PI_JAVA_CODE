package Q3.SimplexChatProgramm;

import serialio.Serial;

import java.io.IOException;

public class SimplexChat_Empfänger {

    // Festlegen der Steuerzeichen
    private final int ETX = 0x03;
    private final int ACK = 0x06;

    // Blockierende Schleife, z.B. beim Warten auf DTR
    // while (!connection.isDTR())

    // Auf Empfängerseite macht der Einsatz von dataAvailable() Sinn, wenn der Empfänger auf Daten wartet

    // Auf Empfängerseite wird beim Einlesen von Strings auf ein /n gewartet!! Bitte beim senden berücksichtigen!

    public static void main(String[] args) {
        System.out.println("Systeminfo: Ich bin der Empfänger");

        new SimplexChat_Empfänger();    //Annonymes Objekt, welches nur dazu dient den Konstruktor auszuführen

    }

    public SimplexChat_Empfänger() {
        Serial connection;
        try {
            connection = new Serial("COM3", 9600, 8, 1, 0);
            try {
                connection.open();
            } catch (IOException e) {
                System.out.println("Fehler: Port konnte nicht geöffnet werden!");
                verbindungBeenden(connection);
            }
            System.out.println("\nSysteminfo: Port wurde geöffnet.");

            System.out.println("\nSysteminfo: Sende Betriebsbereitschaft (DTR)");
            connection.setDTR(true);
            System.out.println("Systeminfo: Betriebsbereitschaft wurde gesendet!");
            Thread.sleep(100);

            System.out.println("\nSysteminfo: Sende Empfangsbereitschaft (RTS)");
            connection.setRTS(true);
            System.out.println("Systeminfo: Empfangsbereitschaft wurde gesendet!");
            Thread.sleep(100);

            System.out.println("\nSysteminfo: Warte auf ACK");
            while (!connection.isCTS()) {
                Thread.sleep(100);
            }
            if (ACK == connection.read()) {
                System.out.println("Systeminfo: ACK empfangen!");
            } else {
                System.out.println("Systeminfo: Falsche ACK");
                verbindungBeenden(connection);
            }

            System.out.println("\nSysteminfo: Nachricht vom Sender live ausgeben:\n");
            empfangen(connection);


        } catch (Exception e) {
            System.out.println("Systeminfo: Irgendwas ist schiefgelaufen!");
            System.exit(-1);
        }

    }

    public void empfangen(Serial connection) {
        // Nachricht einlesen bis ETX
        StringBuilder message = new StringBuilder();
        try {

            while (true) {
                while (connection.dataAvailable() == 0) {
                    Thread.sleep(100);
                }
                int data = connection.read();
                if (data == ETX) {
                    System.out.println("\nSysteminfo: Warte auf ETX");
                    System.out.println("Systeminfo: ETX wurde empfangen!");
                    verbindungBeenden(connection);
                    break;
                } else {
                    message.append((char) data);
                    System.out.print((char) data); // Live-Ausgabe der Nachricht
                }
            }

        } catch (Exception e) {
            System.out.println("\nSysteminfo: Fehler beim Einlesen der Nachricht!");
            verbindungBeenden(connection);
        }
    }

    public void verbindungBeenden(Serial connection) {
        try {
            connection.close();
            System.out.println("Systeminfo: Übertragung wurde beendet");
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Fehler beim Verbindungsabbau!");
        }
    }

}
