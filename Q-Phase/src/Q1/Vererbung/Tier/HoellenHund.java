package Q1.Vererbung.Tier;

public class HoellenHund extends Daemonenhund{
    protected int verderblichkeitsfaktor, gefaehlichkeit;

    public HoellenHund(int verderblichkeitsfaktor,int anzSeelen ,int hechelfrequenz){
        super(anzSeelen, hechelfrequenz);
        this.verderblichkeitsfaktor = verderblichkeitsfaktor;
        verderbtheit = 17;
        gefaehlichkeit = verderbtheit * verderblichkeitsfaktor;

    }
}
