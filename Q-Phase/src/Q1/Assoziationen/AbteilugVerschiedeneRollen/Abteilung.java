package Q1.Assoziationen.AbteilugVerschiedeneRollen;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Abteilung {
    public String abteilungsName;
    public Personal abteilungsleiter;
    private final Personal[] personal;
    private int personalCounter = 0;


    public Abteilung(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Geben sie den Abteilungsnamen ein: ");
        this.abteilungsName = scan.nextLine();
        //System.out.print("Wie viele Mitarbeiter darf diese Abteilung maximal beherbergen: ");
        //int maxAnzPersonal = scan.nextInt();

        System.out.println("\nAbteillungsleiter Anlegen");
        System.out.print("Geben sie den Namen ein: ");
        String tempName = scan.nextLine();
        System.out.print("Geben sie das alter ein: ");
        int tempAlter = scan.nextInt();

        abteilungsleiter = new Personal(tempName, tempAlter);

        personal = new Personal[10];

        mitarbeiterAnlegen();
    }

    public void mitarbeiterAnlegen(){
        Scanner scan = new Scanner(System.in);
        System.out.println();

        System.out.println("Mitarbeiter Anlegen");
        System.out.println("-------------------");

        boolean anlegen = true;
        do {
            System.out.print("Geben sie den Namen ein: ");
            String name = scan.nextLine();
            System.out.print("Geben sie das Alter ein: ");
            int alter = scan.nextInt();
            personal[personalCounter] = new Personal(name, alter);
            personalCounter++;

            System.out.print("\n Mitarbeiter erfolgreich angelegt \n\n Wollen sie einen weiteren anlegen (J/N)");
            char auswahl = scan.next().toUpperCase().charAt(0);
            scan.nextLine();
            System.out.println();

            if(auswahl == 'N' ||personalCounter >= personal.length){
                anlegen = false;
            }
        }while (anlegen);
        abteilungausgeben();

    }

    public void abteilungausgeben(){

        System.out.println("\n");
        System.out.println("Die Abteilung " + abteilungsName + " wird geleitet von ");
        System.out.println(abteilungsleiter.getName() +" (" + abteilungsleiter.getAlter()+")");
        System.out.println("Die " + personalCounter + " sind :");
        for (int i = 0; i < personalCounter; i++){
            System.out.println("- " + personal[i].getName() +" (" + personal[i].getAlter()+")");
        }
    }
}
