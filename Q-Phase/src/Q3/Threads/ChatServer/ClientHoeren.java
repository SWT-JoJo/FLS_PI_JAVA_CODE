package Q3.Threads.ChatServer;

import socketio.Socket;

import java.io.IOException;

public class ClientHoeren extends Thread {
    Socket socket;

    public  ClientHoeren(Socket socket) {
        this.socket = socket;
    }


    public void run() {
        try {
            while (true) {
                String message = socket.readLine();
                System.out.print("\b\b\b\b\b\b\b\b\b");
                System.out.println("\n"+message + "\n");
                System.out.print("Eingabe: ");
            }

        } catch (IOException e){
            System.err.println("Fehler beim Lesen der Nachrichten ODER der Server wurde beendet");
        }
    }
}
