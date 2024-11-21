package E2.OOP.Spritpreise;

public class Verbrauch {

    private final double strecke;
    private final double spritMenge;
    private final double spritPreis;

    public Verbrauch(double strecke ,double spritMenge, double spritPreis){
        this.strecke = strecke;
        this.spritMenge = spritMenge;
        this.spritPreis = spritPreis;
    }

    public double verbrauchPro100Km(){
        return (spritMenge * 100) / strecke;
    }

    public double kostenPro100Km(){
        return verbrauchPro100Km() * spritPreis;
    }

    public double kostenPro1Km(){
            return (spritMenge / strecke) * spritPreis;
    }

    public double streckeMit1Liter(){
        return strecke / spritMenge;
    }

}
