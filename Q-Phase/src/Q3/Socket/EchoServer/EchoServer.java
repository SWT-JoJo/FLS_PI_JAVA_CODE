package Q3.Socket.EchoServer;

import socketio.ServerSocket;
import socketio.Socket;

public class EchoServer {
    private int port;
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private int clientNr;

    public EchoServer() throws Exception{
        port = 8080;
        serverSocket = new ServerSocket(port);

        System.out.println("System:\tServer gestartet! - Warten auf Verbindung\n");
        clientSocket = serverSocket.accept();

        System.out.println("System:\tVerbindung aufgebaut - Warten auf Nachrichten\n");
        clientNr = 1;

        println("System:\t Warten auf Nachricht von Client " + clientNr);

        communicate();
        end();
    }

    public static void main(String[] args) throws Exception{
        new EchoServer();
    }

    public void communicate() throws Exception{

        String endSymbol = "over";

        while (true) {
            String temp = clientSocket.readLine();
            println("Client Sagt: " + temp);
            clientSocket.write(temp + "\n");

            if(temp.contains(endSymbol)){
                break;
            }
        }

    }

    public void end() throws Exception{
        clientSocket.close();
        serverSocket.close();
        println("System:\tServer beendet");
    }

    public void print(String s){
        System.out.println(s);
    }

    public void println(String s){
        System.out.println(s + "\n");
    }

}
