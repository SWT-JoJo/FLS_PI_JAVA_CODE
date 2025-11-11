package Q3.Threads.EchoServerBeliebigVieleClients;

import socketio.Socket;
import java.io.IOException;

public class KommunikationsThread extends Thread {
    private int clientNumber;
    private Socket clientSocket;

    public KommunikationsThread(Socket clientSocket, int clientNumber) {
        this.clientSocket = clientSocket;
        this.clientNumber = clientNumber;
    }

    public void run() {
        try {
            clientSocket.write(clientNumber + "\n");
            String temp;
            do {
                temp = clientSocket.readLine();
                System.out.println("Client " + clientNumber + " Sagt: " + temp + "\n");
                clientSocket.write(temp + "\n");

                if(temp.contains("over")){
                    break;
                }
            } while (!end(temp));

            clientSocket.close();

        } catch (Exception e) {
            System.err.println("Fehler bei der Clientkommunikation mit Client " + clientNumber + " aufgetreten - Kommunikation beendet\n");

            Thread.currentThread().interrupt(); //Thread beenden
        }
    }

    public boolean end(String message){
        if(message.contains("over")){
            System.out.println("Client " + clientNumber + "disconnected\n");
            return true;
        }

        return false;
    }

}
