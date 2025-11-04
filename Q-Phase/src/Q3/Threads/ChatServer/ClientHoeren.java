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
                System.out.println("\n" + message + "\n");
                System.out.print("Eingabe: ");
            }

        } catch (IOException e){
            System.out.println("Fehler beim Lesen der Nachrichten an den Client");
        }
    }
}
