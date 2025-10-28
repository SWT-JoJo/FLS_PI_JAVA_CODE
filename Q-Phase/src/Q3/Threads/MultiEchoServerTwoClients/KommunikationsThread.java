package Q3.Threads.MultiEchoServerTwoClients;

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
            clientSocket.write("Dir wurde vom Server die Clientnummer: " + clientNumber + " zugeteilt\n");
            String temp;
            do {
                 temp = clientSocket.readLine();
                System.out.println("Client " + clientNumber + " Sagt: " + temp);
                clientSocket.write(temp + "\n");

                if(temp.contains("over")){
                    break;
                }
            } while (!end(temp));

            clientSocket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean end(String message){
        if(message.contains("over")){
            return true;
        }

        return false;
    }

}
