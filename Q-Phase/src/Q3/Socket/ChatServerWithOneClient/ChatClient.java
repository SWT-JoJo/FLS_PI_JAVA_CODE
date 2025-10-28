package Q3.Socket.ChatServerWithOneClient;

import socketio.Socket;

import java.util.Scanner;


//THIS GUI IS POWERD BY CHATGPT
public class ChatClient {

    private String host;
    private int port;
    private Socket clientSocket;

    public static void main(String[] args) throws Exception {
        new ChatClient();
    }

    public ChatClient() throws Exception {
        host = "10.5.248.212";
        port = 7777;

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
        String temp = "";
        do{
            System.out.print("Eingabe: ");
            input = scan.nextLine();


            clientSocket.write(input + "\n");

            print("\n");

            if(end(input)){
                break;
            }

            println("System:\tWarten auf Antwort vom Server");
            println("");
            temp = clientSocket.readLine();
            println("Server Antwort:\t" + temp);


            print("\n");
        }while (!end(temp));

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
