package Q1.Assoziationen.KontoV2;

public class Konto {
    private String kontotyp;
    private int kontoNr;

    public Konto(String kontotyp, int kontoNr){
        this.kontoNr = kontoNr;
        this.kontotyp = kontotyp;
    }

    public String getKontotyp() {
        return kontotyp;
    }

    public void setKontotyp(String kontotyp) {
        this.kontotyp = kontotyp;
    }

    public int getKontoNr() {
        return kontoNr;
    }

    public void setKontoNr(int kontoNr) {
        this.kontoNr = kontoNr;
    }




}
