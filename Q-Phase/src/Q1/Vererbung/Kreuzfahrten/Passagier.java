package Q1.Vererbung.Kreuzfahrten;

public class Passagier {
    private final String vorname, nachname;
    public Passagier(String  vn, String nn){
        vorname = vn;
        nachname = nn;
    }

    public String toString(){
        return vorname + " " + nachname;
    }
}
