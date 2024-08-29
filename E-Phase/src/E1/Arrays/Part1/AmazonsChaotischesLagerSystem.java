package E1.Arrays.Part1;

import java.util.Scanner;

public class AmazonsChaotischesLagerSystem {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //erste zahl die zeilen dann die spalten
        String[][] regal = new String[3][4];
        regal[0][0] = "Laptop";
        regal[0][1] = "Drucker";
        regal[0][2] = "Desktop PC";
        regal[0][3] = "Tablet";
        regal[1][0] = "Mp3 Player";
        regal[1][1] = "IPhone";
        regal[1][2] = "Handy";
        regal[1][3] = " ";
        regal[2][0] = "TV";
        regal[2][1] = "Router";
        regal[2][2] = " ";
        regal[2][3] = " ";

        System.out.print("In welcher Zeile ist ihr Produkt: ");
        int row = scan.nextInt() - 1;
        System.out.print("In welcher Spalte ist ihr Produkt: ");
        int column = scan.nextInt() - 1;

        if(regal[row][column].equalsIgnoreCase(" ")){
            System.out.println("Dieses Produkt ist leider ausverkauft :( \n" +
                    "Bis zun nächsten mal");
        }
        else{
            System.out.println("Ihr Produkt: " + regal[row][column] + "viel spaß damit  und bis zum nächsten mal :)");
        }

    }
}