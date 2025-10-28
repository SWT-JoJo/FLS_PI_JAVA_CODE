package Q3.Socket.EchoServerFabian;

import socketio.*;

public class EchoServer {
    private int port = 1235;
    private ServerSocket sSocket;
    private Socket cSocket;
    private int clientNr = 1;

    public EchoServer() throws Exception{
        sSocket = new ServerSocket(port);
        System.out.println("Server ist gestartet!\n");
        System.out.println("Server wartet auf Client " + clientNr + "!");
        cSocket = sSocket.accept();
        System.out.println("Client wurde akzeptiert!\n");
        kommunizieren();
    }

    public void kommunizieren() throws Exception{
        System.out.println("Server wartet auf Nachricht vom Client " + clientNr + "!");
        String nachricht;
        String endKey = "over";
        while(true){
            // Blockierend auf eine Nachricht warten
            nachricht = cSocket.readLine();
            System.out.println("Client " + clientNr + " schreibt: " + nachricht);     //Ausgabe verbessern nach Aufgabe
            cSocket.write(nachricht);
            if (nachricht.contains(endKey)){
                break;
            }
        }
        beenden();
    }

    public void beenden() throws Exception{
        sSocket.close();
        cSocket.close();
        System.out.println("Die Socket-Verbindung wurde geschlossen!");
    }

    public static void main(String[] args) {
        try {
            new EchoServer();
        } catch (Exception e) {
            System.out.println("Fehler: " + e.getMessage());
        }
    }
}
