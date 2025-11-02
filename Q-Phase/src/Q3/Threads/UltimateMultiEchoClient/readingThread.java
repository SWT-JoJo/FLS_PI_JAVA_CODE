package Q3.Threads.UltimateMultiEchoClient;

import socketio.Socket;

import java.io.IOException;

public class readingThread extends Thread{
    private Socket clientSocket;
    public  readingThread(Socket clientSocket){
        this.clientSocket = clientSocket;
    }

    public void run(){
        while(true){
            try {
                System.out.println("\n");
                String message = clientSocket.readLine();
                System.out.println(message + "\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
