package Q1.ArrayListen.SchuleErweiterung;

import java.util.ArrayList;

public class Schueler extends Personen{
    private static int schuelerStamm = 1000;
    private int schuelerNummer;
    private ArrayList<Kurs> meineKurse = new ArrayList<>();

    public Schueler(String name){
        this.name = name;
        this.schuelerNummer = schuelerStamm;
        schuelerStamm ++;
    }

    public void neuenKursHinzufuegen(String name, int stunden){
        meineKurse.add(new Kurs(name, stunden));
        System.out.println("Kurs erfolgreich Hinzugefuegt");
    }

    public void ausgabeKurse(){
        for(Kurs tempKurs : meineKurse){
            System.out.println(tempKurs.getBezeichnung() + " (" + tempKurs.getStunden()+" Stunden)");
        }
    }

    //Getter + Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Kurs> getMeineKurse() {
        return meineKurse;
    }

    public void setMeineKurse(ArrayList<Kurs> meineKurse) {
        this.meineKurse = meineKurse;
    }

    public int getSchuelerNummer() {
        return schuelerNummer;
    }

    public void setSchuelerNummer(int schuelerNummer) {
        this.schuelerNummer = schuelerNummer;
    }

    public static int getSchuelerStamm() {
        return schuelerStamm;
    }

    public static void setSchuelerStamm(int schuelerStamm) {
        Schueler.schuelerStamm = schuelerStamm;
    }
}
