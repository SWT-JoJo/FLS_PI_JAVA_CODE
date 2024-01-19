package Adventure;

import java.util.Scanner;

public class Adventure {
    public static void main(String[] args) {
        // WICHTIGE VARIABLEN ERSTELLEN
        Scanner scan = new Scanner(System.in);


        //PlayerStats
        String name;
        int health = 10;
        int strenth = 5;
        int age;

        //Game setup/Start Menu

        System.out.println("Welcome Player to the Charackter Creator");
        System.out.print("Your Charackter nick-name: ");
        name = scan.next();
        System.out.println("How old you want you charakter to be: ");
        age = scan.nextInt();

        System.out.println("The setup is now completed! ");

        //Game
        System.out.println("You are walking trough the desert, its hot and you water is empty. You look on your map and see that there should be a village next to you but you " +
        "aren't sure if your position is right");
        System.out.println("Do you trust your Map and go to this village or you you continue to walk strait? ");
        System.out.println("1: Village?? 2: continue walking strait: ");
        int choice = scan.nextInt();

        switch (choice) {
            case 1:
                
                break;
            case 2:

            break;
            default:
                System.out.println("No valid Choice, you are standing still and die. GAME OVER ");
                break;
        }
        

    }

}