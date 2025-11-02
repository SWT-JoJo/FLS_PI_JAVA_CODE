package Q3.Threads.UltimateMultiEchoClient;

import socketio.Socket;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.util.ArrayList;

public class KommunikationsThread extends Thread {
    private int clientNumber;
    private ArrayList<Socket> sockets;

    public KommunikationsThread(int clientNumber, ArrayList<Socket> sockets) {
        this.clientNumber = (clientNumber);
        this.sockets = sockets;
    }

    public void run() {
        try {
            sockets.get(clientNumber).write((clientNumber+1) + "\n");
            String temp= "";
            do {
               temp = sockets.get(clientNumber).readLine();
               sockets.get(clientNumber).write(temp + "\n");

                for (Socket socket : sockets) {
                    if (socket != sockets.get(clientNumber)) {
                        socket.write("Nachricht von den anderen Clients " + temp + "\n");
                    }
                }

            }while (end(temp));

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

    public void setSockets(ArrayList<Socket> sockets) {
        this.sockets = sockets;
    }
}
