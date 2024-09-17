package Q1.Vererbung.Mitarbeiter;

public class Akkordarbeiter extends Arbeiter{

    public void kennung(String firma) {
        System.out.println("Ich bin ein Akkordarbeiter der " + firma + ".");
    }

    public void einkommen(int produzierteMenge, int minutenProStuek, double minutenFaktor){
        super.einkommen = produzierteMenge * minutenProStuek * minutenFaktor;

    }
}
