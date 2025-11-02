package Q3.Threads.UltimateMultiEchoClient;

import socketio.ServerSocket;
import socketio.Socket;

import java.util.ArrayList;

public class MultiEchoServerV3 {
    private int port;
    private ServerSocket serverSocket;
    private ArrayList<Socket> meineClients;
    private ArrayList<Thread> meineThreads;

    public MultiEchoServerV3() throws Exception{
        port = 8080;
        serverSocket = new ServerSocket(port);
        meineClients = new ArrayList<>();
        meineThreads = new ArrayList<>();


        while(true){
            System.out.println("System:\tWarten auf Client " + (meineClients.size() + 1));
            meineClients.add(serverSocket.accept());
            System.out.println("System:\tClient verbunden - Client nummer: " + meineClients.size());
            //System.out.println("DEBUG: " + meineClients.size());
            meineThreads.add(new KommunikationsThread(meineClients.size()-1, meineClients));
            meineThreads.getLast().start();
            System.out.println("System: Kommunikation mit Client gestartet :) \n\n");
        }

    }

    public static void main(String[] args) throws Exception{
        new MultiEchoServerV3();
    }



    public void end() throws Exception{
        for (Socket cSocket : meineClients) {
            cSocket.close();
        }
        serverSocket.close();
        System.out.println("System:\tServer beendet");
    }
}