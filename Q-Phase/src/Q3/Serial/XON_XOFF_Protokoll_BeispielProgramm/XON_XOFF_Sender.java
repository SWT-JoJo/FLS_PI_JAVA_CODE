package Q3.Serial.XON_XOFF_Protokoll_BeispielProgramm;

import serialio.Serial;

import java.io.IOException;
import java.util.Scanner;

public class XON_XOFF_Sender {

    //Festlegen der Steuerzeichen
    private final int XON = 0x11;
    private final int XOFF = 0x13;
    private final int ETB = 0x17;

    //Serial Objekt
    private Serial con;

    //Variable für Systemausgabenformatierung
    String sys = "SYSTEM-INFO:\t\t";


    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scan = new Scanner(System.in);


        //Schönheit
        System.out.println("*****************************");
        System.out.println("*      XON-XOFF-Sender      *");
        System.out.println("*****************************\n");

        //Eingabe des Comports und das Initialisieren des Serial Objekts con, um die Verbindung her zu Stellen
        System.out.print("Geben sie die die COM-Port-Nummer ein: ");
        int portnr = scan.nextInt();

        scan.nextLine(); //Damit das \n von der int eingabe nicht automatisch die weitern Eingaben überspringt

        XON_XOFF_Sender sender = new XON_XOFF_Sender(portnr);       //Erstellen eines Sender objektes + Aufrufen des Konstruktors mit der portnr


        //Öffnen des Portes
        System.out.println(sender.sys + "Öffne Port\n");
        if(!sender.oeffnePort()){                                   //Wenn die Mehthe false (kein offnener Port) gibt, beenden des Programms
            System.out.println(sender.sys + "Programm wird beednet");
            System.exit(0);
        }

        System.out.println();

        //Texteingabe, die "gedruckt" werden soll
        System.out.println("Geben sie den Text ein, der gedruckt werden soll: ");
        String text = scan.nextLine();

        //Text mit der Methode senden
        System.out.println(sender.sys + "Text wird gesendet\n");
        sender.sendeText(text);


        //Schließen des Ports
        System.out.println(sender.sys + "Schließe Port");
        sender.schliessePort();
    }



    //Konstruktor
    public XON_XOFF_Sender(int portnr) throws IOException {
        con = new Serial("COM" + portnr, 9600, 8, 1, 0);
    }



    public boolean oeffnePort() throws IOException {

        if(con.open()){
            System.out.println(sys + "Port wurde geöffnet!\n");

            System.out.println(sys + "Warten auf XON\n");
            while (con.read() != XON);
            System.out.println(sys + "XON empfangen!\n");
            return true;

        }


        System.out.println(sys  + "Fehler beim öffnen des Portes\n");
        return false;
    }


    public void sendeText(String text) throws IOException, InterruptedException {
        byte[] b = text.getBytes();

        boolean waitForXON = false;

        for (int i = 0; i < b.length; i++){

            System.out.println(sys + "Sende Zeichen: " + (char) b[i] + "  (" +b[i] + ")");
            con.write(b[i]);


            //Prüfen ob vom Empfänger daten gesendet wurden und ob es sich dabei um XOFF handelt um die Info auszugeben und die Wartende Schleife zu Starten
            if(con.dataAvailable() > 0 && con.read() == XOFF){
                System.out.println( sys + "XOFF empfangen, warten auf XON - Übertragung Paussiert\n");
                waitForXON = true;
                while (waitForXON){if(con.dataAvailable() > 0 && con.read() == XON) {waitForXON = false;}};     //Solange wait auf XON true, dauerhaft prüfen ob XON kommt und dann die Variable false setzen um die Schleife zu verlassen

                System.out.println(sys + "XON Erhalten, Übertragung wird Fortgesetzt\n");

            }
            else {
                System.out.println(sys + "Kein XOFF erhalten, übertragung wird fortgesetzt");
            }

            System.out.println("\n");
            Thread.sleep(500); //Einfach eine kurze Pause denn der Code muss auch mal Chillen :)  -> Der Drucker steht in einer deutschen Behörde und ist entsprechend "modern"
        }

        con.write(ETB); //Senden von ETB zum Schluss

        System.out.println(sys + "Der Text wurde vollständig übertragen");
    }

    public void schliessePort() throws IOException {
        con.close();
    }

}
