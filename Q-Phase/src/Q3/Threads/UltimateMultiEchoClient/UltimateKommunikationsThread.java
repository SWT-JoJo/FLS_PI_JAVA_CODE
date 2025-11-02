package Q3.Threads.UltimateMultiEchoClient;

import socketio.Socket;

import java.io.IOException;
import java.util.ArrayList;

public class UltimateKommunikationsThread extends Thread {
    private int clientNumber;
    private ArrayList<Socket> clientSockets;

    public UltimateKommunikationsThread( ArrayList<Socket> clientSockets, int clientNumber) {
        this.clientSockets = clientSockets;
        this.clientNumber = clientNumber;
    }

    public void run() {
        Socket clientSocket = clientSockets.getLast();
        try {
            clientSocket.write("Dir wurde folgende Clietnummer zugteilt: " + clientNumber + "\n");
            String message = "";
            do {
                 message = clientSocket.readLine();
                System.out.println("Client " + clientNumber + " sagt: " + message);

                for(Socket socket : clientSockets) {
                    if(socket == clientSocket) {
                        socket.write("Server Antwort: " + message + "\n");
                    }
                    else  {
                        socket.write("Client "  + clientNumber + " sagt: " + message + "\n");
                    }
                }

            } while (!end(message));

            clientSockets.remove(clientSocket);

        } catch (IOException e) {
            System.err.println("Fehler der Kommunikation mit Client " + clientNumber + "\n");
            clientSockets.remove(clientSocket);
        }


    }

    public boolean end(String message){
        if(message.contains("over")){
            return true;
        }

        return false;
    }

}
