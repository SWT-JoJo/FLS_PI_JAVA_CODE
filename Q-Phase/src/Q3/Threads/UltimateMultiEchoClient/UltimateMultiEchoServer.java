package Q3.Threads.UltimateMultiEchoClient;

import socketio.ServerSocket;
import socketio.Socket;

import java.util.ArrayList;

public class UltimateMultiEchoServer {
    private int port;
    private ServerSocket serverSocket;
    private ArrayList<Socket> meineClients;
    private ArrayList<Thread> meineThreads;

    public UltimateMultiEchoServer() throws Exception{
        meineClients = new ArrayList();
        meineThreads = new ArrayList();
        port = 8080;
        serverSocket = new ServerSocket(port);
        int clientNummer = 1;

        while(true){
            System.out.println("Warten auf verbindung von Client " + clientNummer);
            Socket socket = serverSocket.accept();
            meineClients.add(socket);
            System.out.println("Verbindung zum Client aufgebaut ");
            meineThreads.add(new UltimateKommunikationsThread(meineClients, clientNummer));
            meineThreads.getLast().start();
            System.out.println("Kommunikation gestartet");

            clientNummer++;
        }
    }

    public static void main(String[] args) throws Exception{
        new UltimateMultiEchoServer();
    }



    public void end() throws Exception{
        serverSocket.close();
        System.out.println("System:\tServer beendet");
    }
}