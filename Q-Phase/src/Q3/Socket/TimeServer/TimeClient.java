package Q3.Socket.TimeServer;

import socketio.*;

import java.io.IOException;

public class TimeClient {
    private String host;
    private int port;
    private Socket clientSocket;

    public TimeClient() throws Exception {
        host = "127.0.0.1";
        port = 8080;

        connect();

        for(int i = 0; i < 10; i++){
            System.out.print(i + 1 + ".\t");
            communicate();
        }

        end();

    }

    public static void main(String[] args) throws Exception{
        new TimeClient();
    }

    public void communicate() throws IOException {
            clientSocket.write(" \n");
            String temp = clientSocket.readLine();
            System.out.println(temp + "\n");

    }

    public void end() throws Exception{
        clientSocket.write("End\n");
        System.out.println("System:\tClient wurde beim Server abgemeldet\n");

        clientSocket.close();

        System.out.println("System:\tVerbindung getrennt\n");
    }

    public void connect() throws IOException{
        clientSocket = new Socket(host,port);
        System.out.println("System:\tClient gestartet und stellt verbindug mit dem Server her\n");

        clientSocket.connect();
        System.out.println("System:\tVerbindung aufgebaut - Wurden vom Server akzeptiert\n");
    }


}
