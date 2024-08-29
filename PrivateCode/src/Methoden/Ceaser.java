package Methoden;

public class Ceaser {
    public static void main(String[] args) {
        Ceaser c = new Ceaser();
        c.verschluesseln("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
    }

    public void verschluesseln(String inputword){
        char[] word = inputword.toCharArray();
        char[] newWord = new char[word.length];
        int temp = 0;

        for(int i = 0; i < word.length; i++) {
            temp = word[i];

            for (int j = 0; j < 3; j++) {
                if (temp == 90) {
                    temp = 65;
                } else {
                    temp++;
                }
            }

            newWord[i] = (char) temp;
        }
        for (int i = 0; i < newWord.length; i++){
            System.out.print(word[i] + "-");

        }
        System.out.println();
        for (int i = 0; i < newWord.length; i++){
            System.out.print(newWord[i] + "-");

        }


        }
    }

