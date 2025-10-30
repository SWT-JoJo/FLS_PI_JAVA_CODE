package Q3.Threads.MultiEchoServerTwoClients;

import socketio.Socket;

import java.util.Scanner;

public class EchoClient {

    private String host;
    private int port;
    private Socket clientSocket;

    public static void main(String[] args) throws Exception {
        new EchoClient();
    }

    public EchoClient() throws Exception {
        host = "localhost";

        port = 8080;

        System.out.println("System:\tClient gestartet!\n");
        connect();
        communicate();

        clientSocket.close();
        System.out.println("System:\tClient beendet!\n");
    }

    private void connect() throws Exception {
        clientSocket = new Socket(host, port);
        clientSocket.connect();
        System.out.println("System:\tVerbindung aufgebaut\n");
        System.out.println(clientSocket.readLine() + "\n");
    }

    private void communicate() throws Exception {
        Scanner scan = new Scanner(System.in);
        String input;
        do{
            System.out.print("Eingabe: ");
            input = scan.nextLine();
            clientSocket.write(input + "\n");

            String temp = clientSocket.readLine();
            System.out.println("Server Antwort:\t" + temp);


            System.out.print("\n");
        }while (!end(input));

    }

    private boolean end(String input) throws Exception {

        if(input.contains("over")){
            return true;
        }

        return false;
    }

}
