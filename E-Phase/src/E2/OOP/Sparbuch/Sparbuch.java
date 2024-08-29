package E2.OOP.Sparbuch;

public class Sparbuch {

    private double kontostand = 1000.0;
    private String name;
    private final double  zinssatz = 3.5;

    public double getKontostand() {
        return kontostand;
    }

    public void setKontostand(double kontostand) {
        this.kontostand = kontostand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getZinssatz() {
        return zinssatz;
    }


    public void buchen(double betrag){
            kontostand += betrag;
    }
    public double zinsenBerrechnen(){
        double zinsen = (kontostand * (zinssatz / 100.0));
        return zinsen;
    }

}
