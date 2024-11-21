package Q1.Vererbung.Tier;

public class Daemonenhund extends Hund{
    protected int verderbtheit, anzSeelen;

    public Daemonenhund(int anzSeelen, int hechelfrequenz){
        super(hechelfrequenz);
        this.anzSeelen = anzSeelen;
        verderbtheit = anzSeelen * hechelfrequenz;
    }
}

