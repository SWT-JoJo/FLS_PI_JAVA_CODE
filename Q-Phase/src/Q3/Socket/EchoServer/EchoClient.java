package Q3.Socket.EchoServer;

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
        host = "127.0.0.1";
        port = 8080;

        println("System:\tClient gestartet!\n");
        connect();
        communicate();

        clientSocket.close();
        println("System:\tClient beendet!\n");
    }

    private void connect() throws Exception {
        clientSocket = new Socket(host, port);
        clientSocket.connect();
        println("System:\tVerbindung aufgebaut\n");
    }

    private void communicate() throws Exception {
        Scanner scan = new Scanner(System.in);
        String input = "";
        do{
            print("Eingabe: ");
            input = scan.nextLine();
            clientSocket.write(input + "\n");

            String temp = clientSocket.readLine();
            println("Server Antwort:\t" + temp);


            print("\n");
        }while (!end(input));

    }

    private boolean end(String input) throws Exception {

        if(input.contains("over")){
            return true;
        }

        return false;
    }


    public void print(String s){
        System.out.print(s);
    }

    public void println(String s){
        System.out.println(s);
    }
}
