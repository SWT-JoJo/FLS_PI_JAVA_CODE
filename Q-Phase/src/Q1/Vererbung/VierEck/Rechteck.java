package Q1.Vererbung.VierEck;

public class Rechteck extends Viereck {
    public Rechteck(double laenge, double hoehe){
        super.hoehe = hoehe;
        super.laenge = laenge;

    }
    public double diagronaleBerrechnen(){
        return Math.sqrt((Math.pow(super.laenge, 2) +Math.pow(super.hoehe, 2)));
    }
}
