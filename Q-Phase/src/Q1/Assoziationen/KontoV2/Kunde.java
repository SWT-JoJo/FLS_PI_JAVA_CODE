package Q1.Assoziationen.KontoV2;

import java.util.Scanner;

public class Kunde {
    private final String name;
    private final int kundenNr;
    private final Konto[] meineKonten;
    private int kontocounter = 0;


    public Kunde(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Kundennamen eingeben:\t");
        this.name = scan.nextLine();
        System.out.print("Kundennummer eingeben:\t");
        this.kundenNr = scan.nextInt();
        this.meineKonten = new Konto[3];

        System.out.println("\nIhre Daten werden verarbeitet...\n\n\n");

        kundenDatenAusgeben();
        menu();
    }

    public void menu(){
        Scanner scan = new Scanner(System.in);
        boolean validSelection = false;
        int auswahl = 0;

        while (!validSelection) {
            System.out.println("Auswahlmenue");
            System.out.println("------------");
            System.out.println("Neues Konto eroeffnen   ---> 1");
            System.out.println("Kontouebersicht         ---> 2");
            System.out.println("Programm Beenden        ---> 0");
            System.out.print("Auswahl: ");
            auswahl = scan.nextInt();

            if(auswahl < 0 || auswahl > 2){
                System.out.println("Ungültige auswahl bitte erneut versuchen");
            }
            else{
                validSelection = true;
            }
        }

        System.out.println("\n"); //Nur Design

        switch (auswahl){
            case 1:
                kontoAnlegen();
                break;
            case 2:
                kontoDatenAusgeben();
                break;
            default:
                System.exit(0);
                break;
        }

        menu();

    }

    public void kontoAnlegen() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Konto Anlegen");
        System.out.println("-------------");

        if (kontocounter <= meineKonten.length - 1){
            System.out.print("Eingabe Kontotyp:\t\t");
            String kontotyp = scan.next();
            System.out.print("Eingabe Kontonummer:\t");
            int kontonummer = scan.nextInt();

            meineKonten[kontocounter] = new Konto(kontotyp, kontonummer);
            kontocounter++;

         System.out.println("Konto wurde erfolgreich angelegt, sie haben nun " + kontocounter + "/" + meineKonten.length + " Konten");
        }
        else {
            System.out.println("Sie haben berreits die maximale Anzahl an Konten erreicht");
        }

        System.out.println("\n");

    }

    public void kontoDatenAusgeben(){
        System.out.println("Kontouebersicht");
        System.out.println("---------------");
        System.out.println(name + " (Kundennummer: "+ kundenNr+") hat folgende Konten");
        for (int i = 0; i < kontocounter; i++){
            System.out.println((i +1) +". Konto:\t" + meineKonten[i].getKontotyp() + " " + meineKonten[i].getKontoNr());
        }

        System.out.println("\n");

    }



    public void kundenDatenAusgeben(){
        System.out.println("Name: " + name);
        System.out.println("Kundennummer: " + kundenNr);
        System.out.println("\n\n");
    }


}
