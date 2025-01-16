package Q1.BinaereSuche;

import java.util.Scanner;

public class charSearch {
    private final char[] buchstaben = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    };
    String[] haustiere = {
            "Ameise", "Axolotl", "Bartagame", "Chinchilla", "Degu",
            "Eidechse", "Frettchen", "Garnelen", "Gecko", "Goldfisch",
            "Hamster", "Hase", "Hermelin", "Hund", "Igel",
            "Katze", "Kaninchen", "Koi", "Koralle", "Leguan",
            "Landschildkröte", "Meerschweinchen", "Mäuse", "Papagei", "Pferd",
            "Ratte", "Regenbogenfisch", "Schildkröte", "Schlange", "Skorpion",
            "Spinne", "Steppenlemming", "Stabheuschrecke", "Streifenhörnchen", "Tarantel",
            "Wellensittich", "Wüstenspringmaus", "Zebrafinch", "Ziege", "Zwerggecko"
    };

    private  int durchlauf = 0;

    public static void main(String[] args) {
        charSearch cs = new charSearch();
        cs.eingabe();
    }

    public void eingabe(){
        Scanner scan = new Scanner(System.in);

        System.out.println("**********************");
        System.out.println("*    Binäre-Suche    *");
        System.out.println("**********************\n");

        System.out.println("Geben sie an, ob sie einen Buchstaben oder ein Haustier suchen \n 1: Haustier \n 2: Buchstabe");
        System.out.print("Ihre wahl: ");
        int temp = scan.nextInt();

        System.out.print("Geben sie den Buchstaben/das Wort an, den sie suchen wollen: ");

        if(temp == 1) {
            String haustier = scan.next().toUpperCase();

            System.out.println("\n");
            System.out.println("----| Protokol-Suche |----");

            ausgabe(wortSuche(haustier));
        } else {
            char buchstabe = scan.next().toUpperCase().charAt(0);

            System.out.println("\n");
            System.out.println("----| Protokol-Suche |----");
            ausgabe(Buchstabensuche(buchstabe));
        }

    }

    public int Buchstabensuche(char zeichen){
        boolean found = false;
        int foundIndex = -99;
        durchlauf = 0;
        //Startwerte
        int min = 0;
        int max = buchstaben.length - 1;
        int mid;
        do{
            durchlauf ++;
            mid = (max + min) / 2;

            //Protokol ausgabe
            System.out.println(durchlauf + ". Erste Position: " + min + " Letzte Position: " + max + " ---> Mitte: " + mid);

            if(buchstaben[mid] == zeichen){
               foundIndex = mid;
               found = true;
            } else if (buchstaben[mid] < zeichen) { //wenn mid kleiner a
                min = mid + 1;
            }
            else {
                max = mid - 1;
            }

            //
            if(( (max + min) /2) == buchstaben.length -1 ){
                foundIndex = -99;
                break;
            }
        } while (!found);



        return foundIndex;
    }

    public int wortSuche(String haustier){
        boolean found = false;
        int foundIndex = -99;
        durchlauf = 0;
        //Startwerte
        int min = 0;
        int max = haustiere.length - 1;
        int mid;
        do{
            durchlauf ++;
            mid = (max + min) / 2;

            //Protokol ausgabe
            System.out.println(durchlauf + ". Erste Position: " + min + " Letzte Position: " + max + " ---> Mitte: " + mid);

            if(haustier.compareTo(haustiere[mid]) == 0){
                foundIndex = mid;
                found = true;
            } else if (haustier.compareTo(haustiere[mid]) < 0) { //wenn mid kleiner a
                min = mid + 1;
            }
            else {
                max = mid - 1;
            }

            //
            if(( (max + min) /2) == haustiere.length -1 ){
                foundIndex = -99;
                break;
            }
        } while (!found);


        return foundIndex;
    }

    public void ausgabe(int gefundenePosition){
        System.out.println("\n");
        System.out.println("----| Suchergebnis |----");
        System.out.println("Der Buchstaben/Das Wort befindet sich an Position " + (gefundenePosition +1) +" (Index: " + gefundenePosition + ") im Array");
        System.out.println("Durchläufe: " + durchlauf);
    }
}

