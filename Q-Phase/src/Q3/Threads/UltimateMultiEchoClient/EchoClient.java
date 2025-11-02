package Q3.Threads.UltimateMultiEchoClient;

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
        System.out.println("System:\tClient gestartet!\n");
        connect();
        communicate();

        readingThread.interrupted();
        clientSocket.close();
        System.out.println("System:\tClient beendet!\n");
    }

    private void connect() throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.print("Server-IP: ");
        host = scan.next();
        System.out.print("Port: ");
        port = scan.nextInt();

        clientSocket = new Socket(host, port);
        clientSocket.connect();
        System.out.println("System:\tVerbindung aufgebaut\n");

        int clientNumber = Integer.parseInt(clientSocket.readLine());
        System.out.println("Zugeteilte Clientnummer: " + clientNumber + "\n\n");

        readingThread thread = new  readingThread(clientSocket);
        thread.start();
        System.out.println("System:\t Thread gestartet!\n");
    }

    private void communicate() throws Exception {
        Scanner scan = new Scanner(System.in);
        String input;
        do{
            System.out.print("Eingabe: ");
            input = scan.nextLine();
            clientSocket.write(input + "\n");
        }while (!end(input));

    }

    private boolean end(String input) throws Exception {

        if(input.contains("over")){
            return true;
        }

        return false;
    }

}
