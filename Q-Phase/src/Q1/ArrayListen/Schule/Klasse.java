package Q1.ArrayListen.Schule;


import java.util.ArrayList;

public class Klasse {
    private String name;
    private ArrayList<Schueler> meineSchueler = new ArrayList<>();

    private Tutor meinTutor;

    public Klasse(String name){
        this.name = name;
    }



    public void ausgabe(){
        int counter = 1; //format
        for(Schueler  tempSchueler: meineSchueler){
            System.out.println(counter + ". " + tempSchueler.getName());
            counter ++;
        }
    }
    public void neueSchueler(String name){
        meineSchueler.add(new Schueler(name));
        System.out.println("Schüler erfolgreich hinzugefügt");
    }


    //Getter + Setter
    public void setMeineSchüler(ArrayList<Schueler> meineSchueler) {
        this.meineSchueler = meineSchueler;
    }
    public Tutor getMeinTutor() {
        return meinTutor;
    }

    public void setMeinTutor(Tutor meinTutor) {
        this.meinTutor = meinTutor;
    }
    public void setName(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public ArrayList<Schueler> getMeineSchüler() {
        return meineSchueler;
    }
}
