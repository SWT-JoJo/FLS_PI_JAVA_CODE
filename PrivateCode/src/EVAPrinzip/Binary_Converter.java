package EVAPrinzip;

import java.util.Scanner;

public class Binary_Converter {
    String binaryInput;
    int dezimal;

    public static void main(String[] args) {
        Binary_Converter binconv = new Binary_Converter();
        binconv.input();
        binconv.processing();
        binconv.output();
    }

    void input() {
        Scanner scan = new Scanner(System.in);
        System.out.println("*******************************************************************");
        System.out.println("                    Binary -> Dezimal Converter                    ");
        System.out.println("*******************************************************************");
        System.out.println();

        System.out.print("Enter your Binary-number: ");
        binaryInput = scan.next();
    }

    void processing() {
        char[] binaryBuffer = binaryInput.toCharArray();
        char[] binaryInputArray = new char[binaryBuffer.length];
        int counter = 0;
        for(int i = binaryBuffer.length ; i > 0; i--){
            binaryInputArray[counter] = binaryBuffer[i -1];
            counter++;
        }

        for (int i = 0; i < binaryInputArray.length; i++) {
            if (binaryInputArray[i] == '1') {
               // System.out.println("1"); //testing
                dezimal = (int) (dezimal + Math.pow(2, i));
            }

        }
    }
    void output(){
        System.out.println(binaryInput + " is " + dezimal + " as dezimal number");
    }
}

