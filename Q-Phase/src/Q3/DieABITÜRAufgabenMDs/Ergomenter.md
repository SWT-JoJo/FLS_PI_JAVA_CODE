`````java
import serialio.Serial;

import java.util.Scanner;

public class Ergometer {

    private final static String CMD_CHANGEMODE;
    private final static String CMD_Reset;
    private final static String CMD_GET_STATUS;
    private final static String CMD_SET_POWER;
    private final static String ACK;
    private final static String ERROR;
    private Serial port;


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Geben sie den serialPort ein (COM1): ");
        String serialPort = scan.next().toUpperCase();

        Ergometer em = new Ergometer(serialPort);


    }


    public Ergometer(String serialPort) {
        port = new Serial(serialPort, 9600, 8, 1, 0);
    }

    public boolean open() {

    }

    public boolean reset() {
        
    }

    public boolean setPower(int destPower) {

    }

    public String readStatus() {
        return null;
    }

    public void close() {


    }


}









`````