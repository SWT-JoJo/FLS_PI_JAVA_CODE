package Q1.Vererbung.Mitarbeiter;

public class Mitarbeiter {
    protected String firma;
    protected String nachName;
    protected double einkommen;

    public Mitarbeiter() {
        this.firma = "Friedrich-List OHG";
        this.einkommen = 0;
    }
    public void kennung() {
        System.out.println("Ich bin ein Mitarbeiter der " + this.firma + "." );
    }
    public void setName(String n){
        this.nachName = n;
    }
    public String getName(){
        return nachName;
    }
    public void abrechnung(){
        System.out.println("Das Einkommen betraegt: " + einkommen + " Euro." );
    }
}

