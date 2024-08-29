package E1.Arrays.Part1;

import java.util.Scanner;

public class AmazonKannImmerNochKeineLagerSystemeEntwickeln {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //erste zahl die zeilen dann die spalten
        String[][][] regal = new String[2][3][4];
        regal[0][0][0] = "Laptop";
        regal[0][0][1] = "Drucker";
        regal[0][0][2] = "Desktop PC";
        regal[0][0][3] = "Tablet";
        regal[0][1][0] = "Mp3 Player";
        regal[0][1][1] = "IPhone";
        regal[0][1][2] = "Handy";
        regal[0][1][3] = "Java für Dummies Buch";
        regal[0][2][0] = "TV";
        regal[0][2][1] = "Router";
        regal[0][2][2] = "Monopoly";
        regal[0][2][3] = "StarWars 1";

        regal[1][0][0] = "Samsung Galaxy S23";
        regal[1][0][1] = "Modell Zug";
        regal[1][0][2] = "Monitor";
        regal[1][0][3] = "Klopapier";
        regal[1][1][0] = "Schweden Flagge";
        regal[1][1][1] = "Modellflugzeug";
        regal[1][1][2] = "Apple Pencil";
        regal[1][1][3] = "Trinkflasche";
        regal[1][2][0] = "Regenjacke";
        regal[1][2][1] = "Star Wars Monopoly";
        regal[1][2][2] = "Mensch ärger dich nicht";
        regal[1][2][3] = "StarWars 1-6";


        // Ausgabe des Lagerinhaltes
        System.out.println("Der Lagerinhalt: ");
        for(int i = 0; i < regal.length; i++){
            for(int j = 0; j < regal[i].length; j++){
                for(int l = 0; l < regal[i][j].length; l++) {
                    System.out.println("Produkt: " + regal[i][j][l]);
                }
                System.out.println("____________________________________________________");
            }
        }


        System.out.print("Welches Produkt suchen sie: ");
        String inputProduct = scan.nextLine();

        boolean productfound = false;

        //Produktsuche
        for(int i = 0; i < regal.length; i++){
            for(int j = 0; j < regal[0].length; j++){
                for(int l = 0; l < regal[0][0].length; l++){
                    if(inputProduct.equalsIgnoreCase(regal[i][j][l])){
                        productfound = true;
                        System.out.println("Das Produkt >>" + inputProduct + "<< befindet sich in Fach: [" + (i +1) + "|" + (j+1) + "|" + (l+1) +"]");
                        break;
                    }
                }
            }
        }

        if(!productfound){
            System.out.println("Tut uns leid aber ihr gesuchtet Produkt ist momentan nicht mehr auf Lager :)");
        }
    }
}