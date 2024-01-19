package Arrays.Part2;

import java.util.Scanner;

public class NotenRechner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] klausuren;
        int[] tests;

        String errorMessage = "ERROR: NO VALID INPUT";

        System.out.print("Geben sie an wie viele Klausuren sie geschrieben haben: ");
        int anzKlausuren = scan.nextInt();
        System.out.print("Geben sie an wie viele Tests/HÜs sie geschrieben haben: ");
        int anzTest = scan.nextInt();
        int insgesammt = anzKlausuren + anzTest;

        klausuren = new int[anzKlausuren];
        tests = new int[anzTest];

        //Noteneintragen lassen
        System.out.println("Geben sie ihnre Klausuren Noten ein: ");
        for(int i = 0; i < klausuren.length; i++){
            do {
                System.out.print("Klausur " + (i + 1) + ": ");
                klausuren[i] = scan.nextInt();
                if(klausuren[i] < 0 || klausuren[i] > 15){
                    System.out.println(errorMessage);
                }
            } while (klausuren[i] < 0 || klausuren[i] > 15);
        }

        for(int i = 0; i < tests.length; i++){
            do{
            System.out.print("Test " + (i +1) + ": ");
            tests[i] = scan.nextInt();
            if(tests[i] < 0 || tests[i] > 15){
                System.out.println(errorMessage);
            }
        } while (tests[i] < 0 || tests[i] > 15);
        }


        System.out.println("Note: " + calcNote(klausuren, tests));

    }

    public  static int durchschnitt(int[] noten){
        int insgesammt = 0;
        for(int i = 0; i < noten.length; i++){
            insgesammt += noten[i];
        }
        if(insgesammt > 0){
            int durchschnitt = (insgesammt / noten.length);
            return durchschnitt;
        }
        else {
            return  0;
        }

    }

    public static double calcNote(int[] klausuren, int[] tests){
        double note;
        if(klausuren.length > 0 && tests.length > 0) {
            note = (double) ((durchschnitt(klausuren) * 2) + durchschnitt(tests)) / 3;
            note = ((int) (note * 100)) / 100.0;
        } else if (klausuren.length < 0 && tests.length == 0) {
            note = (double) (durchschnitt(klausuren));
            note = ((int) (note * 100)) / 100.0;
        }
        else {
            note = (double) (durchschnitt(tests));
            note = ((int) (note * 100)) / 100.0;
        }
        return note;
    }
}
