package Q3.Socket.TimeServer;

//Imports
import socketio.*;

import java.util.Calendar;


public class TimeServer {
    private int port;
    private ServerSocket serverSocket;
    private Socket clientSocket;

    public TimeServer() throws Exception{
        port = 8080;
        serverSocket = new ServerSocket(port);

        System.out.println("System:\tServer gestartet! - Warten auf Verbindung\n");
        clientSocket = serverSocket.accept();

        System.out.println("System:\tVerbindung erfolgreich hergestellt!\n");
        System.out.println("System:\tDie Uhrzeit wird gesendet");

        while (!end()){
            communicate();
        }
        clientSocket.close();
        serverSocket.close();

        System.out.println("System:\tServer beendet");

    }


    public static void main(String[] args) throws Exception {
        new TimeServer();
    }


    public void communicate() throws Exception {

            clientSocket.write(Calendar.getInstance().getTime() + "\n");
            Thread.sleep(1000);                                         //Wait 1sec

    }

    public boolean end() throws Exception{
        String temp = clientSocket.readLine();
        return temp.equals("End");
    }

}
