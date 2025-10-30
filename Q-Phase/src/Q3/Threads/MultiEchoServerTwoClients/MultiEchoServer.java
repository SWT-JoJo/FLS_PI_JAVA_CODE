package Q3.Threads.MultiEchoServerTwoClients;

import socketio.ServerSocket;
import socketio.Socket;

public class MultiEchoServer {
    private int port;
    private ServerSocket serverSocket;
    private Socket clientSocket1;
    private Socket clientSocket2;

    public MultiEchoServer() throws Exception{
        port = 8080;
        serverSocket = new ServerSocket(port);

        System.out.println("System:\tServer gestartet! - Warten auf Verbindung von Client 1\n");
        clientSocket1 = serverSocket.accept();
        KommunikationsThread k1 = new KommunikationsThread(clientSocket1, 1);
        k1.start();
        System.out.println("System:\tVerbindung aufgebaut - Warten auf Nachrichten von Client 1\n");


        System.out.println("System:\tWarten auf Verbindung von Client 2\n");
        clientSocket2 = serverSocket.accept();
        KommunikationsThread k2 = new KommunikationsThread(clientSocket2, 2);
        k2.start();
        System.out.println("System:\tVerbindung aufgebaut - Warten auf Nachrichten von Client 2\n");

        while(k1.isAlive() || k2.isAlive());

        end();
    }

    public static void main(String[] args) throws Exception{
        new MultiEchoServer();
    }



    public void end() throws Exception{
        clientSocket1.close();
        clientSocket2.close();
        serverSocket.close();
        System.out.println("System:\tServer beendet");
    }
}