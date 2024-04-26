package Methoden;

import java.util.Scanner;

public class Parlindrom {
    public static void main(String[] args) {
        Parlindrom pl = new Parlindrom();

        Scanner scan = new Scanner(System.in);
        System.out.print("Geben sie das Wort ein: ");
        String wort = scan.next();

        System.out.println("Umgedrehtes Wort: " + pl.umdrehen(wort));
    }

    public  String umdrehen(String wort){
        StringBuilder temp = new StringBuilder();
        char[] splittedWord = wort.toCharArray();

        splittedWord[0] = Character.toLowerCase(splittedWord[0]); //erstenBustaben des Arrays klein machen, da er später der letzte ist
        splittedWord[splittedWord.length - 1] = Character.toUpperCase(splittedWord[splittedWord.length - 1]); //Letzten Bustaben des Arrays groß machen, da er später der Anfangsbustabe ist

        for(int i = splittedWord.length - 1; i >= 0; i--){
            temp.append(splittedWord[i]); //The same like temp += splittedWord[i]
        }

        return temp.toString();
    }
}
