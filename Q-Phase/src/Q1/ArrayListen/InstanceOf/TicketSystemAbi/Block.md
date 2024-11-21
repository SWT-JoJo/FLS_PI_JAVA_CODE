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
        boolean temp;
        if(!belegung[reihe][platz]){
            temp = true;
        }
        else {
          temp =  false;
        }
        
        return temp;
    }
    
    public void belegePlatz(int reihe, int platz){
        belegung[reihe][platz] = true;
    }
    
    public void gibPlatzFrei(int reihe, int platz){
        belegung[reihe][platz] = false;
    }
    
}
````