package Q1.Vererbung.VierEck;

public class Quadrat extends Viereck{

    public Quadrat(double laenge){
        super.laenge = laenge;
        super.hoehe = laenge;
    }

    public double diagronaleBerrechnen(){
        return Math.sqrt((Math.pow(super.laenge, 2) +Math.pow(super.hoehe, 2)));
   }
}
