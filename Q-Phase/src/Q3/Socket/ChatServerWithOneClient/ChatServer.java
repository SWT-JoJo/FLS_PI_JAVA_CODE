package Q3.Socket.ChatServerWithOneClient;


import socketio.ServerSocket;
import socketio.Socket;


import java.util.Scanner;

//THIS GUI IS POWERD BY CHATGPT
public class ChatServer {
    private int port;
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private int clientNr;

    public ChatServer() throws Exception{
        port = 8080;
        serverSocket = new ServerSocket(port);

        System.out.println("System:\tServer gestartet! - Warten auf Verbindung\n");
        clientSocket = serverSocket.accept();

        System.out.println("System:\tVerbindung aufgebaut - Warten auf Nachrichten\n");
        clientNr = 1;


        communicate();
        end();
    }

    public static void main(String[] args) throws Exception{
        new ChatServer();
    }

    public void communicate() throws Exception{
        Scanner scan = new  Scanner(System.in);
        String endSymbol = "over";

        while (true) {
            println("System:\tWarten auf Nachricht von Client " + clientNr);
            println("");
            String temp = clientSocket.readLine();

            println("Client Sagt: " + temp);

            if(temp.contains(endSymbol)){
                break;
            }

            print("Eingabe: ");
            String message = scan.nextLine();
            clientSocket.write(message+"\n");

            if(message.contains(endSymbol)){
                break;
            }

            println("");
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
        System.out.println(s);
    }


}
