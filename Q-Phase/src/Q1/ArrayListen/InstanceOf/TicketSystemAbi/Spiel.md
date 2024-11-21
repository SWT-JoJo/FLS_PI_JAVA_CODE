````java
import java.util.ArrayList;

public class Spiel {
    private int spielNr;
    private DateTime zeit;
    private String team1;
    private String team2;
    private String stadionName;
    
    private ArrayList<Reservierung> reservierungen;
    private ArrayList<Block> bloecke;

    public Spiel(int spielNr, DateTime zeit, String stadion) {
        this.spielNr = spielNr;
        this.zeit = zeit;
        this.stadionName = stadion;
        reservierungen = new ArrayList<Reservierung>();
        bloecke = new ArrayList<Block>();
        bloecke.add(new Block("Nord"));
        bloecke.add(new Block("Süd"));
        bloecke.add(new Block("West"));
        bloecke.add(new Block("Ost"));
        
    }

    public löscheReservierung(Reservierung r) {
        reservierungen.remove(r);
    }
    
    public Block sucheBlock(String bezeichnung){
        Block rBlock; 
        boolean blockfound = false;
        for(Block tBlock : bloecke){
            if(tBlock.getBezeichnung.equals(bezeichnung)){
                rBlock = tblock;
                blockfound = true;
                break;
            }
        }
        
        if (blockfound){
            return rBlock;
        }
        else{
            return null;
        }
    }
    
    public void hinzuguegenReservierung(Reservierung r){
        reservierungen.add(r);
    }
}
````