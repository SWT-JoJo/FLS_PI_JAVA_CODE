package OOP.IrgendwasMitKunden;

public class Kunde {
    private String name;
    private String vorname;
    private int kdNr;
    private static int autowert = 1000;


    public Kunde(String name, String vorname){
        this.name  = name;
        this.vorname = vorname;
        this.kdNr = autowert++;
        //autowert ++;
    }


    public void ausgabe(){
        System.out.println("Ihre Daten:");
        System.out.println("Name:\t\t\t " + name);
        System.out.println("Vorname:\t\t " + vorname);
        System.out.println("Kundennummer:\t " + kdNr);
        System.out.println();
        System.out.println("---------------------------------");
    }
}
