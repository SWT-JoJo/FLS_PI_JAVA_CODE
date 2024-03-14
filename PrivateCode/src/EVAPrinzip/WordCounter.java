package EVAPrinzip;

import java.util.Scanner;

public class WordCounter {
    int wordcount;
    int letterCount;
    int spaceCount;
    String inputText;
    public static void main(String[] args) {
    WordCounter wc = new WordCounter();
    wc.input();
    wc.processing();
    wc.output();
    }

    void input(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your Text: ");
        inputText = scanner.nextLine();
    }

    void processing(){
        wordcount = inputText.split("\\s").length;
        spaceCount = wordcount -1;
        letterCount = (inputText.toCharArray().length) - spaceCount;
    }

    void output(){
        System.out.println("Your Text has: ");
        System.out.println("Words:  \t" + wordcount);
        System.out.println("Letters:\t" +letterCount);
        System.out.println("Spaces: \t" +spaceCount);
        System.out.println("Characters:\t" + (spaceCount + letterCount));
    }
}
