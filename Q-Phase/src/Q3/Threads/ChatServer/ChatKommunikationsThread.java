package Q3.Threads.ChatServer;

import socketio.Socket;

import java.io.IOException;
import java.util.ArrayList;

public class ChatKommunikationsThread extends Thread {
    private String name;
    private ArrayList<Socket> clientSockets;

    public ChatKommunikationsThread(ArrayList<Socket> clientSockets) {
        this.clientSockets = clientSockets;
    }

    public void run() {
        Socket clientSocket = clientSockets.getLast();
        try {
            name = clientSocket.readLine();

            for(Socket socket : clientSockets) {
                if(socket != clientSocket) {
                    socket.write(name + " ist dem Chatraum beigetreten \n");
                }
                else  {
                    socket.write("Server: Willkommen im Chatraum "+ name+"\n");
                }
            }


            String message = "";
            do {
                 message = clientSocket.readLine();
                System.out.println( name + " sagt: " + message);

                for(Socket socket : clientSockets) {
                    if(socket != clientSocket) {
                        socket.write(name+ " sagt: " + message + "\n");
                    }
                }

            } while (!end(message));

            clientSockets.remove(clientSocket);

        } catch (IOException e) {
            System.err.println("Fehler der Kommunikation mit " + name + "\n");
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
