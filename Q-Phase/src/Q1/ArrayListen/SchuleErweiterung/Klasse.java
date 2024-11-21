package Q1.ArrayListen.SchuleErweiterung;

import java.util.ArrayList;
import java.util.Scanner;

public class Klasse {
    private String name;
    private ArrayList<Schueler> meineSchueler = new ArrayList<>();



    private Lehrer meinLehrer;

    public void setMeineSchueler(ArrayList<Schueler> meineSchueler) {
        this.meineSchueler = meineSchueler;
    }

    public Klasse(String name){
        this.name = name;
    }
    public void Schuelerausgabe(){
        int counter = 1; //format
        for(Schueler tempSchueler: meineSchueler){
            System.out.println(counter + ". " + tempSchueler.getName() + " (Schuelernummer: " + tempSchueler.getSchuelerNummer()+")");
            counter ++;
        }
    }

    public String AusgabeSchuelerMitKurs(){
        String returnString = "";
        for (Schueler tSchueler : meineSchueler){
            returnString += (meineSchueler.indexOf(tSchueler) + 1) + ". " + tSchueler.getName() + "\n";
            for (Kurs tKurs : tSchueler.getMeineKurse()){
                returnString += "\t" + (tSchueler.getMeineKurse().indexOf(tKurs) + 1) + ". " + tKurs.getBezeichnung() +" (Stunden: " + tKurs.getStunden()+")\n";
            }
            returnString +="\n";
        }
        return returnString;
    }
    public void neueSchueler(String name){
        Scanner scan = new Scanner(System.in);

        Schueler tempSchueler = new Schueler(name);

        /* System.out.print("Wie viele Kurse hat der Schüler: ");
        int addKurse = scan.nextInt();
        for (int k = 0; k < addKurse; k ++){
            System.out.print("Geben sie die Kursbezeichnung ein (GK/LK-Fach ): ");
            String tempKursName = scan.next();
            System.out.print("Geben sie die Stunden pro Woche an: ");
            int tempKursStd = scan.nextInt();
            tempSchueler.neuenKursHinzufuegen(tempKursName, tempKursStd);
        }
        */
        meineSchueler.add(tempSchueler);
        System.out.println("Schüler erfolgriech mit allen Kurse erstellt");


    }


    //Getter + Setter

    public Lehrer getMeinTutor() {
        return meinLehrer;
    }

    public void setMeinTutor(Lehrer meinLehrer) {
        this.meinLehrer = meinLehrer;
    }
    public void setName(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public ArrayList<Schueler> getMeineSchueler() {
        return meineSchueler;
    }
}
