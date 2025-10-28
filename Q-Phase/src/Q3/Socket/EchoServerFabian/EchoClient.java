package Q3.Socket.EchoServerFabian;

import socketio.*;

import java.util.Scanner;

public class EchoClient {
    private String host = "localhost";
    private int port = 1235;
    private Socket cSocket;

    public EchoClient() throws Exception {
        cSocket = new Socket(host, port);
        System.out.println("Client ist gestartet!\n");
        verbinden();
    }

    public void verbinden() throws Exception {
        cSocket.connect();
        System.out.println("Verbindung zum Server ist aufgebaut!\n");
        kommunizieren();
    }

    public void kommunizieren() throws Exception {
        String endKey = "over";
        Scanner scan = new Scanner(System.in);
        String eingabe = "";
        do {
            System.out.print("Eingabe: ");
            eingabe = scan.nextLine();
            cSocket.write(eingabe + "\n");

            // Warte auf Antwort vom Server
            String antwort = cSocket.readLine();
            System.out.println("Server Antwort: " + antwort);

            // Prüfe ob Verbindung beendet werden soll
            if (eingabe.contains(endKey)) {
                if (beenden()) {
                    System.out.println("\n\nDie Verbindung zum Server wurde geschlossen!");
                    System.exit(0);
                } else {
                    System.out.println("Die Verbindung zum Server konnte nicht geschlossen werden!");
                }
            }
        } while (!eingabe.equals(endKey));
    }

    public boolean beenden() throws Exception {
        cSocket.close();
        return true;
    }

    public static void main(String[] args) {
        try {
            new EchoClient();
        } catch (Exception e) {
            System.out.println("Fehler: " + e.getMessage());
        }
    }
}

