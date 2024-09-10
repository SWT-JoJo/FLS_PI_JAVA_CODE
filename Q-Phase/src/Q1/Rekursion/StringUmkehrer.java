package Q1.Rekursion;

import java.util.Scanner;

public class StringUmkehrer {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringUmkehrer su = new StringUmkehrer();

        System.out.print("Geben sie ihr Wort ein: ");
        String input = scan.nextLine();

        System.out.println();
        System.out.println("Iterativ: " + su.umkehrungString(input));
        System.out.println("Rekursiv: " + su.umkehrungString2(input));

    }
//Iterativ
    private String umkehrungString(String wort){
        String newWord = "";
        for(int i = wort.length(); i >0; i--){
            newWord += wort.substring(i-1,i);
        }
        return newWord;
    }
//Rekursiv
    private String umkehrungString2(String wort){
        String newWord = "";
        if(wort.isEmpty()){
            return newWord;
        }
        newWord = wort.substring(wort.length()-1);
        return newWord +=umkehrungString2(wort.substring(0, wort.length() - 1));
    }

}
