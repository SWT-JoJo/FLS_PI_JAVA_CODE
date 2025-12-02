package Q3.ListenUpFabianListenV2.LinkedList.SingleLinkedList;


public class ADListe {
    private Knoten zeigerErsterKnoten;

    public ADListe(Knoten zeigerErsterKnoten) {
        this.zeigerErsterKnoten = zeigerErsterKnoten;
    }

    public Knoten getZeigerErsterKnoten() {
        return zeigerErsterKnoten;
    }

    public void setZeigerErsterKnoten(Knoten zeigerErsterKnoten) {
        this.zeigerErsterKnoten = zeigerErsterKnoten;
    }

    public boolean isListeLeer() {
        return zeigerErsterKnoten == null;
    }

    public void neuenKnotenHinzufuegenVorne(String daten){
        Knoten neuerKnoten = new Knoten(daten);
        neuerKnoten.setNaechsterKnoten(zeigerErsterKnoten);
        zeigerErsterKnoten = neuerKnoten;

        System.out.println("Knoten hinzugefuegt");
    }

    public void neuenKnotenHinzufuegenHinten(String daten){
        Knoten curKnoten = zeigerErsterKnoten;

        while (curKnoten.getNaechsterKnoten() != null) {
            curKnoten = curKnoten.getNaechsterKnoten();
        }

        curKnoten.setNaechsterKnoten(new Knoten(daten));

        System.out.println("Knoten hinzugefuegt");

    }

    public void auslesenAllerKnotenVonVorne(){
        String data = "";
        Knoten knoten = zeigerErsterKnoten;
        int counter = 1;
        while (knoten != null){
            data += counter + ".\t" + knoten.getDaten() + "\n";
            knoten = knoten.getNaechsterKnoten();
            counter++;
        }

        System.out.println("Daten der Liste: \n" + data);
    }

    public Knoten sucheDatenVonVorne(String daten){
        Knoten knoten = zeigerErsterKnoten;
        while (knoten.getNaechsterKnoten() != null){
            if(knoten.getDaten().equals(daten)){
                return knoten;
            }

            knoten = knoten.getNaechsterKnoten();
        }

        return null;
    }
}
