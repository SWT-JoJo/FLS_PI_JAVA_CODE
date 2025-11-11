````java
public class Block{
    private static final int REIHEN = 500;
    private static final int PLAETZE = 200;
    private String bezeichnung;
    
    private boolean[][] belegung = new boolean[REIHEN] [PLAETZE]; //false = frei, true = belegt
    
    public Block(String bezeichnung){
        this.bezeichnung = bezeichnung;
    }
    public boolean istFrei(int reihe, int platz){
        return !belegung[reihe][platz]; //wenn frei (false) return true, sonnst wenn belegt (true) return false
    }
    
    public void belegePlatz(int reihe, int platz){
        belegung[reihe][platz] = true;
    }
    
    public void gibPlatzFrei(int reihe, int platz){
        belegung[reihe][platz] = false;
    }
    
}
````