package EVA_Methoden;
import  java.util.Scanner;
public class PasswortGenerator {

    int pwLenght;
    String outputPassword = "";


    public static void main(String[] args) {
        PasswortGenerator pg = new PasswortGenerator();
        pg.title();
        pg.eingabe();
        pg.verarbeitung();
        pg.ausgabe();
    }

    void title() {
        System.out.println("*******************************************************************");
        System.out.println("*                        Passwort-Generator                       *");
        System.out.println("*******************************************************************");
        System.out.println();
    }

    void eingabe() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Wie lang soll ihr Passwort sein: ");
        pwLenght = scan.nextInt();
    }

    void verarbeitung() {
        String temppasswort="";
        int[] numberLogger = new int[pwLenght];
        int genNumber = 0;

        boolean allowLetter = false;
        for(int i = 0; i < pwLenght; i++) {
            while (!allowLetter) {

                genNumber = (int) (Math.random() * 122 + 1); //Bustabengenerierung weil ja

                if (genNumber > 47 && genNumber < 58 || genNumber > 64 && genNumber < 90 || genNumber > 97 && genNumber < 123) { //Überprüfung ob die generierte Zahl ein Bustabe ist
                    for(int x = 0; x < numberLogger.length; x++){ //check ob der Bustabe schon verwendet wurde
                        if (genNumber != numberLogger[x]) {
                            allowLetter = true;
                        }
                        else{
                            allowLetter = false;
                        }
                    }
                }

            }
            numberLogger[i] = genNumber;
            allowLetter = false;
            outputPassword += (char) genNumber;
        }
    }
        void ausgabe() {
            System.out.println("Ihr Passwort: ");
            System.out.println(outputPassword);
        }
}

//null