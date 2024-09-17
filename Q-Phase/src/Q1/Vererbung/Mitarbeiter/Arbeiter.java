package Q1.Vererbung.Mitarbeiter;

public class Arbeiter extends Mitarbeiter {

    public void kennung(String firma){
        System.out.println("Ich bin ein Arbeiter der " + firma + ".");
    }

    public void seteinkommen(double stdLohn , int stunden){

        super.einkommen = stdLohn * stunden;
    }

    public void seteinkommen(int stunden){
        super.einkommen = stunden * 18;
    }

    public void seteinkommen(){
        super.einkommen = 140 * 18;
    }
}
