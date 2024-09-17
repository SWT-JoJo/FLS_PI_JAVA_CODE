package Q1.Vererbung.Mitarbeiter;

public class Angestellter extends Mitarbeiter{
    //    Erweiterung der Klasse Mitarbeiter1
    public void arbeitsplatz() {
        System.out.println("Ich arbeite im Buero!" );
    }
    public void setEinkommen(double ek){
       this.einkommen = ek;
    }
    public void kennung() {
        System.out.println("Ich bin ein Angestellter der " + this.firma +
                ".");
    }
    public void kennung(String f) {
        firma = f;
        System.out.println("Ich bin ein Angestellter der " + this.firma + ".");
    }
}
