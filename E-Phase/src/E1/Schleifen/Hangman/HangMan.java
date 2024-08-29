package Schleifen.Hangman;

import java.util.Arrays;
import java.util.Scanner;

public class HangMan {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean letterguessed = false;
        int health = 10;
        char[] used_letters = new char[20];

        //Wordlist
        String[] wordlist = {
                "Programmieren", "Java", "Hangman", "Computer", "Entwicklung", "OpenaAI", "Algorithmus", "KuenstlicheIntelligenz",
                "Schwimmbad", "Spieler", "Gitarre", "Fenster", "Bibliothek", "Wissenschaft", "Kommunikation", "Rechner",
                "Buchstabe", "Quellcode", "Software", "Internet", "Plattform", "Framework", "Projekt", "Schule", "Universität",
                "Elektronik", "Information", "Datenbank", "Anwendung", "Mathematik", "Informatik", "Struktur", "Benutzer",
                "Schnittstelle", "Analyse", "Dokumentation", "Optimierung", "Funktion", "Technologie", "Programmiersprache",
                "Maschinenlernen", "Verschlüsselung", "Algorithmische", "Entwicklungsumgebung", "Feuerwehr", "Hardware",
                "Mobiltelefon", "Kamera", "Simulation", "Robotik", "Datenanalyse", "Cloud", "Cybersicherheit", "Schleifen",
                "Besen", "Deutschebahn", "hyperkomplexitaet", "AMD", "Apple", "IPhone", "Kartoffel" , "China" , "Deutschland",
                "Overheadprojektor", "Flasche", "Tisch", "Mensa", "Spinne", "HLF", "TLF", "Drehleiter", "Weihnachten", "Tannenbaum", "Steam", "Erde", "England",
                "Amerika", "Russland", "Ukraine", "HangMan", "Handy" ,"Kartoffel" , "Karotte", "THW", "UHR", "Monitor", "Fabrik",
                "Chemie", "Technischekommunikation", "Schrank", "Moebel", "Karotte", "Informatik", "Muelleimer", "Berliner", "Broetchen",
                "Stadion", "Basketball", "Fussball", "Regal", "Waffel", "Waffeleisen", "Toaster", "Rucksack", "Parlament", "Tomaten",
                "Kirche", "Friedhof", "Sonnensystem", "Schiff", "Tastatur", "Schießstand"
        };

        //Wordgen
        int wordChose = (int) (Math.random() * wordlist.length);
        char[] wordtoguess = (wordlist[wordChose]).toCharArray();
        char[] displayedword = new char[wordtoguess.length];
        int versuch = 0;

        //Convert word to String
        String word = new String(wordtoguess);

        //Hiding the Word on Display
        Arrays.fill(displayedword, '_');

        for(int l = 0; l < used_letters.length; l++){
            used_letters[l] = ' ';
        }

        String endMessage = "You Lost, the word was: " + word; //Message that is displayed at the end of game


        //System.out.println("IMPORTANT: Ä = ae, ö = oe, ü = ue, Space betweenWords = '-' ");
        //Gameloop
        while (health > 0){

            //Printing out the word
            for(int i = 0; i < wordtoguess.length; i++){
                System.out.print(displayedword[i]);
            }
            //rest-live output
            System.out.println(" ");
            System.out.println("Leben verbleibend: " + health);

            //Printing out the used letters
            System.out.println("Verwendet: ");
            for(int x = 0; x < used_letters.length; x++){
                System.out.print(used_letters[x]);
                System.out.print(" ");
            }

            //Requesting the Userinput
            System.out.println(" ");
            System.out.print("Geben die ihren Bustaben ein: ");
            String input = scan.next();

            //Checking if the Input is only one Letter
            if(input.length() == 1){
                char inputLetter = input.charAt(0);
                //Checking if the letter is in the word by checking step by step every charcter if it is equal to the input
                for(int b = 0; b < wordtoguess.length; b++){
                    if(wordtoguess[b] == Character.toLowerCase(inputLetter)  || wordtoguess[b] == Character.toUpperCase(inputLetter) ){
                        displayedword[b] = wordtoguess[b];
                        letterguessed = true;
                    }
                }
                //Output a Message to the user to say that his input is right or wrong
                if(letterguessed){
                    System.out.println("Nice Guess, this is right");
                }
                else {
                    System.out.println( "\nNice try this letter is wrong");
                    health --; // Letter is wrong reduce the health by one
                }

            } else {
                if(input.equalsIgnoreCase(word)){
                    endMessage = "YOU WON WHOOHOOO :) \n Word:" + word+ "\n Versuche gebraucht: " + versuch;
                    break;
                }
                else{
                    System.out.println("THIS IS WRONG, yor live will be reduced by 2");
                    health = (health - 2);
                }

            }

            //checking if the word is guessed
            if(Arrays.equals(displayedword, wordtoguess)){
                endMessage = "YOU WON WHOOHOOO :)  \n Word:" + word + "\n Versuche gebraucht: " + versuch;
                break;

            }
            letterguessed = false; //reset of the letterguessed variable
            used_letters[versuch] = input.charAt(0);
            versuch++;
        }

        System.out.println(endMessage); //Message output, WHOOOOHOOOOO

        System.out.println("Play again? Yes (Y) No(N)");
        char selection = scan.next().charAt(0);

        if(selection == 'y' || selection == 'Y'){
            System.out.println("Game Restarting... \n\n\n\n\n");
            main(args);
        }
        else{
            System.out.println("Exiting Game");
            System.exit(0);
        }

        }
    }


