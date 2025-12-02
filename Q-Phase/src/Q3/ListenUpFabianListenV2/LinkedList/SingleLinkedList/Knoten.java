package Q3.ListenUpFabianListenV2.LinkedList.SingleLinkedList;

public class Knoten {

    String daten;
    private Knoten naechsterKnoten;

    Knoten(String daten) {
        this.daten = daten;
        naechsterKnoten = null;
    }

    public void setDaten(String daten) {
        this.daten = daten;
    }

    public String getDaten() {
        return daten;
    }

    public Knoten getNaechsterKnoten(){
        return naechsterKnoten;
    }

    public void setNaechsterKnoten(Knoten zeigerAufNaechstenKnoten) {
        this.naechsterKnoten = zeigerAufNaechstenKnoten;
    }
}
