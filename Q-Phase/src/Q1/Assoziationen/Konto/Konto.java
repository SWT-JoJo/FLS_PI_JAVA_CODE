package Q1.Assoziationen.Konto;

public class Konto {
    private String kontotyp;
    private int kontoNr;
    private static int autowert = 50000;

    public Konto(String kontotyp){
        this.kontoNr = autowert++;
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
