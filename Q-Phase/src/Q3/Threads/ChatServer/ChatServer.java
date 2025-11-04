package Q3.Threads.ChatServer;

import socketio.ServerSocket;
import socketio.Socket;

import java.util.ArrayList;

public class ChatServer {
    private int port;
    private ServerSocket serverSocket;
    private ArrayList<Socket> meineClients;
    private ArrayList<Thread> meineThreads;

    public ChatServer() throws Exception{
        meineClients = new ArrayList();
        meineThreads = new ArrayList();
        port = 8080;
        serverSocket = new ServerSocket(port);

        while(true){
            System.out.println("Warten auf verbindung von neuem Client");
            Socket socket = serverSocket.accept();
            meineClients.add(socket);
            System.out.println("Verbindung zum Client aufgebaut ");
            meineThreads.add(new ChatKommunikationsThread(meineClients));
            meineThreads.getLast().start();
            System.out.println("Kommunikation gestartet");

            System.out.println("\n");
        }
    }

    public static void main(String[] args) throws Exception{
        new ChatServer();
    }



    public void end() throws Exception{
        serverSocket.close();
        System.out.println("System:\tServer beendet");
    }
}